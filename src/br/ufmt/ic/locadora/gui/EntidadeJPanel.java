/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.gui;

import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.exception.CNPJException;
import br.ufmt.ic.locadora.tablemodel.EntidadeTableModel;
import javax.swing.JOptionPane;
import br.ufmt.ic.locadora.util.FabricaDAO;
import br.ufmt.ic.locadora.util.FabricaTela;

/**
 *
 * @author brunosette
 */
public class EntidadeJPanel extends FabricaTela {
    EntidadeDAO dao = FabricaDAO.CriarEntidadeDAO();
    private EntidadeTableModel tableModel;
    private boolean editar = false;
    private int linhaSelecionada;
    private Entidade chave;    
    
    /**
     * Creates new form EntidadeJPanel
     */
    public EntidadeJPanel() {
        tableModel = new EntidadeTableModel(dao.listar());
        initComponents();
        bancojComboBox = super.setComboBanco(bancojComboBox);
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
        funcionariojTable = new javax.swing.JTable();
        excluirjButton = new javax.swing.JButton();
        editarjButton1 = new javax.swing.JButton();
        celularjFormattedTextField = new javax.swing.JFormattedTextField();
        nomejLabel = new javax.swing.JLabel();
        nomejTextField = new javax.swing.JTextField();
        telefonejLabel = new javax.swing.JLabel();
        celularjLabel = new javax.swing.JLabel();
        emailjTextField = new javax.swing.JTextField();
        emailjLabel = new javax.swing.JLabel();
        cpfjLabel = new javax.swing.JLabel();
        cnpjjFormattedTextField = new javax.swing.JFormattedTextField();
        telefonejFormattedTextField = new javax.swing.JFormattedTextField();
        nomejLabel1 = new javax.swing.JLabel();
        razaojTextField = new javax.swing.JTextField();
        nacionalidadejLabel3 = new javax.swing.JLabel();
        ccjTextField = new javax.swing.JTextField();
        nacionalidadejLabel7 = new javax.swing.JLabel();
        ruajTextField = new javax.swing.JTextField();
        ruajLabel = new javax.swing.JLabel();
        complementojTextField = new javax.swing.JTextField();
        complementojLabel = new javax.swing.JLabel();
        bairrojTextField = new javax.swing.JTextField();
        numerojTextField = new javax.swing.JTextField();
        ruajLabel1 = new javax.swing.JLabel();
        bairrojLabel = new javax.swing.JLabel();
        cepjLabel = new javax.swing.JLabel();
        cidadejTextField = new javax.swing.JTextField();
        cidadejLabel = new javax.swing.JLabel();
        estadojLabel = new javax.swing.JLabel();
        cepjFormattedTextField = new javax.swing.JFormattedTextField();
        estadojTextField = new javax.swing.JTextField();
        editarjButton = new javax.swing.JButton();
        excluirjButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        entidadejTable = new javax.swing.JTable();
        limparjButton = new javax.swing.JButton();
        cadastrarjButton = new javax.swing.JButton();
        bancojComboBox = new javax.swing.JComboBox();

        funcionariojTable.setModel(tableModel);
        jScrollPane1.setViewportView(funcionariojTable);

        excluirjButton.setText("Excluir");
        excluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjButtonActionPerformed(evt);
            }
        });

        editarjButton1.setText("Editar");
        editarjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButton1ActionPerformed(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createTitledBorder(null, "Entidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 18)))); // NOI18N

        try {
            celularjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        nomejLabel.setText("Nome:");

        nomejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomejTextFieldActionPerformed(evt);
            }
        });

        telefonejLabel.setText("Telefone:");

        celularjLabel.setText("Celular:");

        emailjLabel.setText("Email:");

        cpfjLabel.setText("CNPJ:");

        try {
            cnpjjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            telefonejFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        nomejLabel1.setText("Razão:");

        nacionalidadejLabel3.setText("Banco:");

        ccjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccjTextFieldActionPerformed(evt);
            }
        });

        nacionalidadejLabel7.setText("CC:");

        ruajLabel.setText("Rua:");

        complementojLabel.setText("Complemento:");

        ruajLabel1.setText("Numero:");

        bairrojLabel.setText("Bairro:");

        cepjLabel.setText("Cep:");

        cidadejLabel.setText("Cidade:");

        estadojLabel.setText("Estado:");

        try {
            cepjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        editarjButton.setText("Editar");
        editarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButtonActionPerformed(evt);
            }
        });

        excluirjButton1.setText("Excluir");
        excluirjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjButton1ActionPerformed(evt);
            }
        });

        entidadejTable.setModel(tableModel);
        jScrollPane2.setViewportView(entidadejTable);

        limparjButton.setText("Limpar");
        limparjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparjButtonActionPerformed(evt);
            }
        });

        cadastrarjButton.setText("Cadastrar");
        cadastrarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarjButtonActionPerformed(evt);
            }
        });

        bancojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nacionalidadejLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bancojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nacionalidadejLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonejLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(celularjLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(emailjLabel)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(celularjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpfjLabel)
                            .addComponent(nomejLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cnpjjFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(nomejTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomejLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(razaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(estadojLabel)
                                    .addComponent(ruajLabel1)
                                    .addComponent(cidadejLabel)
                                    .addComponent(cepjLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cepjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(ruajLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ruajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(bairrojLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bairrojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(complementojLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(complementojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(excluirjButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(limparjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastrarjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(razaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomejLabel1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ruajLabel)
                                        .addComponent(ruajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editarjButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(complementojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(complementojLabel)
                                        .addComponent(excluirjButton1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bairrojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bairrojLabel)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nomejLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cpfjLabel)
                                        .addComponent(cnpjjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefonejLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(celularjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(celularjLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailjLabel)
                                .addComponent(emailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cepjLabel)
                            .addComponent(cepjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidadejLabel)
                            .addComponent(cidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadojLabel)
                            .addComponent(estadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ruajLabel1)
                            .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limparjButton)
                            .addComponent(cadastrarjButton))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nacionalidadejLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bancojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ccjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nacionalidadejLabel7))
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ccjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccjTextFieldActionPerformed

    private void editarjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_editarjButton1ActionPerformed

    private void excluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButtonActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_excluirjButtonActionPerformed

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:
        if (entidadejTable.getSelectedRowCount() == 1) {
            linhaSelecionada = entidadejTable.getSelectedRow();
            Entidade selecionado = tableModel.getEntidade(linhaSelecionada);

            nomejTextField.setText(selecionado.getNome());
            razaojTextField.setText(selecionado.getRazaoSocial());
            telefonejFormattedTextField.setText(selecionado.getTelefone());
            celularjFormattedTextField.setText(selecionado.getCelular());
            emailjTextField.setText(selecionado.getEmail());
            cnpjjFormattedTextField.setText(selecionado.getCnpj());

            cepjFormattedTextField.setText(selecionado.getEndereco().getCep());
            ruajTextField.setText(selecionado.getEndereco().getRua());
            bairrojTextField.setText(selecionado.getEndereco().getBairro());
            estadojTextField.setText(selecionado.getEndereco().getEstado());
            cidadejTextField.setText(selecionado.getEndereco().getCidade());
            numerojTextField.setText(selecionado.getEndereco().getNumero());
            complementojTextField.setText(selecionado.getEndereco().getComplemento());
            
            
            for (int i = 1; i < bancojComboBox.getItemCount(); i++) {
               Banco banco = (Banco)bancojComboBox.getItemAt(i);
               if (banco.getNome().equals(selecionado.getConta().getBanco().getNome())){
                   bancojComboBox.setSelectedIndex(i);
               }
            }
            
            ccjTextField.setText(selecionado.getConta().getContaNumero());
            
            bancojComboBox.setSelectedItem(selecionado.getConta().getBanco());
            chave = selecionado;
            editar = true;
        } else {
            JOptionPane.showMessageDialog(this, "Selecione somente 1 linha!");
        }
    }//GEN-LAST:event_editarjButtonActionPerformed

    private void excluirjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButton1ActionPerformed
        // TODO add your handling code here:
        if (entidadejTable.getSelectedRowCount() > 0) {
            int confirmacao = JOptionPane.showConfirmDialog(entidadejTable, "Confirma a exclusão?");
            if (confirmacao == JOptionPane.YES_OPTION) {
                linhaSelecionada = entidadejTable.getSelectedRow();
                Entidade selecionado = tableModel.getEntidade(linhaSelecionada);
                dao.remover(selecionado.getCnpj());
                tableModel.remover(linhaSelecionada, selecionado);
                JOptionPane.showMessageDialog(this, "Excluido com Sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos 1 linha!");
        }
    }//GEN-LAST:event_excluirjButton1ActionPerformed

    private void limparjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparjButtonActionPerformed
        // TODO add your handling code here:

        nomejTextField.setText("");
        telefonejFormattedTextField.setText("");
        celularjFormattedTextField.setText("");
        emailjTextField.setText("");
        cnpjjFormattedTextField.setText("");
        ruajTextField.setText("");
        complementojTextField.setText("");
        bairrojTextField.setText("");
        cepjFormattedTextField.setText("");
        cidadejTextField.setText("");
        estadojTextField.setText("");
        ccjTextField.setText("");
        numerojTextField.setText("");
        razaojTextField.setText("");
        bancojComboBox.setSelectedIndex(0);
        editar = false;
    }//GEN-LAST:event_limparjButtonActionPerformed

    private void cadastrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarjButtonActionPerformed
        // TODO add your handling code here:

        Entidade entidade = new Entidade();
        entidade.setNome(nomejTextField.getText());
        entidade.setRazaoSocial(razaojTextField.getText());
        entidade.setTelefone(telefonejFormattedTextField.getText());
        entidade.setCelular(celularjFormattedTextField.getText());
        entidade.setEmail(emailjTextField.getText());
        entidade.setCnpj(cnpjjFormattedTextField.getText());

        ContaBancaria conta = new ContaBancaria();
        
        if (ValidaCombo(bancojComboBox)){
            conta.setBanco((Banco) bancojComboBox.getSelectedItem());
        }else{
            bancojComboBox.grabFocus();
            return;
        }
        
        conta.setContaNumero(ccjTextField.getText());
        
        entidade.setConta(conta);

        Endereco end = new Endereco();
        end.setBairro(bairrojTextField.getText());
        end.setCep(cepjFormattedTextField.getText());
        end.setCidade(cidadejTextField.getText());
        end.setComplemento(complementojTextField.getText());
        end.setEstado(estadojTextField.getText());
        end.setNumero(numerojTextField.getText());
        end.setRua(ruajTextField.getText());

        entidade.setEndereco(end);

        try {
            if (editar) {
                dao.alterar(entidade, chave);
                JOptionPane.showMessageDialog(this, "Alterado!");
                tableModel.alterar(linhaSelecionada, entidade);
            } else {
                dao.inserir(entidade);
                JOptionPane.showMessageDialog(this, "Cadastrado!");
                tableModel.adicionar(entidade);
            }
            limparjButtonActionPerformed(null);
        } catch (CNPJException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
            cnpjjFormattedTextField.grabFocus();
        }
    }//GEN-LAST:event_cadastrarjButtonActionPerformed

    private void nomejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomejTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairrojLabel;
    private javax.swing.JTextField bairrojTextField;
    private javax.swing.JComboBox bancojComboBox;
    private javax.swing.JButton cadastrarjButton;
    private javax.swing.JTextField ccjTextField;
    private javax.swing.JFormattedTextField celularjFormattedTextField;
    private javax.swing.JLabel celularjLabel;
    private javax.swing.JFormattedTextField cepjFormattedTextField;
    private javax.swing.JLabel cepjLabel;
    private javax.swing.JLabel cidadejLabel;
    private javax.swing.JTextField cidadejTextField;
    private javax.swing.JFormattedTextField cnpjjFormattedTextField;
    private javax.swing.JLabel complementojLabel;
    private javax.swing.JTextField complementojTextField;
    private javax.swing.JLabel cpfjLabel;
    private javax.swing.JButton editarjButton;
    private javax.swing.JButton editarjButton1;
    private javax.swing.JLabel emailjLabel;
    private javax.swing.JTextField emailjTextField;
    private javax.swing.JTable entidadejTable;
    private javax.swing.JLabel estadojLabel;
    private javax.swing.JTextField estadojTextField;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JButton excluirjButton1;
    private javax.swing.JTable funcionariojTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparjButton;
    private javax.swing.JLabel nacionalidadejLabel3;
    private javax.swing.JLabel nacionalidadejLabel7;
    private javax.swing.JLabel nomejLabel;
    private javax.swing.JLabel nomejLabel1;
    private javax.swing.JTextField nomejTextField;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JTextField razaojTextField;
    private javax.swing.JLabel ruajLabel;
    private javax.swing.JLabel ruajLabel1;
    private javax.swing.JTextField ruajTextField;
    private javax.swing.JFormattedTextField telefonejFormattedTextField;
    private javax.swing.JLabel telefonejLabel;
    // End of variables declaration//GEN-END:variables
}
