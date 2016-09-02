/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;


/**
 *
 * @author brunosette
 */
public class Entidade extends PessoaJuridica{
    private String obs;

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String toString(){
        return  getNome() + " - " + getCnpj() ;
    }
    
}
