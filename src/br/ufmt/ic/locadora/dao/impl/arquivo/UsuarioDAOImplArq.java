/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.impl.list.*;
import br.ufmt.ic.locadora.dao.impl.*;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class UsuarioDAOImplArq implements UsuarioDAO {

    private static final String dir = BancoArqu.getCaminho() + "usuario/usuario.bd";
    private String delimitador = ";";

    public void inserir(Usuario usuario) throws UsuarioException {
        Map<String, Usuario> usuarios = listar();
        if (usuarios.containsKey(usuario.getUsuario())) {
            throw new UsuarioException();
        }
        if (usuario.getUsuario().equals("") || usuario.getSenha().equals("")) {
            throw new UsuarioException("Usuario ou senha invalidos!");
        }
        
        usuarios.put(usuario.getUsuario(), usuario);
        
        
    }

    public void remover(String usuario) {
        Map<String, Usuario> usuarios = listar();
        System.out.println("Removeu " + usuario);
        usuarios.remove(usuario);   
    }

    public void alterar(Usuario usuario, Usuario chave) throws UsuarioException {
        this.remover(chave.getUsuario());
        try{
            this.inserir(usuario);
        }catch (UsuarioException erro){
            this.inserir(chave);
            throw new UsuarioException();
            
        }
    }

    public Usuario consultar(String usuario) {
        Map<String, Usuario> usuarios = listar();
        return usuarios.get(usuario);
    }

    public Map<String, Usuario> listar() {
        Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
        return usuarios;
    }

}
