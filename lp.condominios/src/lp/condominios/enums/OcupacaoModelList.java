/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.enums;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Pedro
 */
public class OcupacaoModelList extends AbstractListModel implements ComboBoxModel {

    private ArrayList<Ocupacao> lst = new ArrayList<>();
    private Object item;
    
    public OcupacaoModelList() {
        lst.add(new Ocupacao(1, "Proprietário"));
        lst.add(new Ocupacao(2, "Inquilino"));
        lst.add(new Ocupacao(3, "Vazio"));                
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
