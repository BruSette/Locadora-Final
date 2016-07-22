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
public interface UsuarioDAO {
    
    public void inserir(Usuario usuario) throws UsuarioException;

    public void remover(String usuario);

    public void alterar(Usuario usuario);

    public Usuario consultar(String usuario);

    public Usuario[] listar();
}
