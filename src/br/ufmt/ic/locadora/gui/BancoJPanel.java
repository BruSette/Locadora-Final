/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.gui;

import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.util.FabricaDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.tablemodel.BancoTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author brunosette
 */
public class BancoJPanel extends javax.swing.JPanel {

    private BancoDAO dao = FabricaDAO.CriarBancoDAO();
    private BancoTableModel tableModel = new BancoTableModel(dao.listar());
    private boolean editar = false;
    private int linhaSelecionada;
    private Banco chave;
    
    
    /**
     * Creates new form BancoJPanel
     */
    public BancoJPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        bancojTable = new javax.swing.JTable();
        editarjButton = new javax.swing.JButton();
        escluirjButton = new javax.swing.JButton();
        limparjButton = new javax.swing.JButton();
        cadastrarjButton = new javax.swing.JButton();
        codjTextField = new javax.swing.JTextField();
        estadojLabel = new javax.swing.JLabel();
        cidadejLabel = new javax.swing.JLabel();
        nomejTextField = new javax.swing.JTextField();

        bancojTable.setModel(tableModel);
        jScrollPane1.setViewportView(bancojTable);

        editarjButton.setText("Editar");
        editarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButtonActionPerformed(evt);
            }
        });

        escluirjButton.setText("Excluir");
        escluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escluirjButtonActionPerformed(evt);
            }
        });

        limparjButton.setText("Limpar");
        limparjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparjButtonActionPerformed(evt);
            }
        });

        cadastrarjButton.setText("Salvar");
        cadastrarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarjButtonActionPerformed(evt);
            }
        });

        estadojLabel.setText("Cod:");

        cidadejLabel.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(248, 248, 248)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(limparjButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastrarjButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(estadojLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(codjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cidadejLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(escluirjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cidadejLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estadojLabel))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limparjButton)
                        .addComponent(cadastrarjButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(editarjButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(escluirjButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:

        if (bancojTable.getSelectedRowCount() == 1) {
            linhaSelecionada = bancojTable.getSelectedRow();
            Banco selecionado = tableModel.getBanco(linhaSelecionada);

            nomejTextField.setText(selecionado.getNome());
            codjTextField.setText(selecionado.getCod());
            
            chave = selecionado;
            editar = true;
        } else {
            JOptionPane.showMessageDialog(this, "Selecione somente 1 linha!");
        }
    }//GEN-LAST:event_editarjButtonActionPerformed

    private void escluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escluirjButtonActionPerformed
        // TODO add your handling code here:
        if (bancojTable.getSelectedRowCount() > 0) {
            int confirmacao = JOptionPane.showConfirmDialog(bancojTable, "Confirma a exclusão?");
            if (confirmacao == JOptionPane.YES_OPTION) {
                linhaSelecionada = bancojTable.getSelectedRow();
                Banco selecionado = tableModel.getBanco(linhaSelecionada);
                dao.remover(selecionado);
                tableModel.remover(linhaSelecionada, selecionado);
                JOptionPane.showMessageDialog(this, "Excluido com Sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos 1 linha!");
        }

    }//GEN-LAST:event_escluirjButtonActionPerformed

    private void limparjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparjButtonActionPerformed
        // TODO add your handling code here:

       
        nomejTextField.setText("");
        codjTextField.setText("");
        
        editar = false;

    }//GEN-LAST:event_limparjButtonActionPerformed

    private void cadastrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarjButtonActionPerformed
        // TODO add your handling code here:
        Banco novo = new Banco();
        novo.setNome(nomejTextField.getText());
        novo.setCod(codjTextField.getText());
       
        
        try {
            if (editar) {
                dao.alterar(novo, chave);
                JOptionPane.showMessageDialog(this, "Alterado com Sucesso!");
                tableModel.alterar(linhaSelecionada, novo);
            } else {
                dao.inserir(novo);
                JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso!");
                tableModel.adicionar(novo);
            }
            limparjButtonActionPerformed(null);
        } catch (RegistroException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
            nomejTextField.grabFocus();
        }

    }//GEN-LAST:event_cadastrarjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bancojTable;
    private javax.swing.JButton cadastrarjButton;
    private javax.swing.JLabel cidadejLabel;
    private javax.swing.JTextField codjTextField;
    private javax.swing.JButton editarjButton;
    private javax.swing.JButton escluirjButton;
    private javax.swing.JLabel estadojLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparjButton;
    private javax.swing.JTextField nomejTextField;
    // End of variables declaration//GEN-END:variables
}
