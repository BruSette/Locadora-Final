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
public class Cliente extends PessoaFisica implements Generica {

    private Boolean bloqueado;
    private int limiteFilmes;
    private int codigo;
    
    public Cliente(String nome) {
        this.setNome(nome);
    }
    
    public Cliente() {
       
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getLimiteFilmes() {
        return limiteFilmes;
    }

    public void setLimiteFilmes(int limiteFilmes) {
        this.limiteFilmes = limiteFilmes;
    }

    @Override
   public String toString(){
        return getNome() + " - "  + getCpf();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
}
