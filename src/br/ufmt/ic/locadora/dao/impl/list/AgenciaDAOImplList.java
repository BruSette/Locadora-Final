/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.list;

import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class AgenciaDAOImplList implements AgenciaDAO {

    private List<Agencia> agencias = new ArrayList<Agencia>();

    public void inserir(Agencia agencia) throws RegistroException {

        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigoAgencia().equals(agencia.getCodigoAgencia())) {
                throw new RegistroException();
            }
        }
        agencias.add(agencia);

    }

    public void remover(Agencia agencia) {
        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigoAgencia().equals(agencia.getCodigoAgencia())) {
                agencias.remove(agencia);
            }
        }

    }

    public void alterar(Agencia agencia, Agencia chave) throws RegistroException {
        try {
            this.inserir(agencia);
        } catch (RegistroException erro) {
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Agencia consultar(String nome) {
        return null;
    }

    public List<Agencia> listar() {
        return agencias;
    }

}
