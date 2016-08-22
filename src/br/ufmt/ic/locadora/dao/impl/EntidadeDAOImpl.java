/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.exception.CNPJException;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class EntidadeDAOImpl implements EntidadeDAO {
   private Map<String, Entidade> entidades = new HashMap<String, Entidade>();

    public void inserir(Entidade entidade) throws CNPJException {

        if (entidades.containsKey(entidade.getCnpj())) {
            throw new CNPJException();
        }
        
        
        
        if (entidade.getCnpj().equals("  .   .   /    -  ")) {
            throw new CNPJException("Erro no CNPJ");
        }

        entidades.put(entidade.getCnpj(), entidade);
        
        
    }

    public void remover(String cpf) {
        entidades.remove(cpf);
    }

    public void alterar(Entidade entidade, Entidade chave) throws CNPJException {
        this.remover(chave.getCnpj());
        try{
            this.inserir(entidade);
        }catch (CNPJException erro){
            this.inserir(chave);
            throw new CNPJException();
        }
    }

    public Entidade consultar(String cnpj) {
        return entidades.get(cnpj);
    }

    public Map<String, Entidade> listar() {
        return entidades;
    }

}
