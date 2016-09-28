/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.tablemodel;

import br.ufmt.ic.locadora.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class UsuarioTableModel extends AbstractTableModel {
    private List<Usuario> usuarios;
    private String[] header = new String[]{"Nome", "Senha"};

    public UsuarioTableModel(List<Usuario> List) {
        usuarios = new ArrayList<>(List);
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
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
        Usuario selecionado = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = selecionado.getUsuario();
                break;
            case 1:
                valor = selecionado.getSenha();
                break;
            
        }
        return valor;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
        int ultima = usuarios.size() - 1;
        fireTableRowsInserted(ultima, ultima);
    }

    public void alterar(int index, Usuario usuario) {
        usuarios.set(index, usuario);
        fireTableRowsUpdated(index, index);
    }

    public void remover(int index, Usuario usuario){
        usuarios.remove(usuario);
        int ultima = usuarios.size() -1;
        fireTableRowsInserted(ultima, ultima);
    }
    
    public Usuario getUsuario(int index) {
        return usuarios.get(index);
    }
    
    
}
