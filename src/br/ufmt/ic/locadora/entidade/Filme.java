/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import java.util.Objects;

/**
 *
 * @author brunosette
 */
public class Filme implements Generica {

    private Exemplar exemplar;
    private Boolean disponibilidade;
    private Double valorAluguel;
    private int quantidade;
    private Fornecedor fornecedor;
    private Funcionario funcionario;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.exemplar);
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
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.exemplar, other.exemplar)) {
            return false;
        }
        return true;
    }

    
    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
        
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor  fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Filme() {
        super();
    }


    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString(){
        return getExemplar().getNome();
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
