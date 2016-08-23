/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class AgenciaDAOImpl implements AgenciaDAO {

    private List<Agencia> agencias = new ArrayList<Agencia>();

    public void inserir(Agencia agencia) throws RegistroException {

        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigo().equals(agencia.getCodigo())) {
                throw new RegistroException();

            }

        }

        agencias.add(agencia);

    }

    public int remover(Agencia agencia) {
        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigo().equals(agencia.getCodigo())) {
                agencias.remove(agencia);
                return 1;

            }
        }
        return 0;
    }

    public void alterar(Agencia agencia, Agencia chave) throws RegistroException {
        if (remover(chave) == 1) {
            try {
                this.inserir(agencia);
            } catch (RegistroException erro) {
                this.inserir(chave);
                throw new RegistroException();
            }
        }

    }

    public Agencia consultar(String nome) {
        return null;
    }

    public List<Agencia> listar() {
        return agencias;
    }

}
