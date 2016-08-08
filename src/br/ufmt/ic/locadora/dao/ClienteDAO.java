/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Cliente;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface ClienteDAO {
    
    public void inserir(Cliente cliente) throws CPFException;

    public void remover(String cpf);

    public void alterar(Cliente cliente, Cliente chave) throws CPFException;

    public Cliente consultar(String cpf);

    public Map<String, Cliente> listar();
}
