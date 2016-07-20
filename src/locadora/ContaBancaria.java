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
public class ContaBancaria {

    private Banco banco;
    private String agencia;
    private String contaNumero;

    public ContaBancaria(Banco banco, String agencia) {
        super();
        this.banco = banco;
        this.agencia = agencia;
    }

    public ContaBancaria(String agencia) {
        super();
        this.agencia = agencia;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(String contaNumero) {
        this.contaNumero = contaNumero;
    }

    @Override
    public String toString() {
        return "ContaBancaria []";
    }

}
