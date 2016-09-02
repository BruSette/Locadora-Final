/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.util.FabricaDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.exception.CPFException;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.UsuarioException;
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
 * @author bruno
 */
public class FuncionarioDAOImplArq implements FuncionarioDAO {
    
    private static final String dir = BancoArqu.getCaminho() + "funcionario/funcionario.bd";
    private String delimitador = ";";
    private UsuarioDAOImplArq daousuario = FabricaDAO.CriarUsuarioDAOArq();

    public void inserir(Funcionario funcionario) throws CPFException, UsuarioException {
        Map<String, Funcionario> funcionarios = listar();
        Map<String, Usuario> usuarios = daousuario.listar();
        if (funcionarios.containsKey(funcionario.getCpf())) {
            throw new CPFException();
        }
        
        daousuario.inserir(funcionario.getUsuario());
        
        if (funcionario.getCpf().equals("   .   .   -  ")) {
            throw new CPFException("Erro no CPF");
        }

        if (funcionario.getUsuario().getUsuario().equals("") || funcionario.getUsuario().getSenha().equals("")) {
            throw new UsuarioException("Usuario ou senha invalidos!");
        }

        funcionarios.put(funcionario.getCpf(), funcionario);
        usuarios.put(funcionario.getUsuario().getUsuario(), funcionario.getUsuario());
        salvarArquivo(funcionarios);
        daousuario.salvarArquivo(usuarios);
        
        
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
        Map<String, Usuario> usuarios = daousuario.listar();
        daousuario.remover(funcionarios.get(cpf).getUsuario().getUsuario());
        funcionarios.remove(cpf);
        salvarArquivo(funcionarios);
        daousuario.salvarArquivo(usuarios);
    }

    public void alterar(Funcionario funcionario, Funcionario chave) throws CPFException,UsuarioException {
        this.remover(chave.getCpf());
        try{
            this.inserir(funcionario);
        }catch (CPFException erro){
            this.inserir(chave);
            throw new CPFException();
        }catch (UsuarioException erro){
            this.inserir(chave);
            throw new UsuarioException();
        }
    }

    public Funcionario consultar(String cpf) {
        Map<String, Funcionario> funcionarios = listar();
        Map<String, Usuario> usuarios = daousuario.listar();
        return funcionarios.get(cpf);
    }

    public Map<String, Funcionario> listar() {
        Map<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
        Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
        return funcionarios;
    }

}
