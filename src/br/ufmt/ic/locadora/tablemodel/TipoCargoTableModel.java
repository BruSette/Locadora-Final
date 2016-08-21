/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;


import br.ufmt.ic.locadora.entidade.TipoCargo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class TipoCargoTableModel extends AbstractTableModel {
    private List<TipoCargo> tipopontos;
    private String[] header = new String[]{"Nome"};
    
    public TipoCargoTableModel(Map<String, TipoCargo> map) {
        tipopontos = new ArrayList<>(map.values());
    }
    
    @Override
    public int getRowCount() {
        return tipopontos.size();
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
        TipoCargo selecionado = tipopontos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            
        }
        return valor;
    }
    
    public void adicionar(TipoCargo tipocargo) {
        System.out.println("Passou!");
        tipopontos.add(tipocargo);
        int ultima = tipopontos.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, TipoCargo tipocargo) {
        tipopontos.set(index, tipocargo);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, TipoCargo tipocargo){
        tipopontos.remove(tipocargo);
        int ultima = tipopontos.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public TipoCargo getTipoCargo(int index) {
        return tipopontos.get(index);
    }
}
