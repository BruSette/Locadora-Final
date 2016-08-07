/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class ClienteDAOImpl implements ClienteDAO {

    private Map<String, Cliente> clientes = new HashMap<String, Cliente>();
        

    public void inserir(Cliente cliente) throws CPFException {
        
        if (clientes.containsKey(cliente.getCpf())) {
            throw new CPFException();
        }
        
        if(cliente.getCpf().equals("   .   .   -  ")){
            throw new CPFException("Erro no CPF");
        }
        
        clientes.put(cliente.getCpf(), cliente);
        

    }

    public void remover(String cpf) {
        clientes.remove(cpf);
    }

    public void alterar(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }
    
    public Cliente consultar(String cpf) {
        return clientes.get(cpf);
    }

    public Map<String, Cliente> listar() {
        return clientes;
    }

}
