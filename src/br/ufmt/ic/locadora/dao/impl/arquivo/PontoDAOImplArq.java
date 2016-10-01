/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brunosette
 */
public class PontoDAOImplArq extends GenericaDAOArquivo<Ponto> implements PontoDAO {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Ponto converteParaObjeto(String[] fatiado) {
        Ponto ponto = new Ponto();
        ponto.setCodigo(Integer.parseInt(fatiado[0]));
        ponto.setTipoPonto(fatiado[1]);
        
        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[2]);
        } catch (NullPointerException | ParseException err) {

        }
        ponto.setDataPonto(data);
        return ponto;
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

        return ponto.getCodigo()
                + delimitador + ponto.getFuncionario().getCpf()
                + delimitador + ponto.getTipoPonto()
                + delimitador + data;
    }

}
