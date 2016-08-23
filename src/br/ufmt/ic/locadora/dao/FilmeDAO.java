/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.Filme;
import java.util.List;

/**
 *
 * @author bruno
 */
public interface FilmeDAO {
    
    public void inserir(Filme filme) throws RegistroException;

    public void remover(Filme filme);

    public void alterar(Filme filme, Filme chave) throws RegistroException;

    public Filme consultar(String nome);

    public List<Filme> listar();
    
}
