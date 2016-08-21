/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

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
public class ExemplarTableModel extends AbstractTableModel {
    private List<Exemplar> exemplares;
    private String[] header = new String[]{"Nome","Genero", "Lançamento"};
    
    public ExemplarTableModel(Map<String, Exemplar> map) {
        exemplares = new ArrayList<>(map.values());
    }
    
    @Override
    public int getRowCount() {
        return exemplares.size();
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
       Exemplar selecionado = exemplares.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            case 1:
                valor = selecionado.getGenero();
                break;
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                valor = sdf.format(selecionado.getDatalancamento());
                break;
            
        }
        return valor;
    }
    
    public void adicionar(Exemplar exemplar) {
        System.out.println("Passou!");
        exemplares.add(exemplar);
        int ultima = exemplares.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Exemplar exemplar) {
        exemplares.set(index, exemplar);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Exemplar exemplar){
        exemplares.remove(exemplar);
        int ultima = exemplares.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public Exemplar getExemplar(int index) {
        return exemplares.get(index);
    }
}
