/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.EstoqueFilmes;
import br.ufmt.ic.locadora.entidade.PessoaJuridica;
import br.ufmt.ic.locadora.entidade.Filme;
import java.util.Date;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmes {

    private Filme filmes;
    private PessoaJuridica entidade;
    private EstoqueFilmes estoque;
    private Date dataDoacao;
    private Funcionario responsavel;

    public DoacaoFilmes(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Filme getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme filmes) {
        this.filmes = filmes;
    }

    public PessoaJuridica getEntidade() {
        return entidade;
    }

    public void setEntidade(PessoaJuridica entidade) {
        this.entidade = entidade;
    }

    public EstoqueFilmes getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueFilmes estoque) {
        this.estoque = estoque;
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
