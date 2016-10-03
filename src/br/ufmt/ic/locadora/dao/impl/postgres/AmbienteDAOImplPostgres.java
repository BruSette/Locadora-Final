package br.ufmt.ic.locadora.dao.impl.postgres;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class AmbienteDAOImplPostgres extends GenericaDAOPostgres<Ambiente> implements AmbienteDAO {

  @Override
    public String getInsert(Ambiente objeto) {
        return "(nome)"
                + "values (?);";
    }
    
    @Override
    public String getUpdate(Ambiente objeto) {
        return " nome = ?"
                + " where codigo = ?;";
    }

    @Override
    public Ambiente setObjeto(ResultSet resultado) {
        Ambiente ambiente = new Ambiente();
        try {
            ambiente.setCodigo(resultado.getInt("codigo"));
            ambiente.setNome(resultado.getString("nome"));

        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ambiente;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Ambiente t) {
        try {
            pstm.setString(1, t.getNome());

        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Ambiente t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setInt(2, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Ambiente getObjeto() {
        Ambiente ambiente = new Ambiente();
        return ambiente;
    }
}
