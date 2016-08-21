/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface AmbienteDAO {
    public void inserir(Ambiente ambiente) throws RegistroException;

    public void remover(String nome);

    public void alterar(Ambiente ambiente, Ambiente chave) throws RegistroException;

    public Ambiente consultar(String nome);

    public Map<String, Ambiente> listar();
}
