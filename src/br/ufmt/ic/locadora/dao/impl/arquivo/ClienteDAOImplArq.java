/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.impl.list.*;

import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public class ClienteDAOImplArq extends ClienteDAOImplList {

    private static final String dir = BancoArqu.getCaminho() + "cliente/cliente.bd";
    private String delimitador = ";";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void inserir(Cliente cliente) throws CPFException {
        Map<String, Cliente> clientes = listar();
        if (clientes.containsKey(cliente.getCpf())) {
            throw new CPFException();
        }

        if (cliente.getCpf().equals("   .   .   -  ")) {
            throw new CPFException("Erro no CPF");
        }

        clientes.put(cliente.getCpf(), cliente);
        salvarArquivo(clientes);
    }

    public void remover(String cpf) {
        Map<String, Cliente> clientes = listar();
        clientes.remove(cpf);
        System.out.println("Removeu " + cpf);
        salvarArquivo(clientes);
    }

    public void alterar(Cliente cliente, Cliente chave) throws CPFException {
        remover(chave.getCpf());
        try {
            inserir(cliente);
        } catch (CPFException erro) {
            inserir(chave);
            throw new CPFException();
        }
    }

    public Cliente consultar(String cpf) {
        Map<String, Cliente> clientes = listar();
        return clientes.get(cpf);
    }

    private void salvarArquivo(Map<String, Cliente> clientes) {

        try {
            PrintWriter arq = new PrintWriter(dir);
            Collection<Cliente> colecao = clientes.values();
            
            for (Cliente cliente : colecao) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String limite = "";
                String datanascimento = "";
                String bloqueado = "false";

                try {
                    bloqueado = Boolean.toString(cliente.getBloqueado());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir bloqueado");
                }

                try {
                    limite = String.valueOf(cliente.getLimiteFilmes());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Limite");
                }

                try {
                    datanascimento = sdf.format(cliente.getDataNascimento());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Data");
                }

                arq.println(Boolean.toString(cliente.getBloqueado())
                        + delimitador + cliente.getCpf()
                        + delimitador + cliente.getEmail()
                        + delimitador + cliente.getNacionalidade()
                        + delimitador + cliente.getNome()
                        + delimitador + cliente.getRg()
                        + delimitador + cliente.getSexo()
                        + delimitador + cliente.getTelefone()
                        + delimitador + cliente.getCelular()
                        + delimitador + datanascimento
                        + delimitador + limite
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

                try {
                    cliente.setBloqueado(Boolean.getBoolean(fatiado[0]));

                } catch (NullPointerException err) {
                    System.out.println("Null pointer ao converter bloqueado ou nao");
                }
                

                cliente.setCpf(fatiado[1]);
                cliente.setEmail(fatiado[2]);
                cliente.setNacionalidade(fatiado[3]);
                cliente.setNome(fatiado[4]);
                cliente.setRg(fatiado[5]);
                cliente.setSexo(fatiado[6]);
                cliente.setTelefone(fatiado[7]);
                cliente.setCelular(fatiado[8]);
                
                
                
                Date data = new Date("11/11/1111");
                try{
                    data = sdf.parse(fatiado[9]);
                } catch (NullPointerException | ParseException err){
                    
                }
                cliente.setDataNascimento(data);
                
                
                try {
                    String limite = fatiado[10];
                    Integer limiteint = Integer.valueOf(limite);
                    cliente.setLimiteFilmes(limiteint);
                    
                } catch (NumberFormatException err) {
                    System.out.println("NumberFormatException ao converter Limite");
                }

                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[11]);
                endereco.setCep(fatiado[12]);
                endereco.setCidade(fatiado[13]);
                endereco.setComplemento(fatiado[14]);
                endereco.setEstado(fatiado[15]);
                endereco.setNumero(fatiado[16]);
                endereco.setRua(fatiado[17]);
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
        } catch (NullPointerException er) {
            System.out.println("Null pointer");
        }

        return clientes;
    }

}
