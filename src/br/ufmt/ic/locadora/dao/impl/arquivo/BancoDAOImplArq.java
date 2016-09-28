/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.util.BancoArqu;

/**
 *
 * @author brunosette
 */
public class BancoDAOImplArq extends GenericaDAOArquivo<Banco> implements BancoDAO {

    @Override
    public Banco converteParaObjeto(String[] fatiado) {
        Banco banco = new Banco();
        banco.setCodigo(Integer.parseInt(fatiado[0]));
        banco.setCod(fatiado[1]);
        banco.setNome(fatiado[2]);
        return banco;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "banco/banco.bd";
    }

    @Override
    public String converteParaString(Banco objeto) {
        return String.valueOf(objeto.getCodigo()) + delimitador+ objeto.getCod() + delimitador + objeto.getNome();
    }
}
