/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class DoacaoFilmesTableModel extends AbstractTableModel {
    private List<DoacaoFilmes> doacoes;
    private String[] header = new String[]{"NomeFilme", "Doador", "Entidade", "Data"};

    public DoacaoFilmesTableModel(Map<String, DoacaoFilmes> map) {
        doacoes = new ArrayList<>(map.values());
    }
    
    @Override
    public int getRowCount() {
        return doacoes.size();
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
       DoacaoFilmes selecionado = doacoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getFilmes().getNomeFilme();
                break;
            case 1:
                valor = selecionado.getResponsavel().getNome();
                break;
            case 2:
                valor = selecionado.getEntidade().getNome();
                break;
            case 3:
                valor = String.valueOf(selecionado.getDataDoacao());
                break;
        }
        return valor;
    }
    
    public DoacaoFilmes getDoacoes(int index) {
        return doacoes.get(index);
    }
}
