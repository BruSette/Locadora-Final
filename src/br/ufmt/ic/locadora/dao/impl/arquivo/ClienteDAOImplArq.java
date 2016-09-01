/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.impl.list.*;
import br.ufmt.ic.locadora.entidade.Ambiente;

import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.exception.CPFException;
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
public class ClienteDAOImplArq extends ClienteDAOImplList {

    private static final String dir = BancoArqu.getCaminho() + "cliente/cliente.bd";
    private String delimitador = ";";

    @Override
    public void inserir(Cliente cliente) throws CPFException {
        super.inserir(cliente); //To change body of generated methods, choose Tools | Templates.
        salvarArquivo(super.listar());
    }

    @Override
    public void remover(String cpf) {
        super.remover(cpf); //To change body of generated methods, choose Tools | Templates.
        salvarArquivo(super.listar());
    }

    @Override
    public void alterar(Cliente cliente, Cliente chave) throws CPFException {
        super.alterar(cliente, chave); //To change body of generated methods, choose Tools | Templates.
        salvarArquivo(super.listar());
    }
     
    
    private void salvarArquivo(Map<String, Cliente> clientes) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            Collection<Cliente> colecao = clientes.values();
            for (Cliente cliente : colecao) {
                arq.println(Boolean.toString(cliente.getBloqueado())
                        + delimitador + cliente.getCpf()
                        + delimitador + cliente.getEmail()
                        + delimitador + cliente.getNacionalidade()
                        + delimitador + cliente.getNome()
                        + delimitador + cliente.getRg()
                        + delimitador + cliente.getSexo()
                        + delimitador + cliente.getTelefone()
                        + delimitador + cliente.getCelular()
                        + delimitador + Integer.toString(cliente.getLimiteFilmes())
                        + delimitador + cliente.getEndereco().getBairro()
                        + delimitador + cliente.getEndereco().getCep()
                        + delimitador + cliente.getEndereco().getCidade()
                        + delimitador + cliente.getEndereco().getComplemento()
                        + delimitador + cliente.getEndereco().getEstado()
                        + delimitador + cliente.getEndereco().getNumero()
                        + delimitador + cliente.getEndereco().getRua()
                );
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

    public Map<String, Cliente> listar() {

        Map<String, Cliente> clientes = new HashMap<String, Cliente>();
        
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            
            
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                Cliente cliente = new Cliente();
                
                
                System.out.println(fatiado[0]);
                cliente.setBloqueado(false);
                cliente.setCpf(fatiado[1]);
                cliente.setEmail(fatiado[2]);
                cliente.setNacionalidade(fatiado[3]);
                cliente.setNome(fatiado[4]);
                cliente.setRg(fatiado[5]);
                cliente.setSexo(fatiado[6]);
                cliente.setTelefone(fatiado[7]);
                cliente.setCelular(fatiado[8]);
                System.out.println(String.valueOf(fatiado[9]));
                cliente.setLimiteFilmes(4);
                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[10]);
                endereco.setCep(fatiado[11]);
                endereco.setCidade(fatiado[12]);
                endereco.setComplemento(fatiado[13]);
                endereco.setEstado(fatiado[14]);
                endereco.setNumero(fatiado[15]);
                endereco.setRua(fatiado[16]);
                cliente.setEndereco(endereco);
                
                clientes.put(cliente.getCpf(), cliente);

                linha = arq.readLine();
                
            }
            
            
            arq.close();
        } catch (FileNotFoundException erro) {
            try {
                PrintWriter arq = new PrintWriter(dir);
            } catch (FileNotFoundException ex) {
                System.out.println("Erro ao abrir o arquivo");
            }
            System.out.println("Erro ao abrir o arquivo/ Arquivo criado");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo ou ao acessar o diretório");
        } catch (NullPointerException er){
            System.out.println("Null pointer");
        }

        return clientes;
    }

}
