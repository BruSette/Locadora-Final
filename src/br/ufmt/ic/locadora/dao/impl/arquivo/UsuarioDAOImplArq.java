/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class UsuarioDAOImplArq extends GenericaDAOArquivo<Usuario> implements UsuarioDAO{

    @Override
    public Usuario converteParaObjeto(String[] fatiado) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(fatiado[0]);
        usuario.setSenha(fatiado[1]);

        return usuario;
    }

    @Override
    public String getDiretorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String converteParaString(Usuario usuario) {
        return usuario.getUsuario()
                + delimitador + usuario.getSenha();
    }

}
