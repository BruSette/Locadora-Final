/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.generic;

import br.ufmt.ic.locadora.dao.generic.GenericaDAOBanco;
import br.ufmt.ic.locadora.dao.GenericaDAO;
import br.ufmt.ic.locadora.util.BancoDadosPostgres;
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
 * @param <T>
 */
public abstract class GenericaDAOPostgres<T extends Generica> extends GenericaDAOBanco<T> {

    @Override
    public BancoDados getBanco() {
        return new BancoDadosPostgres();
    }

    @Override
    public ResultSet getUltimo() {
        String sql = "select last_value as ultimo from " + nome + "_codigo_seq;";
        ResultSet resultado = banco.executarQuery(sql);
        return resultado;
    }

}
