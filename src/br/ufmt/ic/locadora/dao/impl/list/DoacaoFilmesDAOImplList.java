/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.list;

import br.ufmt.ic.locadora.dao.impl.*;
import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.entidade.DoacaoFilmes;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class DoacaoFilmesDAOImplList implements DoacaoFilmesDAO {

    private List<DoacaoFilmes> doacoes = new ArrayList<DoacaoFilmes>();

    public void inserir(DoacaoFilmes doacao) throws RegistroException {

        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacaolist.getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {
                    
                    throw new RegistroException();
                }
            }

        }

        doacoes.add(doacao);

    }

    public void remover(DoacaoFilmes doacao) {
        for (DoacaoFilmes doacaolist : doacoes) {
            if (doacaolist.getFilme().getExemplar().getNome().equals(doacao.getFilme().getExemplar().getNome())) {
                if (doacaolist.getEntidade().getCnpj().equals(doacao.getEntidade().getCnpj())) {
                    doacoes.remove(doacao);
                    return;
                }
            }

        }
    }

    public void alterar(DoacaoFilmes doacao, DoacaoFilmes chave) throws RegistroException {
        doacoes.remove(chave);
        
        try{
            this.inserir(doacao);
        }catch(RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
        

    }

    public DoacaoFilmes consultar(DoacaoFilmes doacao) {
        return null;
    }

    public List<DoacaoFilmes> listar() {
        return doacoes;
    }

}
