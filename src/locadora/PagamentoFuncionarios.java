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
public class PagamentoFuncionarios extends Pagamento {
    private Funcionario funcionarios[];
    
    
    
    public Funcionario[] getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void pagar (Funcionario funcionarios[]){
        
    }

	@Override
	public String toString() {
		return "PagamentoFuncionarios []";
	}
	
	
}
