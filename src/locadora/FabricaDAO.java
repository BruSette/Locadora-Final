/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

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
    
    public static EstoqueFilmesDAO CriarEstoqueFilmesDAO(){
        return new EstoqueFilmesDAOImpl();
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
