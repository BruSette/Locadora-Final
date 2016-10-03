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
import br.ufmt.ic.locadora.dao.*;
import br.ufmt.ic.locadora.dao.impl.mysql.AgenciaDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.AmbienteDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.BancoDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.FornecedorDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.FuncionarioDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.TipoCargoDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.mysql.UsuarioDAOImplMysql;
import br.ufmt.ic.locadora.dao.impl.postgres.*;

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
            tipocargodao = new TipoCargoDAOImplMysql();
        }
        return tipocargodao;
    }
    
    public static GeneroDAO CriarGeneroDAO() {
        if (generodao == null) {
            generodao = new GeneroDAOImplPostgres();
        }
        return generodao;
    }
    
    public static EntidadeDAO CriarEntidadeDAO() {
        if (entidadedao == null) {
            entidadedao = new EntidadeDAOImplPostgres();
        }
        return entidadedao;
    }
    
    public static ExemplarDAO CriarExemplarDAO() {
        if (exemplardao == null) {
            exemplardao = new ExemplarDAOImplPostgres();
        }
        return exemplardao;
    }
    
     public static AmbienteDAO CriarAmbienteDAO() {
        if (ambientedao == null) {
            ambientedao = new AmbienteDAOImplMysql();
        }
        return ambientedao;
    }
    
    public static BancoDAO CriarBancoDAO() {
        if (bancodao == null) {
            bancodao = new BancoDAOImplMysql();
        }
        return bancodao;
    }
    
     public static FornecedorDAO CriarForncedorDAO() {
        if (fornecedordao == null) {
            fornecedordao = new FornecedorDAOImplMysql();
        }
        return fornecedordao;
    }
    
    public static AgenciaDAO CriarAgenciaDAO() {
        if (agenciadao == null) {
            agenciadao = new AgenciaDAOImplMysql();
        }
        return agenciadao;
    }
    
    public static PontoDAO CriarPontoDAO() {
        if (pontodao == null) {
            pontodao = new PontoDAOImplPostgres();
        }
        return pontodao;
    }

    public static ClienteDAO CriarClienteDAO() {
        if (clientedao == null){
            clientedao =new ClienteDAOImplPostgres();
        }
        return clientedao;
    }

    public static DoacaoFilmesDAO CriarDoacaoFilmesDAO() {
        if (doacaofilmesdao == null){
            doacaofilmesdao = new DoacaoFilmesDAOImplPostgres();
        }
        return doacaofilmesdao;
    }

    public static FilmeDAO CriarFilmeDAO() {
        if (filmesdao == null){
            filmesdao =  new FilmeDAOImplPostgres();
        }
        return filmesdao;
    }

    public static FuncionarioDAO CriarFuncionarioDAO() {
        if (funcionariodao == null){
            funcionariodao =  new FuncionarioDAOImplMysql();
        }
        return funcionariodao;
    }

    public static ReservaFilmeDAO CriarReservaFilmeDAO() {
        if (reservafilmedao == null){
            reservafilmedao = new ReservaFilmeDAOImplPostgres();
        }
        return reservafilmedao;
    }

    public static UsuarioDAO CriarUsuarioDAO() {
        if(usuariodao == null){
            usuariodao =  new UsuarioDAOImplMysql();
        }
        return usuariodao;
    }
    

}
