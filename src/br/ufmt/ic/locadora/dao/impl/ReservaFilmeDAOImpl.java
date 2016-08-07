/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class ReservaFilmeDAOImpl implements ReservaFilmeDAO {

    private List<ReservaFilme> reservas = new ArrayList<ReservaFilme>();

    public void inserir(ReservaFilme reserva) throws RegistroException {

        for (ReservaFilme reservalist : reservas) {
            if (reservalist.getFilme().getNomeFilme().equals(reserva.getFilme().getNomeFilme())) {
                if (reservalist.getCliente().getNome().equals(reserva.getCliente().getNome())) {
                    throw new RegistroException();
                }
            }

        }   

        reservas.add(reserva);

    }

    public void remover(ReservaFilme reserva) {
        for (ReservaFilme reservalist : reservas) {
            if(reservalist.getFilme().getNomeFilme().equals(reserva.getFilme().getNomeFilme())){
                if(reservalist.getCliente().getNome().equals(reserva.getCliente().getNome())){
                    reservas.remove(reservalist);
                }
            }
        }
    }

    public void alterar(ReservaFilme reserva) throws RegistroException {
        for (ReservaFilme reservalist : reservas) {
            if(reservalist.getFilme().getNomeFilme().equals(reserva.getFilme().getNomeFilme())){
                if(reservalist.getCliente().getNome().equals(reserva.getCliente().getNome())){
                    reservas.remove(reservalist);
                    reservas.add(reserva);
                }else{
                  throw new RegistroException("Não é possivel alterar os valores chaves!");
                }
            }else{
                throw new RegistroException("Não é possivel alterar os valores chaves!");
            }
        }
    }

    public List<ReservaFilme> consultar(String nomeFilme) {
        List<ReservaFilme> consulta = new ArrayList<ReservaFilme>();
        for (ReservaFilme reservalist : reservas) {
            if(reservalist.getFilme().getNomeFilme().equals(nomeFilme)){
                consulta.add(reservalist);
            }
        }
        return consulta;
    }

    public List<ReservaFilme> listar() {
        return reservas;
    }


}
