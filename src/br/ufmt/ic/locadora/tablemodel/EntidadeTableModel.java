/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class EntidadeTableModel extends AbstractTableModel {
    private List<Entidade> entidades;
    private String[] header = new String[]{"CPF", "Nome", "Telefone"};

    public EntidadeTableModel(List<Entidade> List) {
        entidades = new ArrayList<>(List);
    }
    
    

    @Override
    public int getRowCount() {
        return entidades.size();
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
        Entidade selecionado = entidades.get(rowIndex);
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

    public void adicionar(Entidade entidade) {
        entidades.add(entidade);
        int ultima = entidades.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Entidade entidade) {
        entidades.set(index, entidade);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Entidade entidade){
        entidades.remove(entidade);
        int ultima = entidades.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }

    public Entidade getEntidade(int index) {
        return entidades.get(index);
    }

}
