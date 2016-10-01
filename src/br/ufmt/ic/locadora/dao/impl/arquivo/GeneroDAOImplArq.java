/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.GeneroDAO;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class GeneroDAOImplArq extends GenericaDAOArquivo<Genero> implements GeneroDAO {

    @Override
    public Genero converteParaObjeto(String[] fatiado) {
        Genero genero = new Genero();
        genero.setCodigo(Integer.parseInt(fatiado[0]));
        genero.setNome(fatiado[1]);
        return genero;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "genero/genero.bd";
    }

    @Override
    public String converteParaString(Genero genero) {
        return genero.getCodigo() 
                + delimitador +genero.getNome();
    }

}
