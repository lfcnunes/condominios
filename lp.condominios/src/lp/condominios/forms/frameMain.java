/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.forms;

import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class frameMain extends javax.swing.JFrame {

    /**
     * Creates new form frameMain
     */
    public frameMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenuItem();
        mnuTables = new javax.swing.JMenu();
        mnuProprietario = new javax.swing.JMenuItem();
        mnuApartamento = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuMovimentos = new javax.swing.JMenuItem();
        mnuReports = new javax.swing.JMenu();
        menuTotalQuartos = new javax.swing.JMenuItem();
        mnuQuotas = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Condominios");

        mnuFile.setText("Ficheiro");

        mnuExit.setText("Sair");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        mnuTables.setText("Tabelas");

        mnuProprietario.setText("Proprietário");
        mnuProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProprietarioActionPerformed(evt);
            }
        });
        mnuTables.add(mnuProprietario);

        mnuApartamento.setText("Apartamento");
        mnuApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuApartamentoActionPerformed(evt);
            }
        });
        mnuTables.add(mnuApartamento);
        mnuTables.add(jSeparator1);

        menuMovimentos.setText("Movimentos");
        menuMovimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMovimentosActionPerformed(evt);
            }
        });
        mnuTables.add(menuMovimentos);

        jMenuBar1.add(mnuTables);

        mnuReports.setText("Relatórios");

        menuTotalQuartos.setText("Total de quartos");
        menuTotalQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTotalQuartosActionPerformed(evt);
            }
        });
        mnuReports.add(menuTotalQuartos);

        mnuQuotas.setText("Quotas a pagar");
        mnuQuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuotasActionPerformed(evt);
            }
        });
        mnuReports.add(mnuQuotas);

        jMenuBar1.add(mnuReports);

        mnuHelp.setText("Ajuda");

        mnuAbout.setText("Acerca de...");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProprietarioActionPerformed
       	Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameProprietarioList frm = new frameProprietarioList();
                frm.setVisible(true);
            }
        });
        thread.start();
    }//GEN-LAST:event_mnuProprietarioActionPerformed

    private void mnuApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuApartamentoActionPerformed
        Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameApartamentoList frm = new frameApartamentoList();
                frm.setVisible(true);
            }
        });
        thread.start();
    }//GEN-LAST:event_mnuApartamentoActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void menuMovimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMovimentosActionPerformed
        Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameMovimentoList frm = new frameMovimentoList();
                frm.setVisible(true);
            }
        });
        thread.start();
    }//GEN-LAST:event_menuMovimentosActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        JOptionPane.showMessageDialog(null, "Desenvolvido por Luis Nunes \n\n " + 
                "no âmbito da disciplina de Laboratórios de Programação " + 
                "(2013)", 
                "Acerca de", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_mnuAboutActionPerformed

    private void menuTotalQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTotalQuartosActionPerformed
        Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameTotalQuartos frm = new frameTotalQuartos();
                frm.setVisible(true);
            }
        });
        thread.start();
    }//GEN-LAST:event_menuTotalQuartosActionPerformed

    private void mnuQuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQuotasActionPerformed
        Thread thread = new Thread(new Runnable() {
        @Override
            public void run() {
                frameQuotas frm = new frameQuotas();
                frm.setVisible(true);
            }
        });
        thread.start();
    }//GEN-LAST:event_mnuQuotasActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuMovimentos;
    private javax.swing.JMenuItem menuTotalQuartos;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuApartamento;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuProprietario;
    private javax.swing.JMenuItem mnuQuotas;
    private javax.swing.JMenu mnuReports;
    private javax.swing.JMenu mnuTables;
    // End of variables declaration//GEN-END:variables
}
