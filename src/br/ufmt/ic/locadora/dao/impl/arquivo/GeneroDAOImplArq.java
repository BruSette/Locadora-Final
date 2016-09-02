/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.GeneroDAO;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class GeneroDAOImplArq implements GeneroDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "genero/genero.bd";
    private String delimitador = ";";
    
    public void inserir(Genero genero) throws RegistroException {
        Map<String, Genero> generos = listar();
        if (generos.containsKey(genero.getNome())) {
            throw new RegistroException();
        }
        generos.put(genero.getNome(), genero);

    }

    public void remover(String nome) {
        Map<String, Genero> generos = listar();
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
        Map<String, Genero> generos = listar();
        return generos.get(nome);
    }

    public Map<String, Genero> listar() {
        Map<String, Genero> generos = new HashMap<String, Genero>();
        return generos;
    }
    
    
}
