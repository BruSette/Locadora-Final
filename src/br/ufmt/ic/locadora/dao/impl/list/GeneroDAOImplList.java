/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.list;

import br.ufmt.ic.locadora.dao.impl.*;
import br.ufmt.ic.locadora.dao.GeneroDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class GeneroDAOImplList implements GeneroDAO {
    private Map<String, Genero> generos = new HashMap<String, Genero>();

    public void inserir(Genero genero) throws RegistroException {

        if (generos.containsKey(genero.getNome())) {
            throw new RegistroException();
        }
        generos.put(genero.getNome(), genero);

    }

    public void remover(String nome) {
        generos.remove(nome);
    }

    public void alterar(Genero genero, Genero chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(genero);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public Genero consultar(String nome) {
        return generos.get(nome);
    }

    public Map<String, Genero> listar() {
        return generos;
    }
    
    
}
