/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import br.ufmt.ic.locadora.dao.GenericaDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class FilmeDAOImplArq extends GenericaDAOArquivo<Filme> implements FilmeDAO {

    @Override
    public Filme converteParaObjeto(String[] fatiado) {
        Filme filme = new Filme();
        Exemplar exemplar = (Exemplar) FabricaDAO.CriarExemplarDAO().consultar(Integer.parseInt(fatiado[0]));
        filme.setExemplar(exemplar);
        Fornecedor fornecedor = (Fornecedor) FabricaDAO.CriarForncedorDAO().consultar(Integer.parseInt(fatiado[1]));
        System.out.println(fornecedor.getNome());
        filme.setFornecedor(fornecedor);
        Funcionario funcionario = (Funcionario) FabricaDAO.CriarFuncionarioDAO().consultar(Integer.parseInt(fatiado[2]));
        filme.setFuncionario(funcionario);
        filme.setQuantidade(Integer.parseInt(fatiado[3]));
        return filme;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "filme/filme.bd";
    }

    @Override
    public String converteParaString(Filme filme) {
        return filme.getExemplar().getNome()
                + delimitador + filme.getFornecedor().getCnpj()
                + delimitador + filme.getFuncionario().getCpf()
                + delimitador + String.valueOf(filme.getQuantidade());
    }

}
