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

    }

    public void remover(Filme filme) {
        List<Filme> filmes = new ArrayList<Filme>();
        filmes.remove(filme);
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
