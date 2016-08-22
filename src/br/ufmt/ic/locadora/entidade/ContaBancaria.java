/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import br.ufmt.ic.locadora.entidade.Agencia;

/**
 *
 * @author brunosette
 */
public class ContaBancaria {

    private Banco banco;
    private String contaNumero;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(String contaNumero) {
        this.contaNumero = contaNumero;
    }

    

   
    @Override
    public String toString(){
        return getContaNumero() + " - "  + getBanco();
    }
}
