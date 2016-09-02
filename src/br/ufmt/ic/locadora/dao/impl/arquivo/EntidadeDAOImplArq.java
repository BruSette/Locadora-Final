/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.exception.CNPJException;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        salvarArquivo(entidades);
        
    }
    
     private void salvarArquivo(Map<String, Entidade> entidades) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            Collection<Entidade> colecao = entidades.values();
            for (Entidade entidade : colecao) {
                arq.println(
                        entidade.getCnpj()
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
        salvarArquivo(entidades);
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
        
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                Entidade entidade = new Entidade();
                entidade.setCnpj(fatiado[0]);
                entidade.setEmail(fatiado[1]);
                entidade.setNome(fatiado[2]);
                entidade.setRazaoSocial(fatiado[3]);
                entidade.setTelefone(fatiado[4]);
                entidade.setCelular(fatiado[5]);
                entidade.setObs(fatiado[6]);
                
                ContaBancaria conta = new ContaBancaria();
                conta.setBanco(FabricaDAO.CriarBancoDAO().consultar(fatiado[7]));
                conta.setContaNumero(fatiado[8]);
                entidade.setConta(conta);
                
                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[9]);
                endereco.setCep(fatiado[10]);
                endereco.setCidade(fatiado[11]);
                endereco.setComplemento(fatiado[12]);
                endereco.setEstado(fatiado[13]);
                endereco.setNumero(fatiado[14]);
                endereco.setRua(fatiado[15]);
                entidade.setEndereco(endereco);
                
                entidades.put(entidade.getCnpj(), entidade);
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

        
        
        return entidades;
    }

}
