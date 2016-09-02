/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class FilmeDAOImplArq implements FilmeDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "filme/filme.bd";
    private String delimitador = ";";
    
    public void inserir(Filme filme) throws RegistroException {
        List<Filme> filmes = new ArrayList<Filme>();
        filmes.add(filme);
        salvarArquivo(filmes);

    }
    
    private void salvarArquivo(List <Filme> filmes) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            
            for (Filme filme : filmes) {
                
                arq.println(Boolean.toString(filme.getDisponibilidade())
                + delimitador + filme.getExemplar().getNome()
                + delimitador + filme.getFornecedor().getCnpj()
                + delimitador + filme.getFuncionario().getCpf()
                + delimitador + filme.getQuantidade()
                + delimitador + Double.toString(filme.getValorAluguel())
                
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

    public void remover(Filme filme) {
        List<Filme> filmes = new ArrayList<Filme>();
        filmes.remove(filme);
        salvarArquivo(filmes);
    }

    @Override
    public void alterar(Filme filme, Filme chave) throws RegistroException {
        List<Filme> filmes = new ArrayList<Filme>();
        filmes.remove(chave);
        try{
            this.inserir(filme);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Filme consultar(String filme) {
        List<Filme> filmes = new ArrayList<Filme>();
        return null;
    }

    public List<Filme> listar() {
        List<Filme> filmes = new ArrayList<Filme>();
        return filmes;
    }


}
