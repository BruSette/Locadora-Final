/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.util.BancoArqu;

/**
 *
 * @author bruno
 */
public class UsuarioDAOImplArq extends GenericaDAOArquivo<Usuario> implements UsuarioDAO{

    @Override
    public Usuario converteParaObjeto(String[] fatiado) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(Integer.parseInt(fatiado[0]));
        usuario.setUsuario(fatiado[1]);
        usuario.setSenha(fatiado[2]);
        return usuario;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "usuario/usuario.bd";
    }

    @Override
    public String converteParaString(Usuario usuario) {
        return  usuario.getCodigo()
                + delimitador + usuario.getUsuario()
                + delimitador + usuario.getSenha();
    }

}
