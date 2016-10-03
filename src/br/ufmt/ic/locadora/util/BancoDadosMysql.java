/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.util;

import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.util.BancoDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raphael
 */
public class BancoDadosMysql extends BancoDados {

    public BancoDadosMysql() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdlocadora", "root", "123");

        } catch (SQLException ex) {
            Logger.getLogger(BancoDadosMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
