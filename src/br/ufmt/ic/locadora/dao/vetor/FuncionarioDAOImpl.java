/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.vetor;

import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.exception.UsuarioException;

/**
 *
 * @author bruno
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    
    private Funcionario[] funcionarios = new Funcionario[10];

    public void inserir(Funcionario funcionario) throws CPFException,UsuarioException {
        boolean achou = false;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null) {
                if (funcionarios[i].getCpf().equals(funcionario.getCpf())) {
                    throw new CPFException();
                }
                
                if(funcionarios[i].getUsuario().getUsuario().equals(funcionario.getUsuario().getUsuario())){
                    throw new UsuarioException();
                }
            }
        }
        if (!achou) {
            for (int i = 0; i < funcionarios.length; i++) {
                if (funcionarios[i] == null) {
                    if(funcionario.getCpf().equals("   .   .   -  ")){
                        throw new CPFException("Erro no CPF");
                    }
                    
                    if(funcionario.getUsuario().getUsuario().equals("") || funcionario.getUsuario().getSenha().equals("") ){
                        throw new UsuarioException("Usuario ou senha invalidos!");
                    }
                    funcionarios[i] = funcionario;
                    System.out.println("Inserido com Sucesso!");
                    break;
                }
            }
        }
    }

    public void remover(String cpf) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null) {
                if (funcionarios[i].getCpf().equals(cpf)) {
                    funcionarios[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(Funcionario funcionario) {

    }

    public Funcionario consultar(String cpf) {
        return null;
    }

    public Funcionario[] listar() {
        return funcionarios;
    }
    
}
