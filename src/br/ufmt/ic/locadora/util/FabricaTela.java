/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.util;

import br.ufmt.ic.locadora.dao.*;
import br.ufmt.ic.locadora.entidade.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author brunosette
 */
public abstract class FabricaTela extends javax.swing.JPanel {

    DoacaoFilmesDAO doacaofilmesDAO = FabricaDAO.CriarDoacaoFilmesDAO();
    FuncionarioDAO funcionarioDAO = FabricaDAO.CriarFuncionarioDAO();
    FornecedorDAO fornecedorDAO = FabricaDAO.CriarForncedorDAO();
    BancoDAO bancodao = FabricaDAO.CriarBancoDAO();
    FilmeDAO filmeDAO = FabricaDAO.CriarFilmeDAO();
    GeneroDAO generoDAO = FabricaDAO.CriarGeneroDAO();
    EntidadeDAO entidadeDAO = FabricaDAO.CriarEntidadeDAO();
    ExemplarDAO exemplarDAO = FabricaDAO.CriarExemplarDAO();
    TipoCargoDAO tipocargoDAO = FabricaDAO.CriarTipoCargoDAO();
    ClienteDAO clienteDAO = FabricaDAO.CriarClienteDAO();
    AmbienteDAO ambienteDAO = FabricaDAO.CriarAmbienteDAO();

    public JComboBox setComboFuncionario(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, Funcionario> funcionarios = funcionarioDAO.listar();
        Collection<Funcionario> colecao = funcionarios.values();
        for (Funcionario funcionario : colecao) {
            jComboBox.addItem(funcionario);
        }
        jComboBox.setName("Funcionario");
        return jComboBox;

    }

    public JComboBox setComboAmbiente(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, Ambiente> ambientes = ambienteDAO.listar();
        Collection<Ambiente> colecao = ambientes.values();
        for (Ambiente ambiente : colecao) {
            jComboBox.addItem(ambiente);
        }
        jComboBox.setName("Ambiente");
        return jComboBox;

    }

    public JComboBox setComboFornecedor(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, Fornecedor> fornecedores = fornecedorDAO.listar();
        Collection<Fornecedor> colecao = fornecedores.values();
        for (Fornecedor fornecedore : colecao) {
            jComboBox.addItem(fornecedore);
        }
        jComboBox.setName("Fornecedor");
        return jComboBox;

    }

    public JComboBox setComboCliente(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");

        Map<String, Cliente> clientes = clienteDAO.listar();
        Collection<Cliente> colecao = clientes.values();
        for (Cliente cliente : colecao) {
            jComboBox.addItem(cliente);
        }
        jComboBox.setName("Cliente");
        return jComboBox;
    }

    public JComboBox setComboExemplar(JComboBox jComboBox) {
        jComboBox.removeAllItems();

        jComboBox.addItem("Selecione");

        Map<String, Exemplar> exemplares = exemplarDAO.listar();
        Collection<Exemplar> colecao = exemplares.values();
        for (Exemplar exemplar : colecao) {
            jComboBox.addItem(exemplar);
        }
        jComboBox.setName("Exemplar");
        return jComboBox;
    }

    public JComboBox setComboBanco(JComboBox jComboBox) {

        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<Banco> bancos = bancodao.listar();
        for (Iterator<Banco> it = bancos.iterator(); it.hasNext();) {
            Banco banco = it.next();
            jComboBox.addItem(banco);
        }

        jComboBox.setName("Banco");
        return jComboBox;
    }

    public JComboBox setComboFilme(JComboBox jComboBox, Genero genero) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, Filme> filmes = filmeDAO.listar();
        Collection<Filme> colecao = filmes.values();
        for (Filme filme : colecao) {
            if (filme.getExemplar().getGenero().equals(genero)) {

                jComboBox.addItem(filme);
            }
        }
        jComboBox.setName("Filme");
        return jComboBox;
    }

    public JComboBox setComboGenero(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");

        Map<String, Genero> generos = generoDAO.listar();
        Collection<Genero> colecao = generos.values();
        for (Genero genero : colecao) {
            jComboBox.addItem(genero);
        }
        jComboBox.setName("Genero");
        return jComboBox;

    }

    public JComboBox setComboEntidade(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, Entidade> entidades = entidadeDAO.listar();
        Collection<Entidade> colecao = entidades.values();
        for (Entidade entidade : colecao) {
            jComboBox.addItem(entidade);
        }
        jComboBox.setName("Entidade");
        return jComboBox;
    }

    public JComboBox setComboTipoCargo(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        Map<String, TipoCargo> tipocargos = tipocargoDAO.listar();
        Collection<TipoCargo> colecao = tipocargos.values();
        for (TipoCargo tipocargo : colecao) {
            jComboBox.addItem(tipocargo);
        }
        jComboBox.setName("Cargo");
        return jComboBox;

    }

    public JComboBox setComboTipoPonto(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        jComboBox.addItem("Entrada");
        jComboBox.addItem("Saída");
        jComboBox.setName("Tipo de Ponto");
        return jComboBox;
    }

    public boolean ValidaCombo(JComboBox jComboBox) {
        if (jComboBox.getSelectedIndex() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Seleciona pelo menos um(a) " + jComboBox.getName());
            return false;
        }
    }

}
