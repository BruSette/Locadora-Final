/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class DoacaoFilmesTableModel extends AbstractTableModel {

    private List<DoacaoFilmes> doacoes;
    private String[] header = new String[]{"NomeFilme", "Doador", "Entidade", "Data"};

    public DoacaoFilmesTableModel(List<DoacaoFilmes> List) {
        doacoes = new ArrayList<>();
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
                valor = selecionado.getFilme().getNomeFilme();
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

    public void adicionar(DoacaoFilmes doacao) {
        System.out.println("Passou!");
        doacoes.add(doacao);
        int ultima = doacoes.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, DoacaoFilmes doacao) {
        doacoes.set(index, doacao);
        fireTableRowsUpdated(index, index);
    }

    public DoacaoFilmes getDoacao(int index) {
        return doacoes.get(index);
    }
}
