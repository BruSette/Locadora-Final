/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.TipoCargo;
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
 * @author brunosette
 */
public class TipoCargoDAOImplArq implements TipoCargoDAO {
    
   private static final String dir = BancoArqu.getCaminho() + "tipocargo/tipocargo.bd";
    private String delimitador = ";";

    public void inserir(TipoCargo tipocargo) throws RegistroException {
        Map<String, TipoCargo> tipocargos = listar();
        if (tipocargos.containsKey(tipocargo.getNome())) {
            throw new RegistroException();
        }
        tipocargos.put(tipocargo.getNome(), tipocargo);
        salvarArquivo(tipocargos);

    }
    
    private void salvarArquivo(Map<String, TipoCargo> tipocargos) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            Collection<TipoCargo> colecao = tipocargos.values();
            for (TipoCargo tipocargo : colecao) {
                arq.println(tipocargo.getNome());
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

    public void remover(String nome) {
        Map<String, TipoCargo> tipocargos = listar();
        tipocargos.remove(nome);
        salvarArquivo(tipocargos);
    }

    public void alterar(TipoCargo tipocargo, TipoCargo chave) throws RegistroException {
        this.remover(chave.getNome());
        try{
            this.inserir(tipocargo);
        }catch (RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public TipoCargo consultar(String nome) {
        Map<String, TipoCargo> tipocargos = listar();
        return tipocargos.get(nome);
    }

    public Map<String, TipoCargo> listar() {
        Map<String, TipoCargo> tipocargos = new HashMap<String, TipoCargo>();
        
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                TipoCargo cargo = new TipoCargo();
                cargo.setNome(fatiado[0]);
                
                tipocargos.put(cargo.getNome(), cargo);
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

        return tipocargos;
    }

    
}
