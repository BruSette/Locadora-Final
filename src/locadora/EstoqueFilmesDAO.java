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
public interface EstoqueFilmesDAO {
    public void inserir(EstoqueFilmes estoque) throws RegistroException;

    public void remover(String nomeEstoque);

    public void alterar(EstoqueFilmes estoque);

    public EstoqueFilmes consultar(String nomeEstoque);

    public EstoqueFilmes[] listar();
}
