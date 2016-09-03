/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        List<Filme> filmes = listar();
        filmes.add(filme);
        salvarArquivo(filmes);
        
    }
    
    private void salvarArquivo(List <Filme> filmes) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            
            for (Filme filme : filmes) {
                System.out.println(filme.getFornecedor().getCnpj());
                
                arq.println(filme.getExemplar().getNome()
                + delimitador + filme.getFornecedor().getCnpj()
                + delimitador + filme.getFuncionario().getCpf()
                + delimitador + String.valueOf(filme.getQuantidade())
                
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
        List<Filme> filmes = listar();
        for (int i = filmes.size()-1; i >= 0; i--) {
            if (filme.getExemplar().getNome().equals(filmes.get(i).getExemplar().getNome())){
                filmes.remove(i);
            }
        }
        salvarArquivo(filmes);
    }

    @Override
    public void alterar(Filme filme, Filme chave) throws RegistroException {
        List<Filme> filmes = listar();
        filmes.remove(chave);
        try{
            this.inserir(filme);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Filme consultar(String filme) {
        List<Filme> filmes = listar();
        for (Filme filmelist : filmes) {
            if (filmelist.getExemplar().getNome().equals(filme)){
                return filmelist;
            }
        }
        return null;
    }

    public List<Filme> listar() {
        List<Filme> filmes = new ArrayList<Filme>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                Filme filme = new Filme();
                Exemplar exemplar = FabricaDAO.CriarExemplarDAO().consultar(fatiado[0]);
                filme.setExemplar(exemplar);
                Fornecedor fornecedor = FabricaDAO.CriarForncedorDAO().consultar(fatiado[1]);
                System.out.println(fornecedor.getNome());
                filme.setFornecedor(fornecedor);
                Funcionario funcionario = FabricaDAO.CriarFuncionarioDAO().consultar(fatiado[2]);
                filme.setFuncionario(funcionario);
                filme.setQuantidade(Integer.parseInt(fatiado[3]));
                
                
                filmes.add(filme);
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
        return filmes;
    }


}
