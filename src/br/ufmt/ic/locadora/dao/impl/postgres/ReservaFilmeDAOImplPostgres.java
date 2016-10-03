package br.ufmt.ic.locadora.dao.impl.postgres;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.impl.mysql.*;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOMysql;
import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.dao.generic.GenericaDAOPostgres;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
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
public class ReservaFilmeDAOImplPostgres extends GenericaDAOPostgres<ReservaFilme> implements ReservaFilmeDAO {

    @Override
    public String getInsert(ReservaFilme objeto) {
        return "(codigocliente, codigofuncionario, codigofilme, datareserva, "
                + "datadevolucao, valorcompra)"
                + "values (?,?,?,?,?,?);";
    }

    @Override
    public String getUpdate(ReservaFilme objeto) {
        return " codigocliente= ?, codigofuncionario= ?, codigofilme= ?, datareserva= ?, "
                + "datadevolucao= ?, valorcompra= ? "
                + " where codigo = ?;";
    }

    @Override
    public ReservaFilme setObjeto(ResultSet resultado) {
        ReservaFilme reserva = new ReservaFilme();
        try {
            reserva.setCodigo(resultado.getInt("codigo"));
            reserva.setCliente(FabricaDAO.CriarClienteDAO().consultar(resultado.getInt("codigocliente")));
            reserva.setFuncionario(FabricaDAO.CriarFuncionarioDAO().consultar(resultado.getInt("codigofuncionario")));
            reserva.setFilme(FabricaDAO.CriarFilmeDAO().consultar(resultado.getInt("codigofilme")));
            reserva.setDataReserva(new Date(resultado.getDate("datareserva").getTime()));
            reserva.setDataDevolucao(new Date(resultado.getDate("datadevolucao").getTime()));
            reserva.setValorCompra(resultado.getDouble("valorcompra"));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaFilmeDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reserva;

    }

    @Override
    public PreparedStatement PreparaInserir(PreparedStatement pstm, ReservaFilme t) {
        try {
            pstm.setInt(1, t.getCliente().getCodigo());
            pstm.setInt(2, t.getFuncionario().getCodigo());
            pstm.setInt(3, t.getFilme().getCodigo());
            pstm.setDate(4, new java.sql.Date(t.getDataReserva().getTime()));
            pstm.setDate(5, new java.sql.Date(t.getDataDevolucao().getTime()));
            pstm.setDouble(6, t.getValorCompra());
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaFilmeDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstm;
    }

    @Override
    public PreparedStatement PreparaUpdate(PreparedStatement pstm, ReservaFilme t) {
        try {
            pstm.setInt(1, t.getCliente().getCodigo());
            pstm.setInt(2, t.getFuncionario().getCodigo());
            pstm.setInt(3, t.getFilme().getCodigo());
            pstm.setDate(4, new java.sql.Date(t.getDataReserva().getTime()));
            pstm.setDate(5, new java.sql.Date(t.getDataDevolucao().getTime()));
            pstm.setDouble(6, t.getValorCompra());
            pstm.setInt(7, t.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ReservaFilmeDAOImplPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pstm;
    }

    @Override
    public ReservaFilme getObjeto() {
        ReservaFilme reserva = new ReservaFilme();
        return reserva;
    }
}
