/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import locadora.FabricaDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.Usuario;
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
    private UsuarioDAO daousuario = FabricaDAO.CriarUsuarioDAO();

    public void inserir(Funcionario funcionario) throws CPFException, UsuarioException {

        if (funcionarios.containsKey(funcionario.getCpf())) {
            throw new CPFException();
        }
        
        daousuario.inserir(funcionario.getUsuario());
        
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
        this.daousuario.remover(funcionarios.get(cpf).getUsuario().getUsuario());
        funcionarios.remove(cpf);
    }

    public void alterar(Funcionario funcionario, Funcionario chave) throws CPFException,UsuarioException {
        this.remover(chave.getCpf());
        try{
            this.inserir(funcionario);
        }catch (CPFException erro){
            this.inserir(chave);
            throw new CPFException();
        }catch (UsuarioException erro){
            this.inserir(chave);
            throw new UsuarioException();
        }
    }

    public Funcionario consultar(String cpf) {
        return funcionarios.get(cpf);
    }

    public Map<String, Funcionario> listar() {
        return funcionarios;
    }

}
