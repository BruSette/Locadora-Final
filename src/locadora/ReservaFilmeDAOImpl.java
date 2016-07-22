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

    public void inserir(ReservaFilme reserva) throws RegistroException {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFilme().getNomeFilme().equals(reserva.getFilme().getNomeFilme())) {
                    throw new RegistroException();
                }
            }
        }

        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) {
                reservas[i] = reserva;
                System.out.println("Inserido com Sucesso!");
                break;
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
