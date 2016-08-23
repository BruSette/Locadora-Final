/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class TipoCargoDAOImpl implements TipoCargoDAO {
    
    private Map<String, TipoCargo> tipocargos = new HashMap<String, TipoCargo>();

    public void inserir(TipoCargo tipocargo) throws RegistroException {

        if (tipocargos.containsKey(tipocargo.getNome())) {
            throw new RegistroException();
        }
        tipocargos.put(tipocargo.getNome(), tipocargo);

    }

    public void remover(String nome) {
        tipocargos.remove(nome);
    }

    public void alterar(TipoCargo tipocargo, TipoCargo chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(tipocargo);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public TipoCargo consultar(String nome) {
        return tipocargos.get(nome);
    }

    public Map<String, TipoCargo> listar() {
        return tipocargos;
    }

    
}
