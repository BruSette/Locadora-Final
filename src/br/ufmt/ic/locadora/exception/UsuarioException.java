/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.exception;

/**
 *
 * @author raphael
 */
public class UsuarioException extends Exception {

    public UsuarioException() {
        super("Usuário já cadastrado!");
    }
    
    public UsuarioException(String mensagem) {
        super(mensagem);
    }

}
