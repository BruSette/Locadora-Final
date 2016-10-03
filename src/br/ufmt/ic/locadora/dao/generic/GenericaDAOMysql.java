/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.generic;

import br.ufmt.ic.locadora.dao.GenericaDAO;
import br.ufmt.ic.locadora.util.BancoDadosMysql;
import br.ufmt.ic.locadora.util.BancoDadosPostgres;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Generica;
import br.ufmt.ic.locadora.util.BancoDados;
import java.sql.ResultSet;

/**
 *
 * @author bruno
 * @param <T>
 */
public abstract class GenericaDAOMysql<T extends Generica> extends GenericaDAOPostgres<T> implements GenericaDAO<T> {
    
    @Override
    public BancoDados getBanco() {
        return new BancoDadosMysql();
    }
    
    @Override
    public ResultSet getUltimo(){
        String sql = "select last_insert_id() as ultimo;";
        ResultSet resultado = banco.executarQuery(sql);
        return resultado;
    }
    
}
