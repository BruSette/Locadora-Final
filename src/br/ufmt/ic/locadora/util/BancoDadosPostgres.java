/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.util;

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
public class BancoDadosPostgres extends BancoDados {

    public BancoDadosPostgres() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdlocadora", "postgres", "123");

        } catch (SQLException ex) {
            Logger.getLogger(BancoDadosPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
