package br.ufmt.ic.locadora.dao.impl.postgres;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class UsuarioDAOImplPostgres extends GenericaDAOPostgres<Usuario> implements UsuarioDAO {

    @Override
    public String getInsert(Usuario objeto) {
        return "(usuario,senha)"
                + "values (?,?);";
    }
    
    @Override
    public String getUpdate(Usuario objeto) {
        return " usuario = ?,senha= ?"
                + " where codigo = ?;";
    }

    @Override
    public Usuario setObjeto(ResultSet resultado) {
        Usuario usuario = new Usuario();
        try {
            usuario.setCodigo(resultado.getInt("codigo"));
            usuario.setUsuario(resultado.getString("usuario"));
            usuario.setSenha(resultado.getString("senha"));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Usuario t) {
        try {
            pstm.setString(1, t.getUsuario());
            pstm.setString(2, t.getSenha());

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Usuario t) {
        try {
            pstm.setString(1, t.getUsuario());
            pstm.setString(2, t.getSenha());
            pstm.setInt(3, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Usuario getObjeto() {
        Usuario usuario = new Usuario();
        return usuario;
    }

}
