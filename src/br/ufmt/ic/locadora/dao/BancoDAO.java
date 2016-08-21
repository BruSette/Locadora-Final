/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.List;


/**
 *
 * @author brunosette
 */
public interface BancoDAO {
    public void inserir(Banco banco) throws RegistroException;

    public int remover(Banco banco);

    public void alterar(Banco banco,Banco chave) throws RegistroException;

    public Banco consultar(String nome);

    public List<Banco> listar();
}


