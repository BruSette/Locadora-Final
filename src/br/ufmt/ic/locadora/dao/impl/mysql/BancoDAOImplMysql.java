package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class BancoDAOImplMysql extends GenericaDAOMysql<Banco> implements BancoDAO {

    @Override
    public String getInsert(Banco objeto) {
        return "(nome,cod)"
                + "values (?,?);";
    }
    
    @Override
    public String getUpdate(Banco objeto) {
        return " nome = ?,cod= ?"
                + " where codigo = ?;";
    }

    @Override
    public Banco setObjeto(ResultSet resultado) {
        Banco banco = new Banco();
        try {
            banco.setCodigo(resultado.getInt("codigo"));
            banco.setNome(resultado.getString("nome"));
            banco.setCod(resultado.getString("cod"));

        } catch (SQLException ex) {
            Logger.getLogger(BancoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banco;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Banco t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getCod());

        } catch (SQLException ex) {
            Logger.getLogger(BancoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Banco t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getCod());
            pstm.setInt(3, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(BancoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Banco getObjeto() {
        Banco banco = new Banco();
        return banco;
    }

}
