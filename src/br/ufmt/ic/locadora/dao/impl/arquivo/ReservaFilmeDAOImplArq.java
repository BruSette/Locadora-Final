/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
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
public class ReservaFilmeDAOImplArq implements ReservaFilmeDAO {

    private static final String dir = BancoArqu.getCaminho() + "reservafilme/reservafilme.bd";
    private String delimitador = ";";
   
    public void inserir(ReservaFilme reserva) throws RegistroException {
        List<ReservaFilme> reservas = listar();
        for (int i = reservas.size()-1; i >=0 ; i--) {
            if (reservas.get(i).getFilme().getExemplar().getNome().equals(reserva.getFilme().getExemplar().getNome())) {
                if (reservas.get(i).getCliente().getNome().equals(reserva.getCliente().getNome())) {
                    //REGRAS DE NEGOCIOS AQUI
                    if (reservas.get(i).getDataReserva().equals(reserva.getDataReserva())){
                        if(reservas.get(i).getDataDevolucao().equals(reserva.getDataDevolucao())){
                            throw new RegistroException();
                        }
                    }
                    
                }
            }

        }   

        reservas.add(reserva);
        salvarArquivo(reservas);
    }
    
     private void salvarArquivo(List<ReservaFilme> reservas) {
        try {
            PrintWriter arq = new PrintWriter(dir);
            for (ReservaFilme reserva : reservas) {
                arq.println(reserva.getCliente().getCpf()
                        + delimitador + reserva.getFilme().getExemplar().getNome()
                        + delimitador + reserva.getFuncionario().getCpf()
                        + delimitador + Double.toString(reserva.getValorCompra())
                       
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
    

    public void remover(ReservaFilme reserva) {
        List<ReservaFilme> reservas = listar();
        for (int i = reservas.size()-1; i >=0 ; i--) {
            if (reservas.get(i).getFilme().getExemplar().getNome().equals(reserva.getFilme().getExemplar().getNome())) {
                if (reservas.get(i).getCliente().getNome().equals(reserva.getCliente().getNome())) {
                    //REGRAS DE NEGOCIOS AQUI
                    if (reservas.get(i).getDataReserva().equals(reserva.getDataReserva())){
                        if(reservas.get(i).getDataDevolucao().equals(reserva.getDataDevolucao())){
                            reservas.remove(i);
                        }
                    }
                    
                }
            }
        }
        salvarArquivo(reservas);
    }

    public void alterar(ReservaFilme reserva, ReservaFilme chave) throws RegistroException {
        this.remover(chave);
        try{
            this.inserir(reserva);
        }catch(RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    }

    public List<ReservaFilme> consultar(String nomeFilme) {
        List<ReservaFilme> reservas = listar();
        List<ReservaFilme> consulta = new ArrayList<ReservaFilme>();
        for (ReservaFilme reservalist : reservas) {
            if(reservalist.getFilme().getExemplar().getNome().equals(nomeFilme)){
                consulta.add(reservalist);
            }
        }
        return consulta;
    }

    public List<ReservaFilme> listar() {
        List<ReservaFilme> reservas = new ArrayList<ReservaFilme>();
        try {
            BufferedReader arq = new BufferedReader(new FileReader(dir));
            String linha;
            linha = arq.readLine();
            while (linha != null) {
                String[] fatiado = linha.split(delimitador, -2);
                
                ReservaFilme reserva = new ReservaFilme();
                reserva.setCliente(FabricaDAO.CriarClienteDAO().consultar(fatiado[0]));
                reserva.setFilme(FabricaDAO.CriarFilmeDAO().consultar(fatiado[1]));
                reserva.setFuncionario(FabricaDAO.CriarFuncionarioDAO().consultar(fatiado[2]));
                reserva.setValorCompra(Double.parseDouble(fatiado[3]));
                
                
                reservas.add(reserva);

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

        
        
        return reservas;
    }


}
