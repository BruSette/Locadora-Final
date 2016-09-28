/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.ReservaFilmeDAO;
import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.entidade.ReservaFilme;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno
 */
public class ReservaFilmeDAOImplArq extends GenericaDAOArquivo<ReservaFilme> implements ReservaFilmeDAO {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ReservaFilme converteParaObjeto(String[] fatiado) {
        ReservaFilme reserva = new ReservaFilme();
        reserva.setCliente((Cliente) FabricaDAO.CriarClienteDAO().consultar(Integer.parseInt(fatiado[0])));
        reserva.setFilme((Filme) FabricaDAO.CriarFilmeDAO().consultar(Integer.parseInt(fatiado[1])));
        reserva.setFuncionario((Funcionario) FabricaDAO.CriarFuncionarioDAO().consultar(Integer.parseInt(fatiado[2])));

        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[3]);
        } catch (NullPointerException | ParseException err) {

        }
        reserva.setDataDevolucao(data);

        try {
            data = sdf.parse("11/11/1111");
            data = sdf.parse(fatiado[4]);
        } catch (NullPointerException | ParseException err) {

        }

        reserva.setDataDevolucao(data);
        return reserva;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "reservafilme/reservafilme.bd";
    }

    @Override
    public String converteParaString(ReservaFilme reserva) {
        String datadevolucao = "";
        String dataemprestimo = "";
        try {
            datadevolucao = sdf.format(reserva.getDataDevolucao());
        } catch (NullPointerException err) {

        }
        try {
            dataemprestimo = sdf.format(reserva.getDataReserva());
        } catch (NullPointerException err) {

        }
        return reserva.getCliente().getCpf()
                + delimitador + reserva.getFilme().getExemplar().getNome()
                + delimitador + reserva.getFuncionario().getCpf()
                + delimitador + datadevolucao
                + delimitador + dataemprestimo;
    }
}
