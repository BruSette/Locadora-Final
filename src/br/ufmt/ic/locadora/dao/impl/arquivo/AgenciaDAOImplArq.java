package br.ufmt.ic.locadora.dao.impl.arquivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ufmt.ic.locadora.entidade.Agencia;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Generica;
import br.ufmt.ic.locadora.entidade.PessoaFisica;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.text.SimpleDateFormat;

/**
 *
 * @author bruno
 */
public class AgenciaDAOImplArq extends GenericaDAOArquivo<Agencia> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "agencia/agencia.bd";
    }

    public String converteParaString(Agencia objeto) {
        Agencia agencia = (Agencia) objeto;
        return (agencia.getCodigoAgencia()
                + delimitador + agencia.getTelefone()
                + delimitador + agencia.getEndereco().getBairro()
                + delimitador + agencia.getEndereco().getCep()
                + delimitador + agencia.getEndereco().getCidade()
                + delimitador + agencia.getEndereco().getComplemento()
                + delimitador + agencia.getEndereco().getEstado()
                + delimitador + agencia.getEndereco().getNumero()
                + delimitador + agencia.getEndereco().getRua()
                + delimitador + agencia.getBanco().getCod()
                + delimitador + agencia.getBanco().getNome()
                + delimitador + agencia.getGerente().getNome());
    }

    @Override
    public Agencia converteParaObjeto(String[] fatiado) {
        Agencia agencia = new Agencia();
        agencia.setCodigoAgencia(fatiado[0]);
        agencia.setTelefone(fatiado[1]);
        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[2]);
        endereco.setCep(fatiado[3]);
        endereco.setCidade(fatiado[4]);
        endereco.setComplemento(fatiado[5]);
        endereco.setEstado(fatiado[6]);
        endereco.setNumero(fatiado[7]);
        endereco.setRua(fatiado[8]);
        agencia.setEndereco(endereco);

        //sagencia.setBanco(FabricaDAO.CriarBancoDAO().consultar(fatiado[10]));

        System.out.println(agencia.getBanco().getNome());

        PessoaFisica gerente = new PessoaFisica();
        gerente.setNome(fatiado[11]);
        agencia.setGerente(gerente);
        
        return agencia;
    }

    @Override
    public String converteParaString(Generica objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
