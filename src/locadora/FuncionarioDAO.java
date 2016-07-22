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
public interface FuncionarioDAO {
    public void inserir(Funcionario funcionario) throws CPFException,UsuarioException;

    public void remover(String cpf);

    public void alterar(Funcionario funcionario);

    public Funcionario consultar(String cpf);

    public Funcionario[] listar();
}
