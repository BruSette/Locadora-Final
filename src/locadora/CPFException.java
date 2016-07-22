/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author raphael
 */
public class CPFException extends Exception {

    public CPFException() {
        super("CPF já cadastrado!");
    }

}
