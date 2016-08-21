/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brunosette
 */
public class PontoTableModel extends AbstractTableModel {
    private List<Ponto> pontos;
    private String[] header = new String[]{"Funcionario", "Tipo de Ponto", "Data"};
    
    public PontoTableModel(List<Ponto> List) {
        pontos = new ArrayList<>(List);
    }

    @Override
    public int getRowCount() {
        return pontos.size();
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
        Ponto selecionado = pontos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getFuncionario().getNome();
                break;
            case 1:
                valor = selecionado.getTipoPonto();
                break;
            case 2:
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    valor = sdf.format(selecionado.getDataPonto());
                }catch (NullPointerException erro){
                    valor = "";
                }
                
                break;
        }
        return valor;
    }

    public void adicionar(Ponto ponto) {
        pontos.add(ponto);
        int ultima = pontos.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Ponto ponto) {
        pontos.set(index, ponto);
        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index, Ponto ponto){
        pontos.remove(ponto);
        int ultima = pontos.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }

    public Ponto getPonto(int index) {
        return pontos.get(index);
    }
    
    
}
