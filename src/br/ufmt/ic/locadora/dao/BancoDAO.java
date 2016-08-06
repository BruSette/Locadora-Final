/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;

/**
 *
 * @author brunosette
 */
public interface BancoDAO {
    
    public void inserir(Banco banco) throws RegistroException;

    public void remover(String nome);

    public void alterar(Banco banco);

    public Banco consultar(String nome);

    public Banco[] listar();
    
}
