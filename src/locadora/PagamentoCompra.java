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
public class PagamentoCompra extends Pagamento {
    
    private OperacaoEstoqueFilmes compra;
		
    public OperacaoEstoqueFilmes getCompra() {
		return compra;
	}

	public void setCompra(OperacaoEstoqueFilmes compra) {
		this.compra = compra;
	}

	public void pagar(OperacaoEstoqueFilmes compra){
        
    }

	@Override
	public String toString() {
		return "PagamentoCompra []";
	}
	
	
	
}
