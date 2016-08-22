/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.exception.CNPJException;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface EntidadeDAO {
    
    public void inserir(Entidade entidade) throws CNPJException;

    public void remover(String nome);

    public void alterar(Entidade entidade, Entidade chave) throws CNPJException;

    public Entidade consultar(String nome);

    public Map<String, Entidade> listar();
    
}
