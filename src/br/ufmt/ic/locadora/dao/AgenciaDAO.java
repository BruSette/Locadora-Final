/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.List;

/**
 *
 * @author brunosette
 */
public interface AgenciaDAO {
    
    public void inserir(Agencia agencia) throws RegistroException;

    public void remover(Agencia agencia);

    public void alterar(Agencia agencia, Agencia chave) throws RegistroException;

    public Agencia consultar(String nome);

    public List<Agencia> listar();
    
}
