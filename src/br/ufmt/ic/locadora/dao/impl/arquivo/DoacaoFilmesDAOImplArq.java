/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmesDAOImplArq implements DoacaoFilmesDAO {

    private static final String dir = BancoArqu.getCaminho() + "doacaofilmes/doacaofilmes.bd";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String delimitador = ";";

    public void inserir(DoacaoFilmes doacao) throws RegistroException {
        List<DoacaoFilmes> doacoes = listar();
        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacaolist.getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {

                    throw new RegistroException();
                }
            }

        }

        doacoes.add(doacao);

    }

    public void remover(DoacaoFilmes doacao) {
        List<DoacaoFilmes> doacoes = listar();
        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacaolist.getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {
                    doacoes.remove(doacao);
                    return;
                }
            }

        }
    }

    public void alterar(DoacaoFilmes doacao, DoacaoFilmes chave) throws RegistroException {
        List<DoacaoFilmes> doacoes = listar();
        doacoes.remove(chave);

        try {
            inserir(doacao);
        } catch (RegistroException erro) {
            inserir(chave);
            throw new RegistroException();
        }

    }

    private void salvarArquivo(List<DoacaoFilmes> doacoes) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            for (DoacaoFilmes doacao : doacoes) {
                String data = "";
                try {
                    data = sdf.format(doacao.getDataDoacao());
                } catch (NullPointerException err) {

                }
                arq.println(doacao.getFilme().getExemplar().getNome()
                        + delimitador + doacao.getEntidade().getCnpj()
                        + delimitador + doacao.getResponsavel().getCpf()
                        + delimitador + data
                );
            }
            arq.close();

        } catch (IOException ex) {
            System.out.println("Arquivo ou diretório Inexistente!");
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException er) {
                System.out.println("Arquivo Inexistente!");
            }
        }
    }

    public DoacaoFilmes consultar(DoacaoFilmes doacao) {
        List<DoacaoFilmes> doacoes = listar();
        return null;
    }

    public List<DoacaoFilmes> listar() {
        List<DoacaoFilmes> doacoes = new ArrayList<DoacaoFilmes>();

        return doacoes;
    }

}
