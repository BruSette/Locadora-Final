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
    
    double ValorPagar;
    
    @Override
    public String toString() {
        return "PagamentoCompra []";
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
