/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class FornecedorTableModel extends AbstractTableModel {
    private List<Fornecedor> dornecedores;
    private String[] header = new String[]{"CNPJ", "Nome", "Telefone"};

    public FornecedorTableModel(List<Fornecedor> List) {
        dornecedores = new ArrayList<>(List);
    }
    
    

    @Override
    public int getRowCount() {
        return dornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String valor = null;
        Fornecedor selecionado = dornecedores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getCnpj();
                break;
            case 1:
                valor = selecionado.getNome();
                break;
            case 2:
                valor = selecionado.getTelefone();
                break;
        }
        return valor;
    }

    public void adicionar(Fornecedor fornecedor) {
        dornecedores.add(fornecedor);
        int ultima = dornecedores.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Fornecedor fornecedor) {
        dornecedores.set(index, fornecedor);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Fornecedor fornecedor){
        dornecedores.remove(fornecedor);
        int ultima = dornecedores.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }

    public Fornecedor getFornecedor(int index) {
        return dornecedores.get(index);
    }
}
