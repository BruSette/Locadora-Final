package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.GeneroDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;
/**
 *
 * @author bruno
 */
public class GeneroDAOImplMysql extends GenericaDAOMysql<Genero> implements GeneroDAO {

  @Override
    public String getInsert(Genero objeto) {
        return "(nome)"
                + "values (?);";
    }
    
    @Override
    public String getUpdate(Genero objeto) {
        return " nome = ?"
                + " where codigo = ?;";
    }

    @Override
    public Genero setObjeto(ResultSet resultado) {
        Genero genero = new Genero();
        try {
            genero.setCodigo(resultado.getInt("codigo"));
            genero.setNome(resultado.getString("nome"));

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genero;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Genero t) {
        try {
            pstm.setString(1, t.getNome());

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Genero t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setInt(2, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Genero getObjeto() {
        Genero genero = new Genero();
        return genero;
    }
}
