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
public class EstoqueFilmesDAOImpl implements EstoqueFilmesDAO {

    EstoqueFilmes estoques[] = new EstoqueFilmes[10];

    public void inserir(EstoqueFilmes estoque) {
        boolean achou = false;
        for (int i = 0; i < estoques.length; i++) {
            if (estoques[i] != null) {
                if (estoques[i].getNomeEstoque().equals(estoque.getNomeEstoque())) {
                    System.out.println("Estoque já cadastrado!");
                    achou = true;
                    break;
                }
            }
        }
        if (!achou) {
            for (int i = 0; i < estoques.length; i++) {
                if (estoques[i] == null) {
                    estoques[i] = estoque;
                    System.out.println("Inserido com Sucesso!");
                    break;
                }
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
