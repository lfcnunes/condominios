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
public class QuartoModelList extends AbstractListModel implements ComboBoxModel  {

    private ArrayList<Integer> lst = new ArrayList<>();
    private Object item;

    public QuartoModelList() {
        for (int i = 1; i < 7; i++) {
            lst.add(i);
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
