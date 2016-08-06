/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.vetor;

import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Cliente;

/**
 *
 * @author brunosette
 */
public class ClienteDAOImpl implements ClienteDAO {

    Cliente[] clientes = new Cliente[10];

    public void inserir(Cliente cliente) throws CPFException {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                if (clientes[i].getCpf().equals(cliente.getCpf())) {
                    throw new CPFException();
                }
            }
        }

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                if(cliente.getCpf().equals("   .   .   -  ")){
                    throw new CPFException("Erro no CPF");
                }
                clientes[i] = cliente;
                System.out.println("Inserido com Sucesso!");
                break;
            }
        }

    }

    public void remover(String cpf) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                if (clientes[i].getCpf().equals(cpf)) {
                    clientes[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(Cliente cliente) {

    }

    public Cliente consultar(String cpf) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                if (clientes[i].getCpf().equals(cpf)) {
                    return clientes[i];
                }
            }
        }
        return null;
    }

    public Cliente[] listar() {
        return clientes;
    }

}
