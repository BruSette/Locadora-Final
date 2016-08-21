/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.exception.CNPJException;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface FornecedorDAO {
    public void inserir(Fornecedor fornecedor) throws CNPJException;

    public void remover(String cpf);

    public void alterar(Fornecedor fornecedor, Fornecedor chave) throws CNPJException;

    public Fornecedor consultar(String cpf);

    public Map<String,Fornecedor> listar();
}
