/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.vetor;

import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;

/**
 *
 * @author brunosette
 */
public class BancoDAOImpl implements BancoDAO {

    private Banco[] bancos = new Banco[10];

    public void inserir(Banco banco) throws RegistroException {
        boolean achou = false;
        for (int i = 0; i < bancos.length; i++) {
            if (bancos[i] != null) {
                if (bancos[i].getNome().equals(banco.getNome())) {
                    throw new RegistroException();
                }
            }
        }

        for (int i = 0; i < bancos.length; i++) {
            if (bancos[i] == null) {
                if (banco.getNome().equals("")){
                    throw new RegistroException("Banco invalido");
                }
                bancos[i] = banco;
                System.out.println("Inserido com Sucesso!");
                break;
            }
        }

    }

    public void remover(String nome) {
        for (int i = 0; i < bancos.length; i++) {
            if (bancos[i] != null) {
                if (bancos[i].getNome().equals(nome)) {
                    bancos[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(Banco banco) {

    }

    public Banco consultar(String nome) {
        for (int i = 0; i < bancos.length; i++) {
            if (bancos[i] != null) {
                if (bancos[i].getNome().equals(nome)) {
                    return bancos[i];
                }
            }
        }
        return null;
    }

    public Banco[] listar() {
        return bancos;
    }

}
