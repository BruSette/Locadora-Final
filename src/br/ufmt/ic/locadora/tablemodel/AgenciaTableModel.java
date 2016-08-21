/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Agencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class AgenciaTableModel extends AbstractTableModel {
    
    private List<Agencia> agencias;
    private String[] header = new String[]{"Nome", "Telefone", "Gerente"};

    public AgenciaTableModel(List<Agencia> List) {
        agencias = new ArrayList<>(List);
        
    }
       
    @Override
    public int getRowCount() {
        return agencias.size();
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
        Agencia selecionado = agencias.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getCodigo();
                break;
            case 1:
                valor = selecionado.getTelefone();
                break;
            case 2:
                valor = selecionado.getGerente().getNome();
                break;
        }
        return valor;
    }
    
    
    public void adicionar(Agencia agencia) {
        agencias.add(agencia);
        int ultima = agencias.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Agencia agencia) {
        agencias.set(index, agencia);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Agencia agencia){
        agencias.remove(agencia);
        int ultima = agencias.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public Agencia getAgencia(int index) {
        return agencias.get(index);
    }
}
