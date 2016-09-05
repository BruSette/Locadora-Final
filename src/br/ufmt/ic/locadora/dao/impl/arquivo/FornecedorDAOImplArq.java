/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Fornecedor;
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
                
                arq.println(fornecedor.getCnpj()
                        + delimitador + fornecedor.getEmail()
                        + delimitador + fornecedor.getNome()
                        + delimitador + fornecedor.getRazaoSocial()
                        + delimitador + fornecedor.getTelefone()
                        + delimitador + fornecedor.getCelular()
                        + delimitador + fornecedor.getObs()
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
        Map<String, Fornecedor> fornecedores =listar();
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
        Map<String, Fornecedor> fornecedores = listar();
        return fornecedores.get(cnpj);
    }

    public Map<String, Fornecedor> listar() {
        Map<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
         try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCnpj(fatiado[0]);
                fornecedor.setEmail(fatiado[1]);
                fornecedor.setNome(fatiado[2]);
                fornecedor.setRazaoSocial(fatiado[3]);
                fornecedor.setTelefone(fatiado[4]);
                fornecedor.setCelular(fatiado[5]);
                fornecedor.setObs(fatiado[6]);
                
                ContaBancaria conta = new ContaBancaria();
                conta.setBanco(FabricaDAO.CriarBancoDAO().consultar(fatiado[7]));
                conta.setContaNumero(fatiado[8]);
                fornecedor.setConta(conta);
                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[9]);
                endereco.setCep(fatiado[10]);
                endereco.setCidade(fatiado[11]);
                endereco.setComplemento(fatiado[12]);
                endereco.setEstado(fatiado[13]);
                endereco.setNumero(fatiado[14]);
                endereco.setRua(fatiado[15]);
                fornecedor.setEndereco(endereco);
                
                fornecedores.put(fornecedor.getCnpj(), fornecedor);
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
        
        return fornecedores;
    }

}
