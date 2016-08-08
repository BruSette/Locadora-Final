/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;
import java.util.Map;

/**
 *
 * @author bruno
 */
public interface UsuarioDAO {
    
    public void inserir(Usuario usuario) throws UsuarioException;

    public void remover(String usuario);

    public void alterar(Usuario usuario, Usuario chave) throws UsuarioException;

    public Usuario consultar(String usuario);

    public Map<String, Usuario> listar();
}
