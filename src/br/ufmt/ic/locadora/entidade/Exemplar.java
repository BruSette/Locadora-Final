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
public class Exemplar implements Generica {
    
    private String nome;
    private Genero genero;
    private Date datalancamento;
    private int codigo;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Exemplar other = (Exemplar) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }
    
    @Override
    public String toString(){
        return getNome() + " - " + getGenero();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
}
