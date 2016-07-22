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
public interface ReservaFilmeDAO {
    public void inserir(ReservaFilme reserva) throws RegistroException;

    public void remover(String cpf);

    public void alterar(ReservaFilme reserva);

    public ReservaFilme consultar(String cpf);

    public ReservaFilme[] listar();
}
