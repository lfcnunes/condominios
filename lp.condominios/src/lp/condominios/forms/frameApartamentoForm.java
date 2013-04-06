/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.forms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lp.condominios.enums.Ocupacao;
import lp.condominios.enums.OcupacaoModelList;
import lp.condominios.enums.ProprietarioModeList;
import lp.condominios.enums.QuartoModelList;
import lp.condominios.models.Apartamento;
import lp.condominios.models.ApartamentoJpaController;
import lp.condominios.models.Proprietario;
import lp.condominios.models.exceptions.NonexistentEntityException;

/**
 *
 * @author Pedro
 */
public class frameApartamentoForm extends javax.swing.JFrame {

    private int intID;
    private ApartamentoJpaController controller;
    private Apartamento apartamento;
    
    /**
     * Creates new form frameApartamentoForm
     */
    public frameApartamentoForm() {
        initComponents();
    }
    
    public frameApartamentoForm(int ID) {
        this();
        
        this.intID = ID;
        
        // Conectar o apartamento
        controller = new ApartamentoJpaController(entityManager1.getEntityManagerFactory());
        
        // Carregar ocupacao
        cmbOcupacao.setModel(new OcupacaoModelList());
        cmbQuartos.setModel(new QuartoModelList());
        cmbProprietario.setModel(new ProprietarioModeList(entityManager1.getEntityManagerFactory()));
         
        if (intID == 0) {
            this.setTitle("Adicionar Apartamento");
            btnDelete.setVisible(false);
            
            apartamento = new Apartamento();
        } else {
            this.setTitle("Editar Apartamento: "  + intID);
            
            // Ler os dados da base de dados
            apartamento = controller.findApartamento(intID);
            
            txtID.setText(apartamento.getId().toString());
            txtNporta.setText(apartamento.getNporta().toString());
            cmbOcupacao.setSelectedIndex(apartamento.getOcupacao());
            cmbQuartos.setSelectedIndex(apartamento.getQuartos());
            cmbProprietario.setSelectedIndex(apartamento.getIdproprietario());     
        }             
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
        btnOK = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblNPorta = new javax.swing.JLabel();
        lblQuartos = new javax.swing.JLabel();
        lblOcupacao = new javax.swing.JLabel();
        lblProprietario = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNporta = new javax.swing.JTextField();
        cmbOcupacao = new javax.swing.JComboBox();
        cmbProprietario = new javax.swing.JComboBox();
        cmbQuartos = new javax.swing.JComboBox();

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnClose.setText("Sair");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Apagar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblID.setText("ID");

        lblNPorta.setText("Porta");

        lblQuartos.setText("Quartos");

        lblOcupacao.setText("Ocupação");

        lblProprietario.setText("Proprietário");

        txtID.setText("0");
        txtID.setEnabled(false);

        cmbOcupacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbProprietario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbQuartos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 203, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID)
                            .addComponent(lblNPorta)
                            .addComponent(lblQuartos))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNporta)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProprietario)
                            .addComponent(lblOcupacao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOcupacao, 0, 125, Short.MAX_VALUE)
                            .addComponent(cmbProprietario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNporta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNPorta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuartos)
                            .addComponent(cmbQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcupacao)
                    .addComponent(cmbOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProprietario)
                    .addComponent(cmbProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnClose)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            controller.destroy(intID);
            btnCloseActionPerformed(evt);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(frameApartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, "Erro ao apagar o registo.", "Apagar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
       if (apartamento == null) {
           JOptionPane.showMessageDialog(null, "Ocorreu um erro o apartamento não foi encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
       }
       
        try {
            apartamento.setNporta(Integer.parseInt(txtNporta.getText()));
            apartamento.setQuartos(Integer.parseInt(cmbQuartos.getSelectedItem().toString()));
            apartamento.setOcupacao(((Ocupacao)cmbOcupacao.getSelectedItem()).getId());
            apartamento.setIdproprietario(((Proprietario)cmbProprietario.getSelectedItem()).getId());
           
            if (intID == 0) {
                controller.create(apartamento);                           
            } else {
                controller.edit(apartamento);
            }
            
            btnCloseActionPerformed(evt);            
       
        } catch (Exception ex) {
            Logger.getLogger(frameProprietarioForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro gravar o apartamento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }      
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox cmbOcupacao;
    private javax.swing.JComboBox cmbProprietario;
    private javax.swing.JComboBox cmbQuartos;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNPorta;
    private javax.swing.JLabel lblOcupacao;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblQuartos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNporta;
    // End of variables declaration//GEN-END:variables
}