/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.ReservaFilme;

/**
 *
 * @author bruno
 */
public interface ReservaFilmeDAO {
    public void inserir(ReservaFilme reserva) throws RegistroException;

    public void remover(String cpf);

    public void alterar(ReservaFilme reserva);

    public ReservaFilme consultar(String cpf);

    public ReservaFilme[] listar();
}
