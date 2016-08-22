/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Filme;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class EntradaFilmesTableModel extends AbstractTableModel {
    private List<Filme> filmes;
    private String[] header = new String[]{"Nome", "Genero", "Quantidade","Fornecedor"};

    public EntradaFilmesTableModel(Map<String, Filme> map) {
        filmes= new ArrayList<>(map.values());
    }

    @Override
    public int getRowCount() {
        return filmes.size();
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
        Filme selecionado = filmes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getExemplar().getNome();
                break;
            case 1:
                valor = selecionado.getExemplar().getGenero().getNome();
                break;
            case 2:
                valor = Integer.toString(selecionado.getQuantidade());
                break;
            case 3:
                valor = selecionado.getFornecedor().getNome();
                break;
        }
        return valor;
    }

    public void adicionar(Filme filme) {
        filmes.add(filme);
        int ultima = filmes.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Filme filme) {
        filmes.set(index, filme);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Filme filme){
        filmes.remove(filme);
        int ultima = filmes.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }

    public Filme getEntradaFilmes(int index) {
        return filmes.get(index);
    }
}
