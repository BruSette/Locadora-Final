/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.dao.impl.list.AmbienteDAOImplList;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class AmbienteDAOImplArq implements AmbienteDAO {

    private static final String dir = BancoArqu.getCaminho() + "ambiente/ambiente.bd";
    private String delimitador = ";";

    public void inserir(Ambiente ambiente) throws RegistroException {
        Map<String, Ambiente> ambientes = listar();
        if (ambientes.containsKey(ambiente.getNome())) {
            throw new RegistroException();
        }
        ambientes.put(ambiente.getNome(), ambiente);
        salvarArquivo(ambientes);
    }

    public void remover(String nome) {
        Map<String, Ambiente> ambientes = listar();
        ambientes.remove(nome);
        salvarArquivo(ambientes);
    }

    public void alterar(Ambiente ambiente, Ambiente chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(ambiente);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public Ambiente consultar(String nome) {
        Map<String, Ambiente> ambientes = listar();
        return ambientes.get(nome);
    }
    

    private void salvarArquivo(Map<String, Ambiente> ambientes) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            Collection<Ambiente> colecao = ambientes.values();
            for (Ambiente ambiente : colecao) {
                arq.println(ambiente.getNome());
            }

            arq.close();

        } catch (IOException ex) {
            System.out.println("Arquivo ou diretório Inexistente!");
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException ex1) {
                System.out.println("Arquivo Inexistente!");
            }
        }
    }

    public Map<String, Ambiente> listar() {

        Map<String, Ambiente> ambientes = new HashMap<String, Ambiente>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                Ambiente ambiente = new Ambiente();
                ambiente.setNome(fatiado[0]);

                ambientes.put(ambiente.getNome(), ambiente);
                linha = arq.readLine();
            }
            arq.close();
        } catch (FileNotFoundException erro) {
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException ex) {
                System.out.println("Erro ao abrir o arquivo");
            }

        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo ou ao acessar o diretório");
        }

        return ambientes;
    }

}
