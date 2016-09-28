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
public class DoacaoFilmes implements Generica {

    private Filme filme;
    private Entidade entidade;
    private Date dataDoacao;
    private Funcionario responsavel;
    private int codigo;

    
    public DoacaoFilmes() {
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.filme);
        hash = 97 * hash + Objects.hashCode(this.entidade);
        hash = 97 * hash + Objects.hashCode(this.dataDoacao);
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
        final DoacaoFilmes other = (DoacaoFilmes) obj;
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        if (!Objects.equals(this.entidade, other.entidade)) {
            return false;
        }
        if (!Objects.equals(this.dataDoacao, other.dataDoacao)) {
            return false;
        }
        return true;
    }
    
    

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString(){
        return getEntidade().toString() + " - "  + getFilme().getExemplar().getNome();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   

}
