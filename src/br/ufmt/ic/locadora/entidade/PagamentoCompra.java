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
public class PagamentoCompra extends Pagamento implements Generica {
    
    private double ValorPagar;
    private int codigo;
    @Override
    public String toString() {
        return "PagamentoCompra []";
    }

    public double getValorPagar() {
        return ValorPagar;
    }

    public void setValorPagar(double ValorPagar) {
        this.ValorPagar = ValorPagar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
