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
public class Agencia {
    
    private String codigo;
    private Endereco endereco;
    private PessoaFisica gerente;
    private Banco banco;
    private String telefone;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public PessoaFisica getGerente() {
        return gerente;
    }
    
    public void setGerente(PessoaFisica gerente) {
        this.gerente = gerente;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String nome) {
        this.codigo = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String toString(){
        return getCodigo();
    }
    
}
