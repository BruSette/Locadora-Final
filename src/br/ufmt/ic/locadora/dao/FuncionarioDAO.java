/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.exception.UsuarioException;
import java.util.Map;

/**
 *
 * @author bruno
 */
public interface FuncionarioDAO {
    public void inserir(Funcionario funcionario) throws CPFException,UsuarioException;

    public void remover(String cpf);

    public void alterar(Funcionario funcionario);

    public Funcionario consultar(String cpf);

    public Map<String, Funcionario> listar();
}
