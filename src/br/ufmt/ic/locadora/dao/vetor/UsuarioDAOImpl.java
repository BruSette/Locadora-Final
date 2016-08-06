/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.vetor;

import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;

/**
 *
 * @author bruno
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    Usuario usuarios[] = new Usuario[10];

    public void inserir(Usuario usuario) throws UsuarioException {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(usuario.getUsuario())) {
                   throw new UsuarioException();
                }
            }
        }

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                if(usuario.getUsuario().equals("") || usuario.getSenha().equals("") ){
                    throw new UsuarioException("Usuario ou senha invalidos!");
                }
                usuarios[i] = usuario;
                System.out.println("Inserido com Sucesso!");
                break;
            }
        }

    }

    public void remover(String usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(usuario)) {
                    usuarios[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario consultar(String usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(usuario)) {
                    return usuarios[i];
                }
            }
        }
        return null;
    }

    public Usuario[] listar() {
        return usuarios;
    }

}
