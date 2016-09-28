/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class PontoDAOImplArq extends GenericaDAOArquivo<Ponto> implements PontoDAO {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Ponto converteParaObjeto(String[] fatiado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "ponto/ponto.bd";
    }

    @Override
    public String converteParaString(Ponto ponto) {

        String data = "";
        try {
            data = sdf.format(ponto.getDataPonto());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        return ponto.getFuncionario().getCpf()
                + delimitador + ponto.getTipoPonto()
                + delimitador + data;
    }

}
