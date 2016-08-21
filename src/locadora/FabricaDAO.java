/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.dao.DoacaoFilmesDAO;
import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.dao.FilmesDAO;
import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.dao.BancoDAO;
import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.dao.TipoCargoDAO;
import br.ufmt.ic.locadora.dao.impl.AgenciaDAOImpl;
import br.ufmt.ic.locadora.dao.impl.AmbienteDAOImpl;
import br.ufmt.ic.locadora.dao.impl.BancoDAOImpl;
import br.ufmt.ic.locadora.dao.impl.ClienteDAOImpl;
import br.ufmt.ic.locadora.dao.impl.DoacaoFilmesDAOImpl;
import br.ufmt.ic.locadora.dao.impl.ExemplarDAOImpl;
import br.ufmt.ic.locadora.dao.impl.FilmesDAOImpl;
import br.ufmt.ic.locadora.dao.impl.FornecedorDAOImpl;
import br.ufmt.ic.locadora.dao.impl.FuncionarioDAOImpl;
import br.ufmt.ic.locadora.dao.impl.PontoDAOImpl;
import br.ufmt.ic.locadora.dao.impl.ReservaFilmeDAOImpl;
import br.ufmt.ic.locadora.dao.impl.TipoCargoDAOImpl;
import br.ufmt.ic.locadora.dao.impl.UsuarioDAOImpl;

/**
 *
 * @author brunosette
 */
public class FabricaDAO {

    private static AgenciaDAO agenciadao;
    private static ClienteDAO clientedao;
    private static DoacaoFilmesDAO doacaofilmesdao;
    private static FilmesDAO filmesdao;
    private static FuncionarioDAO funcionariodao;
    private static ReservaFilmeDAO reservafilmedao;
    private static UsuarioDAO usuariodao;
    private static PontoDAO pontodao;
    private static BancoDAO bancodao;
    private static TipoCargoDAO tipocargodao;
    private static ExemplarDAO exemplardao;
    private static AmbienteDAO ambientedao;
    private static FornecedorDAO fornecedordao;

    
    public static TipoCargoDAO CriarTipoCargoDAO() {
        if (tipocargodao == null) {
            tipocargodao = new TipoCargoDAOImpl();
        }
        return tipocargodao;
    }
    
    public static ExemplarDAO CriarExemplarDAO() {
        if (exemplardao == null) {
            exemplardao = new ExemplarDAOImpl();
        }
        return exemplardao;
    }
    
     public static AmbienteDAO CriarAmbienteDAO() {
        if (ambientedao == null) {
            ambientedao = new AmbienteDAOImpl();
        }
        return ambientedao;
    }
    
    public static BancoDAO CriarBancoDAO() {
        if (bancodao == null) {
            bancodao = new BancoDAOImpl();
        }
        return bancodao;
    }
    
     public static FornecedorDAO CriarForncedorDAO() {
        if (fornecedordao == null) {
            fornecedordao = new FornecedorDAOImpl();
        }
        return fornecedordao;
    }
    
    public static AgenciaDAO CriarAgenciaDAO() {
        if (agenciadao == null) {
            agenciadao = new AgenciaDAOImpl();
        }
        return agenciadao;
    }
    
    public static PontoDAO CriarPontoDAO() {
        if (pontodao == null) {
            pontodao = new PontoDAOImpl();
        }
        return pontodao;
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
