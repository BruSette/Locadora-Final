/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import java.util.Date;

/**
 *
 * @author brunosette
 */
public class Ponto {
    private Funcionario funcionario;
    private Date dataPonto;
    private String TipoPonto;

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
        return getFuncionario() + getTipoPonto();
    }
    
}
