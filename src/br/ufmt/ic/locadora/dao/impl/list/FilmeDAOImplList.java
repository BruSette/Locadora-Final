/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.list;

import br.ufmt.ic.locadora.dao.impl.*;
import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class FilmeDAOImplList implements FilmeDAO {

    private List<Filme> filmes = new ArrayList<Filme>();

    public void inserir(Filme filme) throws RegistroException {

        filmes.add(filme);

    }

    public void remover(Filme filme) {
        filmes.remove(filme);
    }

    @Override
    public void alterar(Filme filme, Filme chave) throws RegistroException {
        filmes.remove(chave);
        try{
            this.inserir(filme);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Filme consultar(String filme) {
        return null;
    }

    public List<Filme> listar() {
        return filmes;
    }


}
