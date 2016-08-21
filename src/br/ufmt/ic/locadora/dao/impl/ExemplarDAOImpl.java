/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class ExemplarDAOImpl implements ExemplarDAO {
    private Map<String, Exemplar> exemplares = new HashMap<String, Exemplar>();

    public void inserir(Exemplar exemplar) throws RegistroException {

        if (exemplares.containsKey(exemplar.getNome())) {
            throw new RegistroException();
        }

       

        exemplares.put(exemplar.getNome(), exemplar);

    }

    public void remover(String nome) {
        exemplares.remove(nome);
    }

    public void alterar(Exemplar exemplar, Exemplar chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(exemplar);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public Exemplar consultar(String nome) {
        return exemplares.get(nome);
    }

    public Map<String, Exemplar> listar() {
        return exemplares;
    }

}
