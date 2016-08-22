/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;
import br.ufmt.ic.locadora.dao.FilmeDAO;

/**
 *
 * @author bruno
 */
public class FilmeDAOImpl implements FilmeDAO {

    private Map<String, Filme> filmes = new HashMap<String, Filme>();

    public void inserir(Filme filme) throws RegistroException {

        if (filmes.containsKey(filme.getExemplar().getNome())) {
            throw new RegistroException();
        }

        if (filme.getExemplar().getNome().equals("")) {
            throw new RegistroException("Filme invalido");
        }

        filmes.put(filme.getExemplar().getNome(), filme);

    }

    public void remover(String filme) {
        filmes.remove(filme);
    }

    @Override
    public void alterar(Filme filme, Filme chave) throws RegistroException {
        filmes.remove(chave.getExemplar().getNome());
        try{
            this.inserir(filme);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Filme consultar(String filme) {
        return filmes.get(filme);
    }

    public Map<String, Filme> listar() {
        return filmes;
    }


}
