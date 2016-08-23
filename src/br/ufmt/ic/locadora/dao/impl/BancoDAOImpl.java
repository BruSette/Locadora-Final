/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class BancoDAOImpl implements BancoDAO {

    private List<Banco> bancos = new ArrayList<Banco>();

    public void inserir(Banco banco) throws RegistroException {

        for (Banco bancolist : bancos) {
            if (bancolist.getCod().equals(banco.getCod())) {

                throw new RegistroException();

            }

        }

        bancos.add(banco);

    }

    public int remover(Banco banco) {
        for (Banco bancolist : bancos) {
            if (bancolist.getCod().equals(banco.getCod())) {

                bancos.remove(banco);
                return 1;

            }
        }
        return 0;
    }

    public void alterar(Banco banco, Banco chave) throws RegistroException {
        if (remover(chave) == 1) {
            try {
                this.inserir(banco);
            } catch (RegistroException erro) {
                this.inserir(chave);
                throw new RegistroException();
            }
        }

    }

    public Banco consultar(String nome) {
        return null;
    }

    public List<Banco> listar() {
        return bancos;
    }
}
