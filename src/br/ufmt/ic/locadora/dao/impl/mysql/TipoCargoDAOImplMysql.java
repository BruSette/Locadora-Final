package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.entidade.TipoCargo;
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
public class TipoCargoDAOImplMysql extends GenericaDAOMysql<TipoCargo> implements TipoCargoDAO {

  @Override
    public String getInsert(TipoCargo objeto) {
        return "(nome)"
                + "values (?);";
    }
    
    @Override
    public String getUpdate(TipoCargo objeto) {
        return " nome = ?"
                + " where codigo = ?;";
    }

    @Override
    public TipoCargo setObjeto(ResultSet resultado) {
        TipoCargo tipocargo = new TipoCargo();
        try {
            tipocargo.setCodigo(resultado.getInt("codigo"));
            tipocargo.setNome(resultado.getString("nome"));

        } catch (SQLException ex) {
            Logger.getLogger(TipoCargoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipocargo;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, TipoCargo t) {
        try {
            pstm.setString(1, t.getNome());

        } catch (SQLException ex) {
            Logger.getLogger(TipoCargoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, TipoCargo t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setInt(2, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(TipoCargoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public TipoCargo getObjeto() {
        TipoCargo tipocargo = new TipoCargo();
        return tipocargo;
    }
}
