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
public interface FilmesDAO {
    
    public void inserir(Filme filme);

    public void remover(String nome);

    public void alterar(Filme filme);

    public Filme consultar(String nome);

    public Filme[] listar();
    
}
