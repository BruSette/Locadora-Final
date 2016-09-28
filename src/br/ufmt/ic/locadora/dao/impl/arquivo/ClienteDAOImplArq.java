/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.ClienteDAO;
import br.ufmt.ic.locadora.entidade.Cliente;
import br.ufmt.ic.locadora.entidade.Endereco;
import br.ufmt.ic.locadora.util.BancoArqu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brunosette
 */
public class ClienteDAOImplArq extends GenericaDAOArquivo<Cliente> implements ClienteDAO {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Cliente converteParaObjeto(String[] fatiado) {
        Cliente cliente = new Cliente();

        System.out.println(fatiado[0]);

        try {
            cliente.setBloqueado(Boolean.getBoolean(fatiado[0]));

        } catch (NullPointerException err) {
            System.out.println("Null pointer ao converter bloqueado ou nao");
        }

        cliente.setCpf(fatiado[1]);
        cliente.setEmail(fatiado[2]);
        cliente.setNacionalidade(fatiado[3]);
        cliente.setNome(fatiado[4]);
        cliente.setRg(fatiado[5]);
        cliente.setSexo(fatiado[6]);
        cliente.setTelefone(fatiado[7]);
        cliente.setCelular(fatiado[8]);

        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[9]);
        } catch (NullPointerException | ParseException err) {

        }
        cliente.setDataNascimento(data);

        try {
            String limite = fatiado[10];
            Integer limiteint = Integer.valueOf(limite);
            cliente.setLimiteFilmes(limiteint);

        } catch (NumberFormatException err) {
            System.out.println("NumberFormatException ao converter Limite");
        }

        Endereco endereco = new Endereco();
        endereco.setBairro(fatiado[11]);
        endereco.setCep(fatiado[12]);
        endereco.setCidade(fatiado[13]);
        endereco.setComplemento(fatiado[14]);
        endereco.setEstado(fatiado[15]);
        endereco.setNumero(fatiado[16]);
        endereco.setRua(fatiado[17]);
        cliente.setEndereco(endereco);
        return cliente;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "cliente/cliente.bd";
    }

    @Override
    public String converteParaString(Cliente cliente) {
        String limite = "";
        String datanascimento = "";
        String bloqueado = "false";

        try {
            bloqueado = Boolean.toString(cliente.getBloqueado());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir bloqueado");
        }

        try {
            limite = String.valueOf(cliente.getLimiteFilmes());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Limite");
        }

        try {
            datanascimento = sdf.format(cliente.getDataNascimento());

        } catch (NullPointerException err) {

            System.out.println("Null ao inserir Data");
        }

        return Boolean.toString(cliente.getBloqueado())
                + delimitador + cliente.getCpf()
                + delimitador + cliente.getEmail()
                + delimitador + cliente.getNacionalidade()
                + delimitador + cliente.getNome()
                + delimitador + cliente.getRg()
                + delimitador + cliente.getSexo()
                + delimitador + cliente.getTelefone()
                + delimitador + cliente.getCelular()
                + delimitador + datanascimento
                + delimitador + limite
                + delimitador + cliente.getEndereco().getBairro()
                + delimitador + cliente.getEndereco().getCep()
                + delimitador + cliente.getEndereco().getCidade()
                + delimitador + cliente.getEndereco().getComplemento()
                + delimitador + cliente.getEndereco().getEstado()
                + delimitador + cliente.getEndereco().getNumero()
                + delimitador + cliente.getEndereco().getRua();

    }
}
