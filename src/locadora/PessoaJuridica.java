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
public class PessoaJuridica extends Pessoa {
    
    private String cnpj;
    private String razaoSocial;
    private String fax;
    private PessoaFisica contato;
    private String funcao;
    private ContaBancaria conta;
    
    public PessoaJuridica() {
	super();
    }

	public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public PessoaFisica getContato() {
        return contato;
    }

    public void setContato(PessoaFisica contato) {
        this.contato = contato;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

	@Override
	public String toString() {
		return "PessoaJuridica []";
	}
    
    
    
}
