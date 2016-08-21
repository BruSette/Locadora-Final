/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Exemplar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class AmbienteTableModel extends AbstractTableModel {
    private List<Ambiente> ambientes;
    private String[] header = new String[]{"Nome"};
    
    public AmbienteTableModel(Map<String, Ambiente> map) {
        ambientes = new ArrayList<>(map.values());
    }
    
    @Override
    public int getRowCount() {
        return ambientes.size();
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
       Ambiente selecionado = ambientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            
        }
        return valor;
    }
    
    public void adicionar(Ambiente ambiente) {
        System.out.println("Passou!");
        ambientes.add(ambiente);
        int ultima = ambientes.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Ambiente ambiente) {
        ambientes.set(index, ambiente);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Ambiente ambiente){
        ambientes.remove(ambiente);
        int ultima = ambientes.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public Ambiente getAmbiente(int index) {
        return ambientes.get(index);
    }
}
