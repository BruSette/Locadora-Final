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
public class EstoqueFilmes extends Estoque {

    private Filme filmes;
    private String categoria;

    public EstoqueFilmes() {

    }

    public Filme getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme filmes) {
        this.filmes = filmes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "EstoqueFilmes []";
    }

}
