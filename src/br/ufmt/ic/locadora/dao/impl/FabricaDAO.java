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

    private static BancoDAO bancodao;
    private static ClienteDAO clientedao;
    private static DoacaoFilmesDAO doacaofilmesdao;
    private static FilmesDAO filmesdao;
    private static FuncionarioDAO funcionariodao;
    private static ReservaFilmeDAO reservafilmedao;
    private static UsuarioDAO usuariodao;

    public static BancoDAO CriarBancoDAO() {
        if (bancodao == null) {
            bancodao = new BancoDAOImpl();
        }
        return bancodao;
    }

    public static ClienteDAO CriarClienteDAO() {
        if (clientedao == null){
            clientedao =new ClienteDAOImpl();
        }
        return clientedao;
    }

    public static DoacaoFilmesDAO CriarDoacaoFilmesDAO() {
        if (doacaofilmesdao == null){
            doacaofilmesdao = new DoacaoFilmesDAOImpl();
        }
        return doacaofilmesdao;
    }

    public static FilmesDAO CriarFilmesDAO() {
        if (filmesdao == null){
            filmesdao =  new FilmesDAOImpl();
        }
        return filmesdao;
    }

    public static FuncionarioDAO CriarFuncionarioDAO() {
        if (funcionariodao == null){
            funcionariodao =  new FuncionarioDAOImpl();
        }
        return funcionariodao;
    }

    public static ReservaFilmeDAO CriarReservaFilmeDAO() {
        if (reservafilmedao == null){
            reservafilmedao = new ReservaFilmeDAOImpl();
        }
        return reservafilmedao;
    }

    public static UsuarioDAO CriarUsuarioDAO() {
        if(usuariodao == null){
            usuariodao =  new UsuarioDAOImpl();
        }
        return usuariodao;
    }

}
