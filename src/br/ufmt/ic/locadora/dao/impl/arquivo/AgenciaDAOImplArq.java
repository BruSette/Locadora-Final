package br.ufmt.ic.locadora.dao.impl.arquivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.dao.AgenciaDAO;
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.text.SimpleDateFormat;

/**
 *
 * @author bruno
 */
public class AgenciaDAOImplArq extends GenericaDAOArquivo<Agencia> implements AgenciaDAO{

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "agencia/agencia.bd";
    }

    public String converteParaString(Agencia objeto) {
        Agencia agencia = (Agencia) objeto;
        return (agencia.getCodigo()
                + delimitador + agencia.getCodigoAgencia()
                + delimitador + agencia.getTelefone()
                + delimitador + agencia.getEndereco().getBairro()
                + delimitador + agencia.getEndereco().getCep()
                + delimitador + agencia.getEndereco().getCidade()
                + delimitador + agencia.getEndereco().getComplemento()
                + delimitador + agencia.getEndereco().getEstado()
                + delimitador + agencia.getEndereco().getNumero()
                + delimitador + agencia.getEndereco().getRua()
                + delimitador + agencia.getBanco().getCodigo()
                + delimitador + agencia.getGerente().getNome());
    }

    @Override
    public Agencia converteParaObjeto(String[] fatiado) {
        Agencia agencia = new Agencia();
        System.out.println(fatiado[0]);
        agencia.setCodigo(Integer.parseInt(fatiado[0]));
        agencia.setCodigoAgencia(fatiado[1]);
        agencia.setTelefone(fatiado[2]);
        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[3]);
        endereco.setCep(fatiado[4]);
        endereco.setCidade(fatiado[5]);
        endereco.setComplemento(fatiado[6]);
        endereco.setEstado(fatiado[7]);
        endereco.setNumero(fatiado[8]);
        endereco.setRua(fatiado[9]);
        agencia.setEndereco(endereco);
        
        //ARRUMAR DEPOIS
        Banco banco;
        banco = FabricaDAO.CriarBancoDAO().consultar(Integer.parseInt(fatiado[10]));
        agencia.setBanco(banco);
        System.out.println(agencia.getBanco().getNome());
        PessoaFisica gerente = new PessoaFisica();
        gerente.setNome(fatiado[11]);
        agencia.setGerente(gerente);
        
        return agencia;
    }

   

   
}
