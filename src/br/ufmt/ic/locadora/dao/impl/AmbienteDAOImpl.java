/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class AmbienteDAOImpl implements AmbienteDAO {
    private Map<String, Ambiente> ambientes = new HashMap<String, Ambiente>();

    public void inserir(Ambiente ambiente) throws RegistroException {

        if (ambientes.containsKey(ambiente.getNome())) {
            throw new RegistroException();
        }

       

        ambientes.put(ambiente.getNome(), ambiente);

    }

    public void remover(String nome) {
        ambientes.remove(nome);
    }

    public void alterar(Ambiente ambiente, Ambiente chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(ambiente);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public Ambiente consultar(String nome) {
        return ambientes.get(nome);
    }

    public Map<String, Ambiente> listar() {
        return ambientes;
    }
}
