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
public class Pagamento {
	
    private ContaBancaria conta;

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Pagamento []";
	}
    
    
	
    //Definir a chamada das classes de pagamento compra ou pagamento de funcionarios
    
}
