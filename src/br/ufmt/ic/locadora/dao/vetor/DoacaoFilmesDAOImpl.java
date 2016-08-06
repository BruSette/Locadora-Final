/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.vetor;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.RegistroException;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmesDAOImpl implements DoacaoFilmesDAO {

    DoacaoFilmes doacoes[] = new DoacaoFilmes[10];

    public void inserir(DoacaoFilmes doacao) throws RegistroException{

        for (int i = 0; i < doacoes.length; i++)  {
            if (doacoes[i] != null) {
                if (doacoes[i].getEntidade().getNome().equals(doacao.getEntidade().getNome())) {
                    throw new RegistroException();
                }
            }
        }

        for (int i = 0; i < doacoes.length; i++) {
            if (doacoes[i] == null) {
                
                if (doacao.getFilmes().getNomeFilme().equals("")){
                    throw new RegistroException("Filme invalido");
                }
                
                doacoes[i] = doacao;
                System.out.println("Inserido com Sucesso!");
                break;
            }
        }

    }

    public void remover(String entidade) {
        for (int i = 0; i < doacoes.length; i++) {
            if (doacoes[i] != null) {
                if (doacoes[i].getEntidade().getNome().equals(entidade)) {
                    doacoes[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(DoacaoFilmes doacao) {

    }

    public DoacaoFilmes consultar(String entidade) {
        for (int i = 0; i < doacoes.length; i++) {
            if (doacoes[i] != null) {
                if (doacoes[i].getEntidade().equals(entidade)) {
                    return doacoes[i];
                }
            }
        }
        return null;
    }

    public DoacaoFilmes[] listar() {
        return doacoes;
    }

}
