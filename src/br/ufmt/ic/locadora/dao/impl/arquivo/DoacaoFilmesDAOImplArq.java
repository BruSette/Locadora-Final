/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
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
public class DoacaoFilmesDAOImplArq implements DoacaoFilmesDAO {

    private static final String dir = BancoArqu.getCaminho() + "doacaofilmes/doacaofilmes.bd";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String delimitador = ";";

    public void inserir(DoacaoFilmes doacao) throws RegistroException {
        List<DoacaoFilmes> doacoes = listar();
        for (int i = doacoes.size()-1; i >=0 ; i--) {
            if (doacoes.get(i).getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacoes.get(i).getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {
                    throw new RegistroException();
                }
            }

        }
        doacoes.add(doacao);
        salvarArquivo(doacoes);

    }

    public void remover(DoacaoFilmes doacao) {
        List<DoacaoFilmes> doacoes = listar();
        for (int i = doacoes.size()-1; i >=0 ; i--) {
            if (doacoes.get(i).getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacoes.get(i).getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {
                    doacoes.remove(i);
                }
            }
        }
        salvarArquivo(doacoes);
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

                    System.out.println("Null ao inserir Data");
                }
                
                
                
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
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                DoacaoFilmes doacao = new DoacaoFilmes();
                Filme filme =  FabricaDAO.CriarFilmeDAO().consultar(fatiado[0]);
                doacao.setFilme(filme);
                Entidade entidade = FabricaDAO.CriarEntidadeDAO().consultar(fatiado[1]);
                doacao.setEntidade(entidade);
                Funcionario funcionario = FabricaDAO.CriarFuncionarioDAO().consultar(fatiado[2]);
                doacao.setResponsavel(funcionario);
                
                
                Date data = new Date("11/11/1111");
                try{
                    data = sdf.parse(fatiado[3]);
                } catch (NullPointerException | ParseException err){
                    
                }
                
                doacao.setDataDoacao(data);
                
                
                doacoes.add(doacao);
                
                
                linha = arq.readLine();
            }
            arq.close();
        } catch (FileNotFoundException erro) {
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException ex) {
                System.out.println("Erro ao abrir o arquivo");
            }

        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo ou ao acessar o diretório");
        }

        return doacoes;
    }

}
