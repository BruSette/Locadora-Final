package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
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
public class PontoDAOImplMysql extends GenericaDAOPostgres<Ponto> implements PontoDAO {

  @Override
    public String getInsert(Ponto objeto) {
        return "(codigofuncionario, dataponto, tipoponto)"
                + "values (?,?,?);";
    }
    
    @Override
    public String getUpdate(Ponto objeto) {
        return " codigofuncionario=?, dataponto=?, tipoponto=?"
                + " where codigo = ?;";
    }

    @Override
    public Ponto setObjeto(ResultSet resultado) {
        Ponto ponto = new Ponto();
        try {
            ponto.setCodigo(resultado.getInt("codigo"));
            ponto.setFuncionario(FabricaDAO.CriarFuncionarioDAO().consultar(resultado.getInt("codigofuncionario")));
            ponto.setDataPonto(new Date(resultado.getDate("dataponto").getTime()));
            ponto.setTipoPonto(resultado.getString("tipoponto"));

        } catch (SQLException ex) {
            Logger.getLogger(PontoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ponto;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Ponto t) {
        try {
            pstm.setInt(1, t.getFuncionario().getCodigo());
            pstm.setDate(2, new java.sql.Date(t.getDataPonto().getTime()));
            pstm.setString(3,t.getTipoPonto());
        } catch (SQLException ex) {
            Logger.getLogger(PontoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Ponto t) {
        try {
            pstm.setInt(1, t.getFuncionario().getCodigo());
            pstm.setDate(2, new java.sql.Date(t.getDataPonto().getTime()));
            pstm.setString(3,t.getTipoPonto());
            pstm.setInt(4, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(PontoDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Ponto getObjeto() {
        Ponto ponto = new Ponto();
        return ponto;
    }
}
