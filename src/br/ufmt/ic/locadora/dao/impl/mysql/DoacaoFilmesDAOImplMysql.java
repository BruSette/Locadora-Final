package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
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
public class DoacaoFilmesDAOImplMysql extends GenericaDAOMysql<DoacaoFilmes> implements DoacaoFilmesDAO {

    @Override
    public String getInsert(DoacaoFilmes objeto) {
        return "(codfilme,codentidade,codfuncionario, datadoacao)"
                + "values (?,?,?,?);";
    }

    @Override
    public String getUpdate(DoacaoFilmes objeto) {
        return " codfilme=?,codentidade=?,codfuncionario=?, datadoacao=? "
                + " where codigo = ?;";
    }

    @Override
    public DoacaoFilmes setObjeto(ResultSet resultado) {
        DoacaoFilmes doacao = new DoacaoFilmes();
        try {
            doacao.setCodigo(resultado.getInt("codigo"));
            doacao.setResponsavel(FabricaDAO.CriarFuncionarioDAO().consultar(resultado.getInt("codigofuncionario")));
            doacao.setFilme(FabricaDAO.CriarFilmeDAO().consultar(resultado.getInt("codigofilme")));
            doacao.setDataDoacao(new Date(resultado.getDate("datadoacao").getTime()));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoFilmesDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doacao;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, DoacaoFilmes t) {
        try {
            pstm.setInt(1, t.getFilme().getCodigo());
            pstm.setInt(2, t.getEntidade().getCodigo());
            pstm.setInt(3, t.getResponsavel().getCodigo());
            pstm.setDate(4, new java.sql.Date(t.getDataDoacao().getTime()));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoFilmesDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, DoacaoFilmes t) {
        try {
             pstm.setInt(1, t.getFilme().getCodigo());
            pstm.setInt(2, t.getEntidade().getCodigo());
            pstm.setInt(3, t.getResponsavel().getCodigo());
            pstm.setDate(4, new java.sql.Date(t.getDataDoacao().getTime()));
            pstm.setInt(5, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoFilmesDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public DoacaoFilmes getObjeto() {
        DoacaoFilmes doacao = new DoacaoFilmes();
        return doacao;
    }
}
