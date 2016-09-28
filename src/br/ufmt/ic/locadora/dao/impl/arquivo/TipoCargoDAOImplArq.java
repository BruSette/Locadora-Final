/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.entidade.TipoCargo;
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
public class TipoCargoDAOImplArq extends GenericaDAOArquivo<TipoCargo> implements TipoCargoDAO {

    @Override
    public TipoCargo converteParaObjeto(String[] fatiado) {
        TipoCargo cargo = new TipoCargo();
        cargo.setNome(fatiado[0]);
        return cargo;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "tipocargo/tipocargo.bd";
    }

    @Override
    public String converteParaString(TipoCargo tipocargo) {
        return tipocargo.getNome();
    }

}
