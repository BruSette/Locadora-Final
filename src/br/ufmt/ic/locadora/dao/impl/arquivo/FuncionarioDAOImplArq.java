/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.util.FabricaDAO;
import br.ufmt.ic.locadora.dao.FuncionarioDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.entidade.Banco;
import br.ufmt.ic.locadora.entidade.ContaBancaria;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.entidade.Funcionario;
import br.ufmt.ic.locadora.entidade.TipoCargo;
import br.ufmt.ic.locadora.entidade.Usuario;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class FuncionarioDAOImplArq extends GenericaDAOArquivo<Funcionario> implements FuncionarioDAO {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private UsuarioDAOImplArq daousuario = FabricaDAO.CriarUsuarioDAOArq();

    @Override
    public Funcionario converteParaObjeto(String[] fatiado) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(fatiado[1]);
        funcionario.setEmail(fatiado[2]);
        funcionario.setNacionalidade(fatiado[3]);
        funcionario.setNome(fatiado[4]);
        funcionario.setRg(fatiado[5]);
        funcionario.setSexo(fatiado[6]);
        funcionario.setTelefone(fatiado[7]);
        funcionario.setCelular(fatiado[8]);

        String sdata = fatiado[9];

        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[9]);
        } catch (NullPointerException | ParseException err) {

        }

        funcionario.setDataNascimento(data);

        try {
            data = sdf.parse("11/11/1111");
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            data = sdf.parse(fatiado[10]);
        } catch (NullPointerException | ParseException err) {

        }
        funcionario.setDataAdmiss(data);

        try {
            data = sdf.parse("11/11/1111");
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            data = sdf.parse(fatiado[11]);
        } catch (NullPointerException | ParseException err) {

        }
        funcionario.setDataDemiss(data);

        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[12]);
        endereco.setCep(fatiado[13]);
        endereco.setCidade(fatiado[14]);
        endereco.setComplemento(fatiado[15]);
        endereco.setEstado(fatiado[16]);
        endereco.setNumero(fatiado[17]);
        endereco.setRua(fatiado[18]);
        funcionario.setEndereco(endereco);

        Ambiente ambiente = (Ambiente) FabricaDAO.CriarAmbienteDAO().consultar(Integer.parseInt(fatiado[19]));
        funcionario.setAmbiente(ambiente);
        TipoCargo cargo = (TipoCargo) FabricaDAO.CriarTipoCargoDAO().consultar(Integer.parseInt(fatiado[20]));
        funcionario.setCargo(cargo);
        Usuario usuario = (Usuario) FabricaDAO.CriarUsuarioDAO().consultar(Integer.parseInt(fatiado[21]));
        funcionario.setUsuario(usuario);
        ContaBancaria conta = new ContaBancaria();
        conta.setContaNumero(fatiado[22]);
        conta.setBanco((Banco) FabricaDAO.CriarBancoDAO().consultar(Integer.parseInt(fatiado[23])));
        funcionario.setConta(conta);
        return funcionario;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "funcionario/funcionario.bd";
    }

    @Override
    public String converteParaString(Funcionario funcionario) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String limite = "";
        String datanascimento = "";
        String dataadmissao = "";
        String datademissao = "";
        String bloqueado = "";

        try {
            datanascimento = sdf.format(funcionario.getDataNascimento());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        try {
            dataadmissao = sdf.format(funcionario.getDataAdmiss());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        try {
            datademissao = sdf.format(funcionario.getDataDemiss());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        return funcionario.getCodigo() 
                + delimitador +funcionario.getCpf()
                + delimitador + funcionario.getEmail()
                + delimitador + funcionario.getNacionalidade()
                + delimitador + funcionario.getNome()
                + delimitador + funcionario.getRg()
                + delimitador + funcionario.getSexo()
                + delimitador + funcionario.getTelefone()
                + delimitador + funcionario.getCelular()
                + delimitador + datanascimento
                + delimitador + dataadmissao
                + delimitador + datademissao
                + delimitador + funcionario.getEndereco().getBairro()
                + delimitador + funcionario.getEndereco().getCep()
                + delimitador + funcionario.getEndereco().getCidade()
                + delimitador + funcionario.getEndereco().getComplemento()
                + delimitador + funcionario.getEndereco().getEstado()
                + delimitador + funcionario.getEndereco().getNumero()
                + delimitador + funcionario.getEndereco().getRua()
                + delimitador + funcionario.getAmbiente().getNome()
                + delimitador + funcionario.getCargo().getNome()
                + delimitador + funcionario.getUsuario()
                + delimitador + funcionario.getConta().getContaNumero()
                + delimitador + funcionario.getConta().getBanco().getNome();
    }


    @Override
    public void inserir(Funcionario funcionario) throws RegistroException {
        super.inserir(funcionario);
        daousuario.inserir(funcionario.getUsuario());

    }

    public void remover(int codigo) {
        Funcionario funcionario = (Funcionario) new FabricaDAO().CriarFuncionarioDAO().consultar(codigo);
        daousuario.remover(funcionario.getUsuario().getCodigo());
        super.remover(codigo);
        
    }

    public void alterar(Funcionario funcionario, Funcionario chave) throws RegistroException {
        remover(chave.getCodigo());
        try {
            inserir(funcionario);
        } catch (RegistroException erro) {
            daousuario.remover(chave.getUsuario().getCodigo());
            inserir(chave);
            throw new RegistroException();
        }
    }

   
}
