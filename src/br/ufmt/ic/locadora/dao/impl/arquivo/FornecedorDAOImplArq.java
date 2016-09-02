/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.entidade.Fornecedor;
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
public class FornecedorDAOImplArq implements FornecedorDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "fornecedor/fornecedor.bd";
    private String delimitador = ";";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public void inserir(Fornecedor fornecedor) throws CNPJException {
        Map<String, Fornecedor> fornecedores = listar();
        if (fornecedores.containsKey(fornecedor.getCnpj())) {
            throw new CNPJException();
        }
        
        
        if (fornecedor.getCnpj().equals("  .   .   /    -  ")) {
            throw new CNPJException("Erro no CNPJ");
        }

        fornecedores.put(fornecedor.getCnpj(), fornecedor);
        salvarArquivo(fornecedores);
        
    }
    
    private void salvarArquivo(Map<String, Fornecedor> entidades) {
        try {
            PrintWriter arq = new PrintWriter(dir);

            Collection<Fornecedor> colecao = entidades.values();
            for (Fornecedor fornecedor : colecao) {
                
                String data = "";
                try{
                    data = sdf.format(fornecedor.getDatacadastro());
                }catch (NullPointerException err){
                    
                }
                
                arq.println(fornecedor.getNome()
                + delimitador + fornecedor.getCnpj()
                        + delimitador + fornecedor.getEmail()
                        + delimitador + fornecedor.getNome()
                        + delimitador + fornecedor.getRazaoSocial()
                        + delimitador + fornecedor.getTelefone()
                        + delimitador + fornecedor.getCelular()
                        + delimitador + fornecedor.getObs()
                        + delimitador + data
                        + delimitador + fornecedor.getConta().getBanco().getNome()
                        + delimitador + fornecedor.getConta().getContaNumero()
                        + delimitador + fornecedor.getEndereco().getBairro()
                        + delimitador + fornecedor.getEndereco().getCep()
                        + delimitador + fornecedor.getEndereco().getCidade()
                        + delimitador + fornecedor.getEndereco().getComplemento()
                        + delimitador + fornecedor.getEndereco().getEstado()
                        + delimitador + fornecedor.getEndereco().getNumero()
                        + delimitador + fornecedor.getEndereco().getRua()
                
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
        Map<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
        fornecedores.remove(cpf);
        salvarArquivo(fornecedores);
    }

    public void alterar(Fornecedor fornecedor, Fornecedor chave) throws CNPJException {
        this.remover(chave.getCnpj());
        try{
            this.inserir(fornecedor);
        }catch (CNPJException erro){
            this.inserir(chave);
            throw new CNPJException();
        }
    }

    public Fornecedor consultar(String cnpj) {
        Map<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
        return fornecedores.get(cnpj);
    }

    public Map<String, Fornecedor> listar() {
        Map<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
        return fornecedores;
    }

}
