/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.util.FabricaDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class FuncionarioDAOImplArq implements FuncionarioDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "funcionario/funcionario.bd";
    private String delimitador = ";";
    private UsuarioDAOImplArq daousuario = FabricaDAO.CriarUsuarioDAOArq();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void inserir(Funcionario funcionario) throws CPFException, UsuarioException {
        Map<String, Funcionario> funcionarios = listar();
        
        daousuario.inserir(funcionario.getUsuario());
        
        if (funcionarios.containsKey(funcionario.getCpf())) {
            throw new CPFException();
        }
        
        if (funcionario.getCpf().equals("   .   .   -  ")) {
            throw new CPFException("Erro no CPF");
        }

        if (funcionario.getUsuario().getUsuario().equals("") || funcionario.getUsuario().getSenha().equals("")) {
            throw new UsuarioException("Usuario ou senha invalidos!");
        }

        funcionarios.put(funcionario.getCpf(), funcionario);
        salvarArquivo(funcionarios);
        
        
        
    }
    
    private void salvarArquivo(Map<String, Funcionario> funcionarios) {

        try {
            PrintWriter arq = new PrintWriter(dir);
            Collection<Funcionario> colecao = funcionarios.values();
            for (Funcionario funcionario : colecao) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String limite = "";
                String datanascimento = "";
                String dataadmissao = "";
                String datademissao = "";
                String bloqueado = "";
                
                try {
                    datanascimento = sdf.format(funcionario.getDataNascimento());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Data");
                }
                
                try {
                    dataadmissao = sdf.format(funcionario.getDataAdmiss());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Data");
                }
                
                 try {
                    datademissao = sdf.format(funcionario.getDataDemiss());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Data");
                }

                arq.println(funcionario.getCpf()
                        + delimitador + funcionario.getEmail()
                        + delimitador + funcionario.getNacionalidade()
                        + delimitador + funcionario.getNome()
                        + delimitador + funcionario.getRg()
                        + delimitador + funcionario.getSexo()
                        + delimitador + funcionario.getTelefone()
                        + delimitador + funcionario.getCelular()
                        + delimitador + datanascimento
                        + delimitador + dataadmissao
                        + delimitador + datademissao
                        + delimitador + funcionario.getEndereco().getBairro()
                        + delimitador + funcionario.getEndereco().getCep()
                        + delimitador + funcionario.getEndereco().getCidade()
                        + delimitador + funcionario.getEndereco().getComplemento()
                        + delimitador + funcionario.getEndereco().getEstado()
                        + delimitador + funcionario.getEndereco().getNumero()
                        + delimitador + funcionario.getEndereco().getRua()
                        + delimitador + funcionario.getAmbiente().getNome()
                        + delimitador + funcionario.getCargo().getNome()
                        + delimitador + funcionario.getUsuario()
                        + delimitador + funcionario.getConta().getContaNumero()
                        + delimitador + funcionario.getConta().getBanco().getNome()
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

    public void remover(String cpf) {
        Map<String, Funcionario> funcionarios = listar();
        daousuario.remover(funcionarios.get(cpf).getUsuario().getUsuario());
        funcionarios.remove(cpf);
        salvarArquivo(funcionarios);
    }

    public void alterar(Funcionario funcionario, Funcionario chave) throws CPFException,UsuarioException {
        remover(chave.getCpf());
        try{
            this.inserir(funcionario);
        }catch (CPFException erro){
            daousuario.remover(chave.getUsuario().getUsuario());
            this.inserir(chave);
            throw new CPFException();
        }catch (UsuarioException err){
            this.inserir(chave);
            throw new UsuarioException();
        }
    }

    public Funcionario consultar(String cpf) {
        Map<String, Funcionario> funcionarios = listar();
        return funcionarios.get(cpf);
    }

    public Map<String, Funcionario> listar() {
        Map<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(fatiado[0]);
                funcionario.setEmail(fatiado[1]);
                funcionario.setNacionalidade(fatiado[2]);
                funcionario.setNome(fatiado[3]);
                funcionario.setRg(fatiado[4]);
                funcionario.setSexo(fatiado[5]);
                funcionario.setTelefone(fatiado[6]);
                funcionario.setCelular(fatiado[7]);
                
                String sdata = fatiado[8];
                
                Date data = new Date("11/11/1111");
                try{
                    data = sdf.parse(fatiado[8]);
                } catch (NullPointerException | ParseException err){
                    
                }
                
                funcionario.setDataNascimento(data);
                
                data = sdf.parse("11/11/1111");
                try{
                    data = sdf.parse(fatiado[9]);
                } catch (NullPointerException | ParseException err){
                    
                }
                funcionario.setDataAdmiss(data);
                
                
                data = sdf.parse("11/11/1111");
                try{
                    data = sdf.parse(fatiado[10]);
                } catch (NullPointerException | ParseException err){
                    
                }
                funcionario.setDataDemiss(data);
                
                
                
                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[11]);
                endereco.setCep(fatiado[12]);
                endereco.setCidade(fatiado[13]);
                endereco.setComplemento(fatiado[14]);
                endereco.setEstado(fatiado[15]);
                endereco.setNumero(fatiado[16]);
                endereco.setRua(fatiado[17]);
                funcionario.setEndereco(endereco);

                Ambiente ambiente = FabricaDAO.CriarAmbienteDAO().consultar(fatiado[18]);
                funcionario.setAmbiente(ambiente);
                TipoCargo cargo = FabricaDAO.CriarTipoCargoDAO().consultar(fatiado[19]);
                funcionario.setCargo(cargo);
                Usuario usuario = FabricaDAO.CriarUsuarioDAO().consultar(fatiado[20]);
                funcionario.setUsuario(usuario);
                ContaBancaria conta = new ContaBancaria();
                conta.setContaNumero(fatiado[21]);
                conta.setBanco(FabricaDAO.CriarBancoDAO().consultar(fatiado[22]));
                funcionario.setConta(conta);
                funcionarios.put(funcionario.getCpf(), funcionario);
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
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        return funcionarios;
    }

}
