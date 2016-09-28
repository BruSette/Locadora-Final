/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Genero;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class GeneroTableModel extends AbstractTableModel {
    private List<Genero> generos;
    private String[] header = new String[]{"Nome"};
    
    public GeneroTableModel(List<Genero> List) {
        generos = new ArrayList<>(List);
    }
    
    @Override
    public int getRowCount() {
        return generos.size();
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
       Genero selecionado = generos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getNome();
                break;
            
        }
        return valor;
    }
    
    public void adicionar(Genero genero) {
        System.out.println("Passou!");
        generos.add(genero);
        int ultima = generos.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Genero genero) {
        generos.set(index, genero);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Genero genero){
        generos.remove(genero);
        int ultima = generos.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    
    public Genero getGenero(int index) {
        return generos.get(index);
    }
}
