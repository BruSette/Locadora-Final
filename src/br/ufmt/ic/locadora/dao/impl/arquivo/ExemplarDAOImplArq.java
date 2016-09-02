/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class ExemplarDAOImplArq implements ExemplarDAO {
    private static final String dir = BancoArqu.getCaminho() + "exemplar/exemplar.bd";
    private String delimitador = ";";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void inserir(Exemplar exemplar) throws RegistroException {
        Map<String, Exemplar> exemplares =listar();
        if (exemplares.containsKey(exemplar.getNome())) {
            throw new RegistroException();
        }
        exemplares.put(exemplar.getNome(), exemplar);
        salvarArquivo(exemplares);
    }
    private void salvarArquivo(Map<String, Exemplar> exemplares) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            
            Collection<Exemplar> colecao = exemplares.values();
            for (Exemplar exemplar : colecao) {
                
                String data = "";
                try{
                    data = sdf.format(exemplar.getDatalancamento());
                }catch (NullPointerException err){
                    
                }
                
                arq.println(exemplar.getNome()
                + delimitador + data
                        
                
                );
            }

            arq.close();

        } catch (IOException ex) {
            System.out.println("Arquivo ou diretório Inexistente!");
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException er) {
                System.out.println("Arquivo Inexistente!");
            }
        }
    }
    
    
    public void remover(String nome) {
        Map<String, Exemplar> exemplares =listar();
        exemplares.remove(nome);
        salvarArquivo(exemplares);
        
    }

    public void alterar(Exemplar exemplar, Exemplar chave) throws RegistroException {
        
        this.remover(chave.getNome());
        try{
            this.inserir(exemplar);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public Exemplar consultar(String nome) {
        Map<String, Exemplar> exemplares =listar();
        return exemplares.get(nome);
    }

    public Map<String, Exemplar> listar() {
        Map<String, Exemplar> exemplares = new HashMap<String, Exemplar>();
        return exemplares;
    }

}
