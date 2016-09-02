/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.exception.CNPJException;
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
public class EntidadeDAOImplArq implements EntidadeDAO {
    private static final String dir = BancoArqu.getCaminho() + "entidade/entidade.bd";
    private String delimitador = ";";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void inserir(Entidade entidade) throws CNPJException {
        Map<String, Entidade> entidades = listar();
        if (entidades.containsKey(entidade.getCnpj())) {
            throw new CNPJException();
        }
        
        if (entidade.getCnpj().equals("  .   .   /    -  ")) {
            throw new CNPJException("Erro no CNPJ");
        }

        entidades.put(entidade.getCnpj(), entidade);
        
        
    }
    
     private void salvarArquivo(Map<String, Entidade> entidades) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            Collection<Entidade> colecao = entidades.values();
            for (Entidade entidade : colecao) {
                arq.println(entidade.getNome()
                + delimitador + entidade.getCnpj()
                        + delimitador + entidade.getEmail()
                        + delimitador + entidade.getNome()
                        + delimitador + entidade.getRazaoSocial()
                        + delimitador + entidade.getTelefone()
                        + delimitador + entidade.getCelular()
                        + delimitador + entidade.getObs()
                        + delimitador + entidade.getConta().getBanco().getNome()
                        + delimitador + entidade.getConta().getContaNumero()
                        + delimitador + entidade.getEndereco().getBairro()
                        + delimitador + entidade.getEndereco().getCep()
                        + delimitador + entidade.getEndereco().getCidade()
                        + delimitador + entidade.getEndereco().getComplemento()
                        + delimitador + entidade.getEndereco().getEstado()
                        + delimitador + entidade.getEndereco().getNumero()
                        + delimitador + entidade.getEndereco().getRua()
                
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
    
    
    public void remover(String cpf) {
        Map<String, Entidade> entidades = listar();
        entidades.remove(cpf);
    }

    public void alterar(Entidade entidade, Entidade chave) throws CNPJException {
        Map<String, Entidade> entidades = listar();
        remover(chave.getCnpj());
        try{
            inserir(entidade);
        }catch (CNPJException erro){
            inserir(chave);
            throw new CNPJException();
        }
    }

    public Entidade consultar(String cnpj) {
        Map<String, Entidade> entidades = listar();
        return entidades.get(cnpj);
    }

    public Map<String, Entidade> listar() {
        Map<String, Entidade> entidades = new HashMap<String, Entidade>();
        return entidades;
    }

}
