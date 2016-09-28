/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.exception.CNPJException;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class EntidadeDAOImplArq extends GenericaDAOArquivo<Entidade> implements EntidadeDAO {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Entidade converteParaObjeto(String[] fatiado) {
        Entidade entidade = new Entidade();
        entidade.setCnpj(fatiado[0]);
        entidade.setEmail(fatiado[1]);
        entidade.setNome(fatiado[2]);
        entidade.setRazaoSocial(fatiado[3]);
        entidade.setTelefone(fatiado[4]);
        entidade.setCelular(fatiado[5]);
        entidade.setObs(fatiado[6]);

        ContaBancaria conta = new ContaBancaria();
        //ARRUMAR
        conta.setBanco((Banco) FabricaDAO.CriarBancoDAO().consultar(Integer.parseInt(fatiado[7])));
        conta.setContaNumero(fatiado[8]);
        entidade.setConta(conta);

        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[9]);
        endereco.setCep(fatiado[10]);
        endereco.setCidade(fatiado[11]);
        endereco.setComplemento(fatiado[12]);
        endereco.setEstado(fatiado[13]);
        endereco.setNumero(fatiado[14]);
        endereco.setRua(fatiado[15]);
        entidade.setEndereco(endereco);
        return entidade;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "entidade/entidade.bd";
    }

    @Override
    public String converteParaString(Entidade entidade) {
        return entidade.getCnpj()
                + delimitador + entidade.getEmail()
                + delimitador + entidade.getNome()
                + delimitador + entidade.getRazaoSocial()
                + delimitador + entidade.getTelefone()
                + delimitador + entidade.getCelular()
                + delimitador + entidade.getObs()
                + delimitador + entidade.getConta().getBanco().getNome()
                + delimitador + entidade.getConta().getContaNumero()
                + delimitador + entidade.getEndereco().getBairro()
                + delimitador + entidade.getEndereco().getCep()
                + delimitador + entidade.getEndereco().getCidade()
                + delimitador + entidade.getEndereco().getComplemento()
                + delimitador + entidade.getEndereco().getEstado()
                + delimitador + entidade.getEndereco().getNumero()
                + delimitador + entidade.getEndereco().getRua();

    }
   

}
