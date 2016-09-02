/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.GeneroDAO;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class GeneroDAOImplArq implements GeneroDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "genero/genero.bd";
    private String delimitador = ";";
    
    public void inserir(Genero genero) throws RegistroException {
        Map<String, Genero> generos = listar();
        if (generos.containsKey(genero.getNome())) {
            throw new RegistroException();
        }
        generos.put(genero.getNome(), genero);
        salvarArquivo(generos);
    }
    
    private void salvarArquivo(Map<String, Genero> generos) {
        try {    
            PrintWriter arq = new PrintWriter(dir);
            Collection<Genero> colecao = generos.values();
            for (Genero genero : colecao) {
                arq.println(genero.getNome());
            }
            arq.close();

        } catch (IOException ex) {
            System.out.println("Arquivo ou diretório Inexistente!");
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException ex1) {
                System.out.println("Arquivo Inexistente!");
            }
        }
    }

    public void remover(String nome) {
        Map<String, Genero> generos = listar();
        generos.remove(nome);
        salvarArquivo(generos);
    }

    public void alterar(Genero genero, Genero chave) throws RegistroException {
        remover(chave.getNome());
        try{
            inserir(genero);
        }catch (RegistroException erro){
            inserir(chave);
            throw new RegistroException();
        }
    }

    public Genero consultar(String nome) {
        Map<String, Genero> generos = listar();
        return generos.get(nome);
    }

    public Map<String, Genero> listar() {
        Map<String, Genero> generos = new HashMap<String, Genero>();
        return generos;
    }
    
    
}
