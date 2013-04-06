/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.enums;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lp.condominios.models.Apartamento;
import lp.condominios.models.ApartamentoJpaController;
import lp.condominios.models.Proprietario;
import lp.condominios.models.ProprietarioJpaController;

/**
 *
 * @author Pedro
 */
public class ApartamentoModelList  extends AbstractListModel implements ComboBoxModel {

    private ArrayList<Apartamento> lst = new ArrayList<>();
    private Object item;
    private ApartamentoJpaController controller;

    public ApartamentoModelList(EntityManagerFactory emf) {
        controller = new ApartamentoJpaController(emf);
         
         for (Apartamento apartamento : controller.findApartamentoEntities()) {
            lst.add(apartamento);
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
