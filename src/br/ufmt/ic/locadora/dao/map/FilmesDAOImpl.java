/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.map;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.dao.FilmesDAO;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class FilmesDAOImpl implements FilmesDAO {

    private Map<String, Filme> filmes = new HashMap<String, Filme>();

    public void inserir(Filme filme) throws RegistroException {

        
        if (filmes.containsKey(filme.getNomeFilme())) {
            throw new RegistroException();
        }

        if (filme.getNomeFilme().equals("")) {
            throw new RegistroException("Filme invalido");
        }

        filmes.put(filme.getNomeFilme(), filme);

    }

    public void remover(String filme) {
        filmes.remove(filme);
    }

    @Override
    public void alterar(Filme filme) {
         filmes.put(filme.getNomeFilme(), filme);
    }

    public Filme consultar(String filme) {
        return filmes.get(filme);
    }

    public Map<String, Filme> listar() {
        return filmes;
    }

}
