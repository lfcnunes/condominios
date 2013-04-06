/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.enums;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lp.condominios.models.Proprietario;
import lp.condominios.models.ProprietarioJpaController;

/**
 *
 * @author Pedro
 */
public class ProprietarioModeList extends AbstractListModel implements ComboBoxModel {

    private ArrayList<Proprietario> lst = new ArrayList<>();
    private Object item;
    private ProprietarioJpaController controller;
    
    public ProprietarioModeList(EntityManagerFactory emf) {        
         controller = new ProprietarioJpaController(emf);
         
         for (Proprietario proprietario : controller.findProprietarioEntities()) {
            lst.add(proprietario);
        }
    }

    
    @Override
    public int getSize() {
       return lst.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lst.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
