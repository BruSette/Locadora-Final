/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.Filme;
import java.util.Map;

/**
 *
 * @author bruno
 */
public interface FilmesDAO {
    
    public void inserir(Filme filme) throws RegistroException;

    public void remover(String nome);

    public void alterar(Filme filme);

    public Filme consultar(String nome);

    public Map<String, Filme> listar();
    
}
