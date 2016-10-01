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
        fornecedor.setCodigo(Integer.parseInt(fatiado[0]));
        fornecedor.setCnpj(fatiado[1]);
        fornecedor.setEmail(fatiado[2]);
        fornecedor.setNome(fatiado[3]);
        fornecedor.setRazaoSocial(fatiado[4]);
        fornecedor.setTelefone(fatiado[5]);
        fornecedor.setCelular(fatiado[6]);
        fornecedor.setObs(fatiado[7]);

        ContaBancaria conta = new ContaBancaria();
        conta.setBanco((Banco) FabricaDAO.CriarBancoDAO().consultar(Integer.parseInt(fatiado[8])));
        conta.setContaNumero(fatiado[9]);
        fornecedor.setConta(conta);
        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[10]);
        endereco.setCep(fatiado[11]);
        endereco.setCidade(fatiado[12]);
        endereco.setComplemento(fatiado[13]);
        endereco.setEstado(fatiado[14]);
        endereco.setNumero(fatiado[15]);
        endereco.setRua(fatiado[16]);
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

        return fornecedor.getCodigo() 
                + delimitador +fornecedor.getCnpj()
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
