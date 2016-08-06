/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.map;

import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.exception.UsuarioException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    private Map<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
    private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public void inserir(Funcionario funcionario) throws CPFException, UsuarioException {

        if (funcionarios.containsKey(funcionario.getCpf())) {
            throw new CPFException();
        }

        if (usuarios.containsKey(funcionario.getUsuario().getUsuario())) {
            throw new UsuarioException();
        }
        if (funcionario.getCpf().equals("   .   .   -  ")) {
            throw new CPFException("Erro no CPF");
        }

        if (funcionario.getUsuario().getUsuario().equals("") || funcionario.getUsuario().getSenha().equals("")) {
            throw new UsuarioException("Usuario ou senha invalidos!");
        }

        funcionarios.put(funcionario.getCpf(), funcionario);
        usuarios.put(funcionario.getUsuario().getUsuario(), funcionario.getUsuario());

        
    }

    public void remover(String cpf) {
        funcionarios.remove(cpf);
    }

    public void alterar(Funcionario funcionario) {

    }

    public Funcionario consultar(String cpf) {
        return null;
    }

    public Map<String, Funcionario> listar() {
        return funcionarios;
    }

}
