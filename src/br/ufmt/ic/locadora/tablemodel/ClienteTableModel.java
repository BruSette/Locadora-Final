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
    private String[] header = new String[]{"Nome", "Telefone", "LimiteFilmes", "Bloqueado","CPF"};
    
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
                if(selecionado.getBloqueado()){
                    valor = "Sim";
                }else{
                    valor = "Não";
                }
                break;
            case 4:
                valor = selecionado.getCpf();
                break;
        }
        return valor;
    }
    
    public void adicionar(Cliente cliente) {
        System.out.println("Passou!");
        clientes.add(cliente);
        int ultima = clientes.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Cliente cliente) {
        clientes.set(index, cliente);
        fireTableRowsUpdated(index, index);
    }

    
    
    public Cliente getCliente(int index) {
        return clientes.get(index);
    }
    
}
