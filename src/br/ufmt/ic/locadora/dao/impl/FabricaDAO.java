/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.dao.FilmesDAO;

/**
 *
 * @author brunosette
 */
public class FabricaDAO {
    public static BancoDAO CriarBancoDAO(){
        return new BancoDAOImpl();
    }
    
    public static ClienteDAO CriarClienteDAO(){
        return new ClienteDAOImpl();
    }
    
    public static DoacaoFilmesDAO CriarDoacaoFilmesDAO(){
        return new DoacaoFilmesDAOImpl();
    }
    
    public static FilmesDAO CriarFilmesDAO(){
        return new FilmesDAOImpl();
    }
    
    public static FuncionarioDAO CriarFuncionarioDAO(){
        return new FuncionarioDAOImpl();
    }
    
    public static ReservaFilmeDAO CriarReservaFilmeDAO(){
        return new ReservaFilmeDAOImpl();
    }
    
    public static UsuarioDAO CriarUsuarioDAO(){
        return new UsuarioDAOImpl();
    }
    
}
