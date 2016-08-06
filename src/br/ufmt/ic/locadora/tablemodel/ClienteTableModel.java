/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;


import br.ufmt.ic.locadora.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> clientes;
    private String[] header = new String[]{"Nome", "Telefone", "LimiteFilmes", "Bloqueado"};
    
    public ClienteTableModel(Map<String, Cliente> map) {
        clientes = new ArrayList<>(map.values());
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
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
        Cliente selecionado = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            case 1:
                valor = selecionado.getTelefone();
                break;
            case 2:
                valor = Integer.toString(selecionado.getLimiteFilmes());
                break;
            case 3:
                valor = Boolean.toString(selecionado.getBloqueado());
                break;
        }
        return valor;
    }
    
    public Cliente getCliente(int index) {
        return clientes.get(index);
    }
    
}
