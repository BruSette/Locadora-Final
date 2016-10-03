/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.generic;

import br.ufmt.ic.locadora.dao.GenericaDAO;
import br.ufmt.ic.locadora.entidade.Generica;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public abstract class GenericaDAOBanco<T extends Generica> implements GenericaDAO<T> {

    protected final BancoDados banco = getBanco();

    protected T t = getObjeto();
    protected String nome = t.getClass().getSimpleName().toLowerCase();

    @Override
    public void inserir(T t) throws RegistroException, SQLException {
        String sql = "INSERT INTO " + nome;
        sql += getInsert(t);
        PreparedStatement pstm = banco.prepareStatement(sql);
        pstm = PreparaInserir(pstm, t);
        try {
            pstm.execute();
            ResultSet resultado = getUltimo();
            if (resultado.next()) {
                t.setCodigo(resultado.getInt("ultimo"));
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    @Override
    public void remover(int codigo) throws SQLException {
        String sql = "delete from " + nome + " where codigo = " + codigo + ";";
        PreparedStatement pstm = banco.prepareStatement(sql);
        try {
            pstm.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    @Override
    public void alterar(T t) throws SQLException {

        String sql = "UPDATE" + nome + "SET  ";
        sql += getUpdate(t);
        PreparedStatement pstm = banco.prepareStatement(sql);
        pstm = PreparaUpdate(pstm, t);
        try {
            pstm.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }

    }

    @Override
    public T consultar(int codigo) {
        String sql = "select * from " + nome + "  where codigo = "
                + codigo + " LIMIT 1;";

        ResultSet resultado = banco.executarQuery(sql);
        try {
            if (resultado.next()) {
                T t = setObjeto(resultado);
                return t;
            }
        } catch (SQLException ex) {

        }

        return null;
    }

    @Override
    public List<T> listar() {
        List<T> ret = new ArrayList<>();
        String sql = "select * from " + nome + ";";
        ResultSet resultado = banco.executarQuery(sql);
        try {
            while (resultado.next()) {
                T t = setObjeto(resultado);
                ret.add(t);
            }
        } catch (SQLException ex) {

        }
        return ret;
    }

    public abstract ResultSet getUltimo();

    public abstract String getInsert(T objeto);

    public abstract String getUpdate(T objeto);

    public abstract T setObjeto(ResultSet resultado);

    public abstract T getObjeto();

    public abstract PreparedStatement PreparaInserir(PreparedStatement pstm, T t);

    public abstract PreparedStatement PreparaUpdate(PreparedStatement pstm, T t);

    public abstract BancoDados getBanco();

}
