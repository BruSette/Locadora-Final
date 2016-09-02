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
        for (ReservaFilme reservalist : reservas) {
            if (reservalist.getFilme().getExemplar().getNome().equals(reserva.getFilme().getExemplar().getNome())) {
                if (reservalist.getCliente().getNome().equals(reserva.getCliente().getNome())) {
                    //REGRAS DE NEGOCIOS AQUI
                    if (reservalist.getDataReserva().equals(reserva.getDataReserva())){
                        if(reservalist.getDataDevolucao().equals(reserva.getDataDevolucao())){
                            throw new RegistroException();
                        }
                    }
                    
                }
            }

        }   

        reservas.add(reserva);

    }

    public void remover(ReservaFilme reserva) {
        List<ReservaFilme> reservas = listar();
        for (ReservaFilme reservalist : reservas) {
            if (reservalist.getFilme().getExemplar().getNome().equals(reserva.getFilme().getExemplar().getNome())) {
                if (reservalist.getCliente().getNome().equals(reserva.getCliente().getNome())) {
                    //REGRAS DE NEGOCIOS AQUI
                    if (reservalist.getDataReserva().equals(reserva.getDataReserva())){
                        if(reservalist.getDataDevolucao().equals(reserva.getDataDevolucao())){
                            reservas.remove(reserva);
                        }
                    }
                    
                }
            }
        }
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
        return reservas;
    }


}
