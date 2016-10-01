/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.gui.PrincipalJFrame;
import java.text.DateFormat.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brunosette
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*Agencia t = new Agencia();
        System.out.println(t.getClass().getSimpleName().toLowerCase());
        Class<Agencia> classe = Agencia.class;
        for (java.lang.reflect.Field atributo : classe.getDeclaredFields()) {
            System.out.println(atributo.getName() + " e " + atributo.getType());
            try {
                Class cls = Class.forName(atributo.getName());
                
                
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/
        
        
        
        PrincipalJFrame tela = new PrincipalJFrame();
        tela.setVisible(true);

    }

}
