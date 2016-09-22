/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import br.ufmt.ic.locadora.entidade.Agencia;
import java.util.Objects;

/**
 *
 * @author brunosette
 */
public class ContaBancaria implements Generica {

    private Banco banco;
    private String contaNumero;

    public Banco getBanco() {
        return banco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.banco);
        hash = 47 * hash + Objects.hashCode(this.contaNumero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaBancaria other = (ContaBancaria) obj;
        if (!Objects.equals(this.contaNumero, other.contaNumero)) {
            return false;
        }
        if (!Objects.equals(this.banco, other.banco)) {
            return false;
        }
        return true;
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

    @Override
    public void setCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
