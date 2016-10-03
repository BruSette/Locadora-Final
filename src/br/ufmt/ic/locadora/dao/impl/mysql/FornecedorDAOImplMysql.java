package br.ufmt.ic.locadora.dao.impl.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.postgres.*;
import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Endereco;
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
public class FornecedorDAOImplMysql extends GenericaDAOMysql<Fornecedor> implements FornecedorDAO {

    @Override
    public String getInsert(Fornecedor objeto) {
        return "(nome, telefone,celular,email,bairro,cep,cidade,complemento,estado,numero," +
"rua,cnpj,razao, codigobanco, contanumero, datacadastro) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Fornecedor objeto) {
        return " nome = ?, telefone= ?,celular= ?,email= ?,bairro= ?,cep= ?,cidade= ?,complemento= ?"
                + ",estado= ?,numero= ?,"
                + "rua= ? cnpj= ?,razao= ?, codigobanco= ?, contanumero= ?,datacadastro=?"
                + " where codigo = ?;";
    }

    @Override
    public Fornecedor setObjeto(ResultSet resultado) {
        Fornecedor fornecedor = new Fornecedor();
        try {
            fornecedor.setCodigo(resultado.getInt("codigo"));
            fornecedor.setNome(resultado.getString("nome"));
            fornecedor.setTelefone(resultado.getString("telefone"));
            fornecedor.setCelular(resultado.getString("celular"));
            fornecedor.setEmail(resultado.getString("email"));
            fornecedor.setCnpj(resultado.getString("cnpj"));
            fornecedor.setRazaoSocial(resultado.getString("razao"));
            fornecedor.setDatacadastro(new Date(resultado.getDate("datacadastro").getTime()));
            
            ContaBancaria conta = new ContaBancaria();
            conta.setBanco(FabricaDAO.CriarBancoDAO().consultar(resultado.getInt("codigobanco")));
            conta.setContaNumero(resultado.getString("contanumero"));
            
            fornecedor.setConta(conta);
            
            Endereco endereco = new Endereco();
            endereco.setBairro(resultado.getString("bairro"));
            endereco.setCep(resultado.getString("cep"));
            endereco.setCidade(resultado.getString("cidade"));
            endereco.setComplemento(resultado.getString("complemento"));
            endereco.setEstado(resultado.getString("estado"));
            endereco.setNumero(resultado.getString("numero"));
            endereco.setRua(resultado.getString("rua"));

            fornecedor.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Fornecedor t) {
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
            pstm.setDate(16, new java.sql.Date(t.getDatacadastro().getTime()));

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Fornecedor t) {
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
            pstm.setDate(16, new java.sql.Date(t.getDatacadastro().getTime()));
            pstm.setInt(17, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAOImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Fornecedor getObjeto() {
        Fornecedor fornecedor = new Fornecedor();
        return fornecedor;
    }

}
