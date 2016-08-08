/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufmt.ic.locadora.entidade.Funcionario;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> funcionarios;
    private String[] header = new String[]{"CPF", "Nome", "Telefone"};

    public FuncionarioTableModel(Map<String , Funcionario> map) {
        funcionarios = new ArrayList<>(map.values());
    }
    
    

    @Override
    public int getRowCount() {
        return funcionarios.size();
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
        Funcionario selecionado = funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getCpf();
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

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
        int ultima = funcionarios.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Funcionario funcionario) {
        funcionarios.set(index, funcionario);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Funcionario funcionario){
        funcionarios.remove(funcionario);
        int ultima = funcionarios.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }

    public Funcionario getFuncionario(int index) {
        return funcionarios.get(index);
    }

}