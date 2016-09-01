package br.ufmt.ic.locadora.dao.impl.arquivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.list.*;
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class AgenciaDAOImplArq extends AgenciaDAOImplList {

    private static final String dir = BancoArqu.getCaminho() + "agencia/agencia.bd";
    private String delimitador = ";";

   public void inserir(Agencia agencia) throws RegistroException {
        List<Agencia> agencias = listar();
        for (int i = agencias.size()-1; i >= 0; i--) {
            if (agencias.get(i).getCodigo().equals(agencia.getCodigo())) {
                throw new RegistroException();
            }
        }
        agencias.add(agencia);
        salvarArquivo(agencias);

    }

    public void remover(Agencia agencia) {
        List<Agencia> agencias = listar();
        for (int i = 0; i < agencias.size(); i++) {
            if (agencias.get(i).getCodigo().equals(agencia.getCodigo())) {
                agencias.remove(i);
                break;
            }
        }
        salvarArquivo(agencias);
        
        
        
        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigo().equals(agencia.getCodigo())) {
                agencias.remove(agencia);
                System.out.println("Removeu");
            }
        }
        salvarArquivo(agencias);

    }

    public void alterar(Agencia agencia, Agencia chave) throws RegistroException {
        try {
            this.remover(chave);
            this.inserir(agencia);
        } catch (RegistroException erro) {
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    public Agencia consultar(String codigo) {
        List<Agencia> agencias = listar();
        
        for (Agencia agencialist : agencias) {
            if (agencialist.getCodigo().equals(codigo)) {
                return agencialist;
            }
        }
        
        return null;
    }

    private void salvarArquivo(List<Agencia> agencias) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            for (Agencia agencia : agencias) {
                arq.println(agencia.getCodigo()
                        + delimitador + agencia.getTelefone()
                        + delimitador + agencia.getEndereco().getBairro()
                        + delimitador + agencia.getEndereco().getCep()
                        + delimitador + agencia.getEndereco().getCidade()
                        + delimitador + agencia.getEndereco().getComplemento()
                        + delimitador + agencia.getEndereco().getEstado()
                        + delimitador + agencia.getEndereco().getNumero()
                        + delimitador + agencia.getEndereco().getRua()
                        + delimitador + agencia.getBanco().getCod()
                        + delimitador + agencia.getBanco().getNome()
                        + delimitador + agencia.getGerente().getNome());
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

    public List<Agencia> listar() {
        List<Agencia> agencias = new ArrayList<Agencia>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);

                Agencia agencia = new Agencia();
                agencia.setCodigo(fatiado[0]);
                agencia.setTelefone(fatiado[1]);
                Endereco endereco = new Endereco();
                endereco.setBairro(fatiado[2]);
                endereco.setCep(fatiado[3]);
                endereco.setCidade(fatiado[4]);
                endereco.setComplemento(fatiado[5]);
                endereco.setEstado(fatiado[6]);
                endereco.setNumero(fatiado[7]);
                endereco.setRua(fatiado[8]);
                agencia.setEndereco(endereco);
                
                agencia.setBanco(FabricaDAO.CriarBancoDAO().consultar(fatiado[10]));
                
                System.out.println(agencia.getBanco().getNome());
                
                
                PessoaFisica gerente = new PessoaFisica();
                gerente.setNome(fatiado[11]);
                agencia.setGerente(gerente);
                
                agencias.add(agencia);

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

        return agencias;
    }

}
