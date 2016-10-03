package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import br.ufmt.ic.locadora.entidade.Filme;
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
public class FilmeDAOImplMysql extends GenericaDAOPostgres<Filme> implements FilmeDAO {

    @Override
    public String getInsert(Filme objeto) {
        return "(disponibilidade,valoraluguel,quantidade," +
"codigoexemplar,codigofornecedor,codigofuncionario)"
                + "values (?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Filme objeto) {
        return "disponibilidade=?,valoraluguel=?,quantidade=?," +
"codigoexemplar=?,codigofornecedor=?,codigofuncionario=?"
                + " where codigo = ?;";
    }

    @Override
    public Filme setObjeto(ResultSet resultado) {
        Filme filme = new Filme();
        try {
            filme.setCodigo(resultado.getInt("codigo"));
            filme.setDisponibilidade(resultado.getBoolean("disponibilidade"));
            filme.setValorAluguel(resultado.getDouble("valoraluguel"));
            filme.setQuantidade(resultado.getInt("quantidade"));
            filme.setExemplar(FabricaDAO.CriarExemplarDAO().consultar(resultado.getInt("codigoexemplar")));
            filme.setFornecedor(FabricaDAO.CriarForncedorDAO().consultar(resultado.getInt("codigofornecedor")));
            filme.setFuncionario(FabricaDAO.CriarFuncionarioDAO().consultar(resultado.getInt("codigofuncionario")));
          
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filme;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Filme t) {
        try {
            pstm.setBoolean(1, t.getDisponibilidade());
            pstm.setDouble(2, t.getValorAluguel());
            pstm.setInt(3, t.getQuantidade());
            pstm.setInt(4, t.getExemplar().getCodigo());
            pstm.setInt(5, t.getFornecedor().getCodigo());
            pstm.setInt(6, t.getFuncionario().getCodigo());
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Filme t) {
        try {
            pstm.setBoolean(1, t.getDisponibilidade());
            pstm.setDouble(2, t.getValorAluguel());
            pstm.setInt(3, t.getQuantidade());
            pstm.setInt(4, t.getExemplar().getCodigo());
            pstm.setInt(5, t.getFornecedor().getCodigo());
            pstm.setInt(6, t.getFuncionario().getCodigo());
            
            pstm.setInt(7, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Filme getObjeto() {
        Filme filme = new Filme();
        return filme;
    }

}
