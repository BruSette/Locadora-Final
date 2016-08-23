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
public class Funcionario extends PessoaFisica {

    private Date dataAdmiss;
    private Date dataDemiss;
    private TipoCargo cargo;
    private Ambiente ambiente;
    private Usuario usuario;

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

        
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataAdmiss() {
        return dataAdmiss;
    }

    public void setDataAdmiss(Date dataAdmiss) {
        this.dataAdmiss = dataAdmiss;
    }

    public Date getDataDemiss() {
        return dataDemiss;
    }

    public void setDataDemiss(Date dataDemiss) {
        this.dataDemiss = dataDemiss;
    }

    public TipoCargo getCargo() {
        return cargo;
    }

    public void setCargo(TipoCargo cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return getNome() + " - " + getCpf();
    }

}
