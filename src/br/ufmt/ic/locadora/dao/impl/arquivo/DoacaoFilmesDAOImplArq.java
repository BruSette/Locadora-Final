/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.entidade.Funcionario;
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
public class DoacaoFilmesDAOImplArq extends GenericaDAOArquivo<DoacaoFilmes> implements DoacaoFilmesDAO {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public DoacaoFilmes converteParaObjeto(String[] fatiado) {
        DoacaoFilmes doacao = new DoacaoFilmes();
        //ARRUMAR DEPOIS
        Filme filme = (Filme) FabricaDAO.CriarFilmeDAO().consultar(Integer.parseInt(fatiado[0]));
        doacao.setFilme(filme);
        Entidade entidade = (Entidade) FabricaDAO.CriarEntidadeDAO().consultar(Integer.parseInt(fatiado[1]));
        doacao.setEntidade(entidade);
        Funcionario funcionario = (Funcionario) FabricaDAO.CriarFuncionarioDAO().consultar(Integer.parseInt(fatiado[2]));
        doacao.setResponsavel(funcionario);

        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[3]);
        } catch (NullPointerException | ParseException err) {

        }

        doacao.setDataDoacao(data);
        return doacao;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "doacaofilmes/doacaofilmes.bd";
    }

    @Override
    public String converteParaString(DoacaoFilmes doacao) {
        String data = "";
        try {
            data = sdf.format(doacao.getDataDoacao());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        try {
            data = sdf.format(doacao.getDataDoacao());
        } catch (NullPointerException err) {

        }
        return doacao.getFilme().getExemplar().getNome()
                + delimitador + doacao.getEntidade().getCnpj()
                + delimitador + doacao.getResponsavel().getCpf()
                + delimitador + data;
    }

}
