/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.forms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import lp.condominios.models.Apartamento;
import lp.condominios.models.ApartamentoJpaController;
import lp.condominios.models.Movimento;
import lp.condominios.models.MovimentoJpaController;

/**
 *
 * @author Pedro
 */
public class frameQuotas extends javax.swing.JFrame {

    private double GetDespesas(int Mes, int Ano) {
        double d = 0;
        
        MovimentoJpaController controller = new MovimentoJpaController(entityManager1.getEntityManagerFactory());
        
        for (Movimento movimento : controller.findMovimentoEntities()) {
            if (Mes == movimento.getMes() && Ano == movimento.getAno()) {            
                d += movimento.getValor().doubleValue();
            }
        }
        
        return d;
    }
    
    private int GetTotalQuartos() {
        int total = 0;
        
        ApartamentoJpaController controller = new ApartamentoJpaController(entityManager1.getEntityManagerFactory());
        
        for (Apartamento apartamento : controller.findApartamentoEntities()) {
            total += apartamento.getQuartos();
        }
        
        return total;
    }
    
    /**
     * Creates new form frameQuotas
     */
    public frameQuotas() {
        initComponents();
        
        Integer ano = (new Date()).getYear() + 1900;
        txtAno.setText(ano.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("lp.condominiosPU").createEntityManager();
        txtMes = new javax.swing.JComboBox();
        txtAno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTotal = new javax.swing.JTextArea();

        setTitle("Quotas a pagar");

        txtMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel1.setText("Seleccione um mês");

        btnOK.setText("Mostrar");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtTotal.setColumns(20);
        txtTotal.setRows(5);
        jScrollPane1.setViewportView(txtTotal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        Integer quartos = GetTotalQuartos();
        
        String str = "Total de quartos: " + quartos.toString() + "\n\n";
        
        double d = GetDespesas(Integer.parseInt(txtMes.getSelectedItem().toString()), 
                Integer.parseInt(txtAno.getText()));
        double d3 = d / quartos;
        
        // somar as despesas
        ApartamentoJpaController controller = new ApartamentoJpaController(entityManager1.getEntityManagerFactory());
        
        for (Apartamento apartamento : controller.findApartamentoEntities()) {
            double d2 = d3;
            d2 += apartamento.getQuartos();
            
            str += "Apartamento " + apartamento.getNporta() + 
                    ", Despesa  " + new BigDecimal(d).setScale(2, RoundingMode.CEILING).toString() + 
                    ", Quartos " + apartamento.getQuartos() + 
                    " = " + new BigDecimal(d2).setScale(2, RoundingMode.CEILING).toString() + "\n";
        }
        
        txtTotal.setText(str);        
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameQuotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameQuotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameQuotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameQuotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frameQuotas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAno;
    private javax.swing.JComboBox txtMes;
    private javax.swing.JTextArea txtTotal;
    // End of variables declaration//GEN-END:variables
}