/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.entidade.Filme;
import br.ufmt.ic.locadora.dao.FilmeDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;

/**
 *
 * @author bruno
 */
public class FilmeDAOImplArq extends GenericaDAOArquivo<Filme> implements FilmeDAO {

    @Override
    public Filme converteParaObjeto(String[] fatiado) {
        Filme filme = new Filme();
        filme.setCodigo(Integer.parseInt(fatiado[0]));
        Exemplar exemplar = (Exemplar) FabricaDAO.CriarExemplarDAO().consultar(Integer.parseInt(fatiado[1]));
        filme.setExemplar(exemplar);
        Fornecedor fornecedor = (Fornecedor) FabricaDAO.CriarForncedorDAO().consultar(Integer.parseInt(fatiado[2]));
        System.out.println(fornecedor.getNome());
        filme.setFornecedor(fornecedor);
        Funcionario funcionario = (Funcionario) FabricaDAO.CriarFuncionarioDAO().consultar(Integer.parseInt(fatiado[3]));
        filme.setFuncionario(funcionario);
        filme.setQuantidade(Integer.parseInt(fatiado[4]));
        return filme;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "filme/filme.bd";
    }

    @Override
    public String converteParaString(Filme filme) {
        return filme.getCodigo() 
                + delimitador +filme.getExemplar().getCodigo()
                + delimitador + filme.getFornecedor().getCodigo()
                + delimitador + filme.getFuncionario().getCodigo()
                + delimitador + String.valueOf(filme.getQuantidade());
    }

}
