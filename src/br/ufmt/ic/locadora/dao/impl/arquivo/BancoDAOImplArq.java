/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class BancoDAOImplArq implements BancoDAO {

    private static final String dir = BancoArqu.getCaminho() + "banco/banco.bd";
    private String delimitador = ";";

    public void inserir(Banco banco) throws RegistroException {
        List<Banco> bancos = listar();
        for (int i = bancos.size()-1; i >=0 ; i--) {
            if (bancos.get(i).getNome().equals(banco.getNome())) {
                throw new RegistroException();
            }
        }
        bancos.add(banco);
        salvarArquivo(bancos);

    }

    public void remover(Banco banco) {
        List<Banco> bancos = listar();
        for (int i = bancos.size()-1; i >=0 ; i--) {
            if (bancos.get(i).getNome().equals(banco.getNome())) {
                bancos.remove(i);
            }
        }
        salvarArquivo(bancos);

    }

    public void alterar(Banco banco, Banco chave) throws RegistroException {
        try {
            remover(chave);
            inserir(banco);
        } catch (RegistroException erro) {
            inserir(chave);
            throw new RegistroException();
        }
    }

    public Banco consultar(String nome) {
        List<Banco> bancoconsultas = listar();
        for (Banco banco : bancoconsultas) {
            if (banco.getNome().equals(nome)) {
                return banco;
            }
        }
        return null;
    }

    private void salvarArquivo(List<Banco> bancos) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            for (Banco banco : bancos) {
                arq.println(banco.getCod()
                        + delimitador + banco.getNome());
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

    public List<Banco> listar() {
        List<Banco> bancos = new ArrayList<Banco>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                Banco banco = new Banco();
                banco.setCod(fatiado[0]);
                banco.setNome(fatiado[1]);

                bancos.add(banco);
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

        return bancos;
    }

}
