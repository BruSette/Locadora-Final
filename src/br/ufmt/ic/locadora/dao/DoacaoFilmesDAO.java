/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Set;

/**
 *
 * @author brunosette
 */
public interface DoacaoFilmesDAO {
    public void inserir(DoacaoFilmes doacao) throws RegistroException;

    public void remover(DoacaoFilmes doacao);

    public void alterar(DoacaoFilmes doacao);

    public DoacaoFilmes consultar(DoacaoFilmes doacao);

    public Set<DoacaoFilmes> listar();
}
