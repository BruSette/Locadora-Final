package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.EntidadeDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Entidade;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
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
public class EntidadeDAOImplMysql extends GenericaDAOPostgres<Entidade> implements EntidadeDAO {

    @Override
    public String getInsert(Entidade objeto) {
        return "(nome, telefone,celular,email,bairro,cep,cidade,complemento,estado,numero," +
"rua,cnpj,razao, codigobanco, contanumero) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Entidade objeto) {
        return " nome = ?, telefone= ?,celular= ?,email= ?,bairro= ?,cep= ?,cidade= ?,complemento= ?"
                + ",estado= ?,numero= ?,"
                + "rua= ? cnpj= ?,razao= ?, codigobanco= ?, contanumero= ?"
                + " where codigo = ?;";
    }

    @Override
    public Entidade setObjeto(ResultSet resultado) {
        Entidade entidade = new Entidade();
        try {
            entidade.setCodigo(resultado.getInt("codigo"));
            entidade.setNome(resultado.getString("nome"));
            entidade.setTelefone(resultado.getString("telefone"));
            entidade.setCelular(resultado.getString("celular"));
            entidade.setEmail(resultado.getString("email"));
            entidade.setCnpj(resultado.getString("cnpj"));
            entidade.setRazaoSocial(resultado.getString("razao"));
            
            ContaBancaria conta = new ContaBancaria();
            conta.setBanco(FabricaDAO.CriarBancoDAO().consultar(resultado.getInt("codigobanco")));
            conta.setContaNumero(resultado.getString("contanumero"));
            
            entidade.setConta(conta);
            
            Endereco endereco = new Endereco();
            endereco.setBairro(resultado.getString("bairro"));
            endereco.setCep(resultado.getString("cep"));
            endereco.setCidade(resultado.getString("cidade"));
            endereco.setComplemento(resultado.getString("complemento"));
            endereco.setEstado(resultado.getString("estado"));
            endereco.setNumero(resultado.getString("numero"));
            endereco.setRua(resultado.getString("rua"));

            entidade.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(EntidadeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidade;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Entidade t) {
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
            pstm.setString(12, t.getCnpj());
            pstm.setString(13, t.getRazaoSocial());
            pstm.setInt(14, t.getConta().getBanco().getCodigo() );
            pstm.setString(15, t.getConta().getContaNumero());

        } catch (SQLException ex) {
            Logger.getLogger(EntidadeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Entidade t) {
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
            pstm.setString(12, t.getCnpj());
            pstm.setString(13, t.getRazaoSocial());
            pstm.setInt(14, t.getConta().getBanco().getCodigo() );
            pstm.setString(15, t.getConta().getContaNumero());

            pstm.setInt(16, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(EntidadeDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Entidade getObjeto() {
        Entidade entidade = new Entidade();
        return entidade;
    }

}
