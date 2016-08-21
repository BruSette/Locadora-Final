/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface ExemplarDAO {
    
    public void inserir(Exemplar exemplar) throws RegistroException;

    public void remover(String nome);

    public void alterar(Exemplar exemplar, Exemplar chave) throws RegistroException;

    public Exemplar consultar(String nome);

    public Map<String, Exemplar> listar();
}
