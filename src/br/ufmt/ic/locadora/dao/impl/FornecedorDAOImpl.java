/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.exception.CNPJException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class FornecedorDAOImpl implements FornecedorDAO {
    private Map<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();

    public void inserir(Fornecedor fornecedor) throws CNPJException {

        if (fornecedores.containsKey(fornecedor.getCnpj())) {
            throw new CNPJException();
        }
        
        
        
        if (fornecedor.getCnpj().equals("  .   .   /    -  ")) {
            throw new CNPJException("Erro no CNPJ");
        }

        fornecedores.put(fornecedor.getCnpj(), fornecedor);
        
        
    }

    public void remover(String cpf) {
        fornecedores.remove(cpf);
    }

    public void alterar(Fornecedor fornecedor, Fornecedor chave) throws CNPJException {
        this.remover(chave.getCnpj());
        try{
            this.inserir(fornecedor);
        }catch (CNPJException erro){
            this.inserir(chave);
            throw new CNPJException();
        }
    }

    public Fornecedor consultar(String cnpj) {
        return fornecedores.get(cnpj);
    }

    public Map<String, Fornecedor> listar() {
        return fornecedores;
    }

}
