/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmesDAOImpl implements DoacaoFilmesDAO {

    private List<DoacaoFilmes> doacoes = new ArrayList<DoacaoFilmes>();

    public void inserir(DoacaoFilmes doacao) throws RegistroException {
        
        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getNomeFilme().equals(doacao.getFilme().getNomeFilme())) {
                if (doacaolist.getEntidade().getNome().equals(doacao.getEntidade().getNome())) {
                    System.out.println("Deu erro!");
                    throw new RegistroException();
                }
            }

        }   

        if (doacao.getFilme().getNomeFilme().equals("")) {
            throw new RegistroException("Nome do filme invalido");
        }

        if (doacao.getEntidade().getNome().equals("")) {
            throw new RegistroException("Nome do cliente invalido");
        }
        doacoes.add(doacao);

    }

    public void remover(DoacaoFilmes doacao) {
         for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getNomeFilme().equals(doacao.getFilme().getNomeFilme())) {
                if (doacaolist.getEntidade().getNome().equals(doacaolist.getEntidade().getNome())) {
                   doacoes.remove(doacao);
                }
            }

        }   
        
        
        
    }

    public void alterar(DoacaoFilmes doacao) {
        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getNomeFilme().equals(doacao.getFilme().getNomeFilme())) {
                if (doacaolist.getEntidade().getNome().equals(doacaolist.getEntidade().getNome())) {
                   doacoes.remove(doacaolist);
                   doacoes.add(doacao);
                }
            }

        }   
    }

    public DoacaoFilmes consultar(DoacaoFilmes doacao) {
        return null;
    }

    public List<DoacaoFilmes> listar() {
        return doacoes;
    }

}
