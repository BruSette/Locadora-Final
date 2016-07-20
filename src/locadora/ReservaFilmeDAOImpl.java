/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author bruno
 */
public class ReservaFilmeDAOImpl implements ReservaFilmeDAO {

    ReservaFilme reservas[] = new ReservaFilme[10];
    public void inserir(ReservaFilme reserva) {
        boolean achou = false;
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFilme().getNomeFilme().equals(reserva.getFilme().getNomeFilme())) {
                    System.out.println("Reserva já cadastrada!");
                    achou = true;
                    break;
                }
            }
        }
        if (!achou) {
            for (int i = 0; i < reservas.length; i++) {
                if (reservas[i] == null) {
                    reservas[i] = reserva;
                    System.out.println("Inserido com Sucesso!");
                    break;
                }
            }
        }
    }

    
    public void remover(String nomeFilme) {
       for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFilme().getNomeFilme().equals(nomeFilme)) {
                    reservas[i] = null;
                    break;
                }
            }
        }
    }

    
    public void alterar(ReservaFilme reserva) {
        
    }

    
    public ReservaFilme consultar(String nomeFilme) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFilme().getNomeFilme().equals(nomeFilme)) {
                    return reservas[i];
                }
            }
        }
        return null;
    }

    
    public ReservaFilme[] listar() {
        return reservas;
    }
    
}
