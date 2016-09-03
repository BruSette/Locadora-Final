/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class PontoDAOImplArq implements PontoDAO {

    private static final String dir = BancoArqu.getCaminho() + "ponto/ponto.bd";
    private String delimitador = ";";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
    @Override
    public void inserir(Ponto ponto) throws RegistroException {
        List<Ponto> pontos = listar();
        for (int i = pontos.size()-1; i >=0 ; i--) {
            if (pontos.get(i).getFuncionario().getCpf().equals(ponto.getFuncionario().getCpf())) {
                if (pontos.get(i).getDataPonto().equals(ponto.getDataPonto())) {
                    if (pontos.get(i).getTipoPonto().equals(ponto.getTipoPonto())) {
                        throw new RegistroException();
                    }
                }
            }

        }

        pontos.add(ponto);
        salvarArquivo(pontos);

    }

    private void salvarArquivo(List<Ponto> pontos) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            for (Ponto ponto : pontos) {
                
                String data = "";
                try {
                    data = sdf.format(ponto.getDataPonto());

                } catch (NullPointerException err) {

                    System.out.println("Null ao inserir Data");
                }
                
                
                arq.println(ponto.getFuncionario().getCpf()
                        + delimitador + ponto.getTipoPonto()
                        + delimitador + data
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

    @Override
    public void remover(Ponto ponto) {
        List<Ponto> pontos = listar();
        for (int i = pontos.size()-1; i >=0 ; i--) {
            if (pontos.get(i).getFuncionario().getCpf().equals(ponto.getFuncionario().getCpf())) {
                if (pontos.get(i).getDataPonto().equals(ponto.getDataPonto())) {
                    if (pontos.get(i).getTipoPonto().equals(ponto.getTipoPonto())) {
                        pontos.remove(i);
                    }
                }
            }

        }
        salvarArquivo(pontos);

    }

    @Override
    public void alterar(Ponto ponto, Ponto chave) throws RegistroException {
        this.remover(chave);
        try {
            this.inserir(ponto);
        } catch (RegistroException erro) {
            this.inserir(chave);
            throw new RegistroException();
        }

    }

    @Override
    public List<Ponto> consultar(String cpf, Date dataponto, String tipoponto) {
        List<Ponto> pontos = listar();
       
        return null;
    }

    @Override
    public List<Ponto> listar() {
        List<Ponto> pontos = new ArrayList<Ponto>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                Ponto ponto = new Ponto();
                
                ponto.setFuncionario(FabricaDAO.CriarFuncionarioDAO().consultar(fatiado[0]));
                ponto.setTipoPonto(fatiado[1]);
                
                Date data = new Date("11/11/1111");
                try{
                    data = sdf.parse(fatiado[2]);
                } catch (NullPointerException | ParseException err){
                    
                }
                
                ponto.setDataPonto(data);
                
                
                
                pontos.add(ponto);
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
        return pontos;
    }

}
