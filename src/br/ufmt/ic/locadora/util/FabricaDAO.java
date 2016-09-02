/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.util;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.dao.impl.list.*;
import br.ufmt.ic.locadora.dao.impl.arquivo.*;
import br.ufmt.ic.locadora.dao.*;

/**
 *
 * @author brunosette
 */
public class FabricaDAO {

    private static AgenciaDAO agenciadao;
    private static ClienteDAO clientedao;
    private static DoacaoFilmesDAO doacaofilmesdao;
    private static FilmeDAO filmesdao;
    private static FuncionarioDAO funcionariodao;
    private static ReservaFilmeDAO reservafilmedao;
    private static UsuarioDAO usuariodao;
    private static UsuarioDAOImplArq usuariodaoarq;
    private static PontoDAO pontodao;
    private static BancoDAO bancodao;
    private static TipoCargoDAO tipocargodao;
    private static ExemplarDAO exemplardao;
    private static AmbienteDAO ambientedao;
    private static FornecedorDAO fornecedordao;
    private static EntidadeDAO entidadedao;
    private static GeneroDAO generodao;

    
    public static TipoCargoDAO CriarTipoCargoDAO() {
        if (tipocargodao == null) {
            tipocargodao = new TipoCargoDAOImplList();
        }
        return tipocargodao;
    }
    
    public static GeneroDAO CriarGeneroDAO() {
        if (generodao == null) {
            generodao = new GeneroDAOImplArq();
        }
        return generodao;
    }
    
    public static EntidadeDAO CriarEntidadeDAO() {
        if (entidadedao == null) {
            entidadedao = new EntidadeDAOImplArq();
        }
        return entidadedao;
    }
    
    public static ExemplarDAO CriarExemplarDAO() {
        if (exemplardao == null) {
            exemplardao = new ExemplarDAOImplArq();
        }
        return exemplardao;
    }
    
     public static AmbienteDAO CriarAmbienteDAO() {
        if (ambientedao == null) {
            ambientedao = new AmbienteDAOImplArq();
        }
        return ambientedao;
    }
    
    public static BancoDAO CriarBancoDAO() {
        if (bancodao == null) {
            bancodao = new BancoDAOImplArq();
        }
        return bancodao;
    }
    
     public static FornecedorDAO CriarForncedorDAO() {
        if (fornecedordao == null) {
            fornecedordao = new FornecedorDAOImplArq();
        }
        return fornecedordao;
    }
    
    public static AgenciaDAO CriarAgenciaDAO() {
        if (agenciadao == null) {
            agenciadao = new AgenciaDAOImplArq();
        }
        return agenciadao;
    }
    
    public static PontoDAO CriarPontoDAO() {
        if (pontodao == null) {
            pontodao = new PontoDAOImplArq();
        }
        return pontodao;
    }

    public static ClienteDAO CriarClienteDAO() {
        if (clientedao == null){
            clientedao =new ClienteDAOImplArq();
        }
        return clientedao;
    }

    public static DoacaoFilmesDAO CriarDoacaoFilmesDAO() {
        if (doacaofilmesdao == null){
            doacaofilmesdao = new DoacaoFilmesDAOImplArq();
        }
        return doacaofilmesdao;
    }

    public static FilmeDAO CriarFilmeDAO() {
        if (filmesdao == null){
            filmesdao =  new FilmeDAOImplArq();
        }
        return filmesdao;
    }

    public static FuncionarioDAO CriarFuncionarioDAO() {
        if (funcionariodao == null){
            funcionariodao =  new FuncionarioDAOImplArq();
        }
        return funcionariodao;
    }

    public static ReservaFilmeDAO CriarReservaFilmeDAO() {
        if (reservafilmedao == null){
            reservafilmedao = new ReservaFilmeDAOImplArq();
        }
        return reservafilmedao;
    }

    public static UsuarioDAO CriarUsuarioDAO() {
        if(usuariodao == null){
            usuariodao =  new UsuarioDAOImplList();
        }
        return usuariodao;
    }
    
    public static UsuarioDAOImplArq CriarUsuarioDAOArq() {
        if(usuariodaoarq == null){
            usuariodaoarq =  new UsuarioDAOImplArq();
        }
        return usuariodaoarq;
    }

}
