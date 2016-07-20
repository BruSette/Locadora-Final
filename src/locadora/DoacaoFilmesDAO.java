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
public interface DoacaoFilmesDAO {
    public void inserir(DoacaoFilmes doacao);

    public void remover(String entidade);

    public void alterar(DoacaoFilmes doacao);

    public DoacaoFilmes consultar(String entidade);

    public DoacaoFilmes[] listar();
}
