/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.EstoqueFilmes;
import br.ufmt.ic.locadora.dao.EstoqueFilmesDAO;

/**
 *
 * @author brunosette
 */
public class EstoqueFilmesDAOImpl implements EstoqueFilmesDAO {

    EstoqueFilmes estoques[] = new EstoqueFilmes[10];

    public void inserir(EstoqueFilmes estoque) throws RegistroException {
        for (int i = 0; i < estoques.length; i++) {
            if (estoques[i] != null) {
                if (estoques[i].getNomeEstoque().equals(estoque.getNomeEstoque())) {
                    throw new RegistroException();
                }
            }
        }
        for (int i = 0; i < estoques.length; i++) {
            if (estoques[i] == null) {
                
                if (estoque.getNomeEstoque().equals("")){
                    throw new RegistroException("Estoque invalido");
                }
                
                estoques[i] = estoque;
                System.out.println("Inserido com Sucesso!");
                break;
            }
        }

    }

    public void remover(String nomeEstoque) {
        for (int i = 0; i < estoques.length; i++) {
            if (estoques[i] != null) {
                if (estoques[i].getNomeEstoque().equals(nomeEstoque)) {
                    estoques[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(EstoqueFilmes estoque) {

    }

    public EstoqueFilmes consultar(String nomeEstoque) {
        for (int i = 0; i < estoques.length; i++) {
            if (estoques[i] != null) {
                if (estoques[i].getNomeEstoque().equals(nomeEstoque)) {
                    return estoques[i];
                }
            }
        }
        return null;
    }

    public EstoqueFilmes[] listar() {
        return estoques;
    }

}
