/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.Map;

/**
 *
 * @author brunosette
 */
public interface TipoCargoDAO {
    public void inserir(TipoCargo tipocargo) throws RegistroException;

    public void remover(String nome);

    public void alterar(TipoCargo tipocargo, TipoCargo chave) throws RegistroException;

    public TipoCargo consultar(String nome);

    public Map<String, TipoCargo> listar();
}
