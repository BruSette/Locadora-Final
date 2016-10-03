package br.ufmt.ic.locadora.dao.impl.postgres;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.dao.UsuarioDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class FuncionarioDAOImplPostgres extends GenericaDAOPostgres<Funcionario> implements FuncionarioDAO {

    @Override
    public void inserir(Funcionario funcionario) throws RegistroException, SQLException{
        UsuarioDAO usudao = FabricaDAO.CriarUsuarioDAO();
        usudao.inserir(funcionario.getUsuario());
        super.inserir(funcionario);
    }
    
    
    @Override
    public String getInsert(Funcionario objeto) {
        return "(nome, telefone,celular,email,bairro,cep,cidade,complemento,estado,numero," +
"rua ,rg ,cpf,dataNascimento,nacionalidade,sexo,dataadmissao,datademissao," +
"codtipocargo, codambiente, codusuario) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Funcionario objeto) {
        return " nome = ?, telefone= ?,celular= ?,email= ?,bairro= ?,cep= ?,cidade= ?,complemento= ?"
                + ",estado= ?,numero= ?,"
                + "rua= ? ,rg= ? ,cpf= ?,dataNascimento= ?,"
                + "nacionalidade= ? ,sexo= ? , "
                + "dataadmissao= ?,datademissao= ?,codtipocargo= ?, codambiente= ?, codusuario= ?"
                + " where codigo = ?;";
    }

    @Override
    public Funcionario setObjeto(ResultSet resultado) {
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.setCodigo(resultado.getInt("codigo"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setCelular(resultado.getString("celular"));
            funcionario.setEmail(resultado.getString("email"));
            funcionario.setRg(resultado.getString("rg"));
            funcionario.setCpf(resultado.getString("cpf"));
            funcionario.setDataNascimento(new Date(resultado.getDate("dataNascimento").getTime()));
            funcionario.setNacionalidade(resultado.getString("nacionalidade"));
            funcionario.setSexo(resultado.getString("sexo"));
            funcionario.setDataAdmiss(new Date(resultado.getDate("dataadmissao").getTime()));
            funcionario.setDataDemiss(new Date(resultado.getDate("datademissao").getTime()));
            funcionario.setCargo(FabricaDAO.CriarTipoCargoDAO().consultar(resultado.getInt("codtipocargo")));
            funcionario.setAmbiente(FabricaDAO.CriarAmbienteDAO().consultar(resultado.getInt("codambiente")));
            funcionario.setUsuario(FabricaDAO.CriarUsuarioDAO().consultar(resultado.getInt("codusuario")));
            
            Endereco endereco = new Endereco();
            endereco.setBairro(resultado.getString("bairro"));
            endereco.setCep(resultado.getString("cep"));
            endereco.setCidade(resultado.getString("cidade"));
            endereco.setComplemento(resultado.getString("complemento"));
            endereco.setEstado(resultado.getString("estado"));
            endereco.setNumero(resultado.getString("numero"));
            endereco.setRua(resultado.getString("rua"));

            funcionario.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Funcionario t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getTelefone());
            pstm.setString(3, t.getCelular());
            pstm.setString(4, t.getEmail());
            pstm.setString(5, t.getEndereco().getBairro());
            pstm.setString(6, t.getEndereco().getCep());
            pstm.setString(7, t.getEndereco().getCidade());
            pstm.setString(8, t.getEndereco().getComplemento());
            pstm.setString(9, t.getEndereco().getEstado());
            pstm.setString(10, t.getEndereco().getNumero());
            pstm.setString(11, t.getEndereco().getRua());
            pstm.setString(12, t.getRg());
            pstm.setString(13, t.getCpf());
            pstm.setDate(14, new java.sql.Date(t.getDataNascimento().getTime()));
            pstm.setString(15, t.getNacionalidade());
            System.out.println(t.getSexo());
            pstm.setString(16, t.getSexo());
            pstm.setDate(17, new java.sql.Date(t.getDataAdmiss().getTime()));
            pstm.setDate(18, new java.sql.Date(t.getDataDemiss().getTime()));
            pstm.setInt(19, t.getCargo().getCodigo());
            pstm.setInt(20, t.getAmbiente().getCodigo());
            pstm.setInt(21, t.getUsuario().getCodigo());
            

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Funcionario t) {
        try {
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getTelefone());
            pstm.setString(3, t.getCelular());
            pstm.setString(4, t.getEmail());
            pstm.setString(5, t.getEndereco().getBairro());
            pstm.setString(6, t.getEndereco().getCep());
            pstm.setString(7, t.getEndereco().getCidade());
            pstm.setString(8, t.getEndereco().getComplemento());
            pstm.setString(9, t.getEndereco().getEstado());
            pstm.setString(10, t.getEndereco().getNumero());
            pstm.setString(11, t.getEndereco().getRua());
            pstm.setString(12, t.getRg());
            pstm.setString(13, t.getCpf());
            pstm.setDate(14, new java.sql.Date(t.getDataNascimento().getTime()));
            pstm.setString(15, t.getNacionalidade());
            pstm.setString(16, t.getSexo());
            pstm.setDate(17, new java.sql.Date(t.getDataAdmiss().getTime()));
            pstm.setDate(18, new java.sql.Date(t.getDataDemiss().getTime()));
            pstm.setInt(19, t.getCargo().getCodigo());
            pstm.setInt(20, t.getAmbiente().getCodigo());
            pstm.setInt(21, t.getUsuario().getCodigo());
            pstm.setInt(22, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Funcionario getObjeto() {
        Funcionario funcionario = new Funcionario();
        return funcionario;
    }

}
