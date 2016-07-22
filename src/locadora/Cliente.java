/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author brunosette
 */
public class Cliente extends PessoaFisica {

    private Boolean bloqueado;
    private int limiteFilmes;

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
    public String toString() {
        return "Cliente []";
    }

}
