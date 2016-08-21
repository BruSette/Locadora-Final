/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Banco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class BancoTableModel extends AbstractTableModel {
    private List<Banco> bancos;
    private String[] header = new String[]{"Nome", "Cod"};

    public BancoTableModel(List<Banco> List) {
        bancos = new ArrayList<>(List);
       
    }
       
    @Override
    public int getRowCount() {
        return bancos.size();
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
        Banco selecionado = bancos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            case 1:
                valor = selecionado.getCod();
                break;
            
        }
        return valor;
    }
    
    
    public void adicionar(Banco banco) {
        bancos.add(banco);
        int ultima = bancos.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Banco banco) {
        bancos.set(index, banco);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Banco banco){
        bancos.remove(banco);
        int ultima = bancos.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public Banco getBanco(int index) {
        return bancos.get(index);
    }
}
