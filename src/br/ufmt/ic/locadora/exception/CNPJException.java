/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.exception;

/**
 *
 * @author brunosette
 */
public class CNPJException extends Exception  {
    public CNPJException() {
        super("CNPJ já cadastrado!");
    }
    
    public CNPJException(String mensagem) {
        super(mensagem);
    }
}
