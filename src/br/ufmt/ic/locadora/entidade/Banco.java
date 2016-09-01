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
public class Banco  {
    private String nome;
    private String cod;

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeBanco) {
        this.nome = nomeBanco;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String codBanco) {
        this.cod = codBanco;
    }
    
    public String toString(){
        return getNome();
    }
    
    
}
