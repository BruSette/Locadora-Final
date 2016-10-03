package br.ufmt.ic.locadora.dao.impl.postgres;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.Cliente;
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
public class ClienteDAOImplPostgres extends GenericaDAOPostgres<Cliente> implements ClienteDAO {

    @Override
    public String getInsert(Cliente objeto) {
        return "(nome, telefone,celular,email,bairro,cep,cidade,complemento,estado,numero," +
"rua ,rg ,cpf,dataNascimento,nacionalidade ,sexo , bloqueado,limitefilmes) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    @Override
    public String getUpdate(Cliente objeto) {
        return " nome = ?, telefone= ?,celular= ?,email= ?,bairro= ?,cep= ?,cidade= ?,complemento= ?"
                + ",estado= ?,numero= ?,"
                + "rua= ? ,rg= ? ,cpf= ?,dataNascimento= ?,"
                + "nacionalidade= ? ,sexo= ? , "
                + "bloqueado= ?,limitefilmes= ?"
                + " where codigo = ?;";
    }

    @Override
    public Cliente setObjeto(ResultSet resultado) {
        Cliente cliente = new Cliente();
        try {
            cliente.setCodigo(resultado.getInt("codigo"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setTelefone(resultado.getString("telefone"));
            cliente.setCelular(resultado.getString("celular"));
            cliente.setEmail(resultado.getString("email"));
            cliente.setRg(resultado.getString("rg"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setDataNascimento(new Date(resultado.getDate("dataNascimento").getTime()));
            cliente.setNacionalidade(resultado.getString("nacionalidade"));
            cliente.setSexo(resultado.getString("sexo"));
            cliente.setBloqueado(resultado.getBoolean("bloqueado"));
            cliente.setLimiteFilmes(resultado.getInt("limitefilmes"));
            Endereco endereco = new Endereco();
            endereco.setBairro(resultado.getString("bairro"));
            endereco.setCep(resultado.getString("cep"));
            endereco.setCidade(resultado.getString("cidade"));
            endereco.setComplemento(resultado.getString("complemento"));
            endereco.setEstado(resultado.getString("estado"));
            endereco.setNumero(resultado.getString("numero"));
            endereco.setRua(resultado.getString("rua"));

            cliente.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, Cliente t) {
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
            pstm.setBoolean(17, t.getBloqueado());
            pstm.setInt(18, t.getLimiteFilmes());

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, Cliente t) {
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
            pstm.setBoolean(17, t.getBloqueado());
            pstm.setInt(18, t.getLimiteFilmes());
            pstm.setInt(19, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public Cliente getObjeto() {
        Cliente cliente = new Cliente();
        return cliente;
    }

}
