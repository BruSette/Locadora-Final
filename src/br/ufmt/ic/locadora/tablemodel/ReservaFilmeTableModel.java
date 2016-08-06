/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.ReservaFilme;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class ReservaFilmeTableModel extends AbstractTableModel {
    private List<ReservaFilme> reservas;
    private String[] header = new String[]{"Cliente", "NomeFilme", "Reserva"};

    public ReservaFilmeTableModel(Set<ReservaFilme> set) {
        reservas = new ArrayList<>(set);
    }

    @Override
    public int getRowCount() {
        return reservas.size();
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
        ReservaFilme selecionado = reservas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getCliente().getNome();
                break;
            case 1:
                valor = selecionado.getFilme().getNomeFilme();
                break;
            case 2:
                valor = String.valueOf(selecionado.getDataReserva());
                break;
        }
        return valor;
    }

    public void adicionar(ReservaFilme reserva) {
        reservas.add(reserva);
        int ultima = reservas.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, ReservaFilme reserva) {
        reservas.set(index, reserva);
        fireTableRowsUpdated(index, index);
    }

    public ReservaFilme getReservaFilme(int index) {
        return reservas.get(index);
    }
    
    

}