/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author brunosette
 */
public class Ponto {
    private Funcionario funcionario;
    private Date dataPonto;
    private String TipoPonto;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.funcionario);
        hash = 17 * hash + Objects.hashCode(this.dataPonto);
        hash = 17 * hash + Objects.hashCode(this.TipoPonto);
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
        final Ponto other = (Ponto) obj;
        if (!Objects.equals(this.TipoPonto, other.TipoPonto)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.dataPonto, other.dataPonto)) {
            return false;
        }
        return true;
    }
    
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataPonto() {
        return dataPonto;
    }

    public void setDataPonto(Date dataPonto) {
        this.dataPonto = dataPonto;
    }

    public String getTipoPonto() {
        return TipoPonto;
    }

    public void setTipoPonto(String TipoPonto) {
        this.TipoPonto = TipoPonto;
    }
    
    public String toString(){
        return getFuncionario() +" - "+ getTipoPonto();
    }
    
}
