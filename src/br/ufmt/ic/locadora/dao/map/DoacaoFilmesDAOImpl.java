/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.map;

import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmesDAOImpl implements DoacaoFilmesDAO {

    private Set<DoacaoFilmes> doacoes = new HashSet<DoacaoFilmes>();

    public void inserir(DoacaoFilmes doacao) throws RegistroException {

        if (doacoes.contains(doacao)) {
            throw new RegistroException();
        }

        if (doacao.getFilmes().getNomeFilme().equals("")) {
            throw new RegistroException("Filme Inválido");
        }

        doacoes.add(doacao);

    }

    public void remover(DoacaoFilmes doacao) {
        doacoes.remove(doacao);
    }

    public void alterar(DoacaoFilmes doacao) {
        doacoes.remove(doacao);
        doacoes.add(doacao);
    }

    public DoacaoFilmes consultar(DoacaoFilmes doacao) {
        return null;
    }

    public Set<DoacaoFilmes> listar() {
        return doacoes;
    }

}
