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
public interface ClienteDAO {
    
    public void inserir(Cliente cliente);

    public void remover(String cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(String cpf);

    public Cliente[] listar();
}
