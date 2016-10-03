package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class ExemplarDAOImplMysql extends GenericaDAOMysql<Exemplar> implements ExemplarDAO {

  @Override
    public String getInsert(Exemplar objeto) {
        return "(nome,codgenero, datalancamento)"
                + "values (?,?,?);";
    }
    
    @Override
    public String getUpdate(Exemplar objeto) {
        return " nome = ?,codgenero=?, datalancamento=?"
                + " where codigo = ?;";
    }

    @Override
    public Exemplar setObjeto(ResultSet resultado) {
        Exemplar exemplar = new Exemplar();
        try {
            exemplar.setCodigo(resultado.getInt("codigo"));
            exemplar.setNome(resultado.getString("nome"));
            exemplar.setDatalancamento(new Date(resultado.getDate("datalancamento").getTime()));
            exemplar.setGenero(FabricaDAO.CriarGeneroDAO().consultar(resultado.getInt("codgenero")));

        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exemplar;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Exemplar t) {
        try {
            pstm.setString(1, t.getNome());
           
            pstm.setInt(2, t.getGenero().getCodigo());
            pstm.setDate(3, new java.sql.Date(t.getDatalancamento().getTime()));
            

        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Exemplar t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setInt(2, t.getGenero().getCodigo());
            pstm.setDate(3, new java.sql.Date(t.getDatalancamento().getTime()));
            pstm.setInt(4, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Exemplar getObjeto() {
        Exemplar exemplar = new Exemplar();
        return exemplar;
    }
}
