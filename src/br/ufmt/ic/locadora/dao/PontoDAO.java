/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;

import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brunosette
 */
public interface PontoDAO {
    public void inserir(Ponto ponto) throws RegistroException;

    public void remover(Ponto ponto);
    
    public void alterar(Ponto ponto,Ponto chave ) throws RegistroException;

    public List<Ponto> consultar(String cpf, Date dataponto, String tipoponto);

    public List<Ponto> listar();
}
