package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruno
 */
public class AgenciaDAOImplMysql extends GenericaDAOMysql<Agencia> implements AgenciaDAO {

    @Override
    public String getInsert(Agencia objeto) {
        return "(codigobanco,codigoagencia,gerente,telefone,bairro,cep,cidade,complemento,estado,numero,rua) "
                + "values (?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Agencia objeto) {
        return " (codigobanco = ?,codigoagencia= ?,gerente= ?,telefone= ?,bairro= ?,cep= ?,cidade= ?,complemento= ?,estado= ?,numero= ?,rua= ?"
                + " where codigo = ?);";
    }

    @Override
    public Agencia setObjeto(ResultSet resultado) {
        Agencia agencia = new Agencia();
        try {
            agencia.setCodigo(resultado.getInt("codigo"));
            int codBanco = resultado.getInt("codigobanco");
            agencia.setBanco(FabricaDAO.CriarBancoDAO().consultar(codBanco));
            agencia.setCodigoAgencia(resultado.getString("codigoagencia"));
            PessoaFisica gerente = new PessoaFisica();
            gerente.setNome(resultado.getString("gerente"));
            agencia.setGerente(gerente);
            agencia.setTelefone(resultado.getString("telefone"));
            Endereco endereco = new Endereco();
            endereco.setBairro(resultado.getString("bairro"));
            endereco.setCep(resultado.getString("cep"));
            endereco.setCidade(resultado.getString("cidade"));
            endereco.setComplemento(resultado.getString("complemento"));
            endereco.setEstado(resultado.getString("estado"));
            endereco.setNumero(resultado.getString("numero"));
            endereco.setRua(resultado.getString("rua"));

            agencia.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agencia;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Agencia t) {
        try {
            pstm.setInt(1, t.getBanco().getCodigo());
            pstm.setString(2, t.getCodigoAgencia());
            pstm.setString(3, t.getGerente().getNome());
            pstm.setString(4, t.getTelefone());
            pstm.setString(5, t.getEndereco().getBairro());
            pstm.setString(6, t.getEndereco().getCep());
            pstm.setString(7, t.getEndereco().getCidade());
            pstm.setString(8, t.getEndereco().getComplemento());
            pstm.setString(9, t.getEndereco().getEstado());
            pstm.setString(10, t.getEndereco().getNumero());
            pstm.setString(11, t.getEndereco().getRua());

        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Agencia t) {
        try {
            pstm.setInt(1, t.getBanco().getCodigo());
            pstm.setString(2, t.getCodigoAgencia());
            pstm.setString(3, t.getGerente().getNome());
            pstm.setString(4, t.getTelefone());
            pstm.setString(5, t.getEndereco().getBairro());
            pstm.setString(6, t.getEndereco().getCep());
            pstm.setString(7, t.getEndereco().getCidade());
            pstm.setString(8, t.getEndereco().getComplemento());
            pstm.setString(9, t.getEndereco().getEstado());
            pstm.setString(10, t.getEndereco().getNumero());
            pstm.setString(11, t.getEndereco().getRua());
            pstm.setInt(12, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Agencia getObjeto() {
        Agencia agencia = new Agencia();
        return agencia;
    }

}
