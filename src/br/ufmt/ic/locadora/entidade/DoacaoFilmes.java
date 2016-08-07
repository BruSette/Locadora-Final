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
public class DoacaoFilmes {

    private Filme filme;
    private PessoaJuridica entidade;
    private Date dataDoacao;
    private Funcionario responsavel;

    public DoacaoFilmes(Funcionario responsavel) {
        this.responsavel = responsavel;
    }
    public DoacaoFilmes() {
        
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public PessoaJuridica getEntidade() {
        return entidade;
    }

    public void setEntidade(PessoaJuridica entidade) {
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
    public String toString() {
        return "DoacaoFilmes []";
    }

}
