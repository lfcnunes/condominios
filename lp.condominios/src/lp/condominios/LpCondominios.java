/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios;

import lp.condominios.forms.frameMain;

/**
 *
 * @author Pedro
 */
public class LpCondominios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      	Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameMain frm = new frameMain();
                frm.setVisible(true);
            }
        });
        thread.start();
    }
}
