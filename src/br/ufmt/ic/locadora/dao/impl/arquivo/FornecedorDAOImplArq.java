/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.FornecedorDAO;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Fornecedor;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.text.SimpleDateFormat;

/**
 *
 * @author brunosette
 */
public class FornecedorDAOImplArq extends GenericaDAOArquivo<Fornecedor> implements FornecedorDAO {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Fornecedor converteParaObjeto(String[] fatiado) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(fatiado[0]);
        fornecedor.setEmail(fatiado[1]);
        fornecedor.setNome(fatiado[2]);
        fornecedor.setRazaoSocial(fatiado[3]);
        fornecedor.setTelefone(fatiado[4]);
        fornecedor.setCelular(fatiado[5]);
        fornecedor.setObs(fatiado[6]);

        ContaBancaria conta = new ContaBancaria();
        conta.setBanco((Banco) FabricaDAO.CriarBancoDAO().consultar(Integer.parseInt(fatiado[7])));
        conta.setContaNumero(fatiado[8]);
        fornecedor.setConta(conta);
        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[9]);
        endereco.setCep(fatiado[10]);
        endereco.setCidade(fatiado[11]);
        endereco.setComplemento(fatiado[12]);
        endereco.setEstado(fatiado[13]);
        endereco.setNumero(fatiado[14]);
        endereco.setRua(fatiado[15]);
        fornecedor.setEndereco(endereco);
        return fornecedor;

    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "fornecedor/fornecedor.bd";
    }

    @Override
    public String converteParaString(Fornecedor fornecedor) {

        String data = "";
        try {
            data = sdf.format(fornecedor.getDatacadastro());
        } catch (NullPointerException err) {

        }

        return fornecedor.getCnpj()
                + delimitador + fornecedor.getEmail()
                + delimitador + fornecedor.getNome()
                + delimitador + fornecedor.getRazaoSocial()
                + delimitador + fornecedor.getTelefone()
                + delimitador + fornecedor.getCelular()
                + delimitador + fornecedor.getObs()
                + delimitador + fornecedor.getConta().getBanco().getNome()
                + delimitador + fornecedor.getConta().getContaNumero()
                + delimitador + fornecedor.getEndereco().getBairro()
                + delimitador + fornecedor.getEndereco().getCep()
                + delimitador + fornecedor.getEndereco().getCidade()
                + delimitador + fornecedor.getEndereco().getComplemento()
                + delimitador + fornecedor.getEndereco().getEstado()
                + delimitador + fornecedor.getEndereco().getNumero()
                + delimitador + fornecedor.getEndereco().getRua();
    }

}
