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
        List<Funcionario> funcionarios = funcionarioDAO.listar();
        for (Iterator<Funcionario> iterator = funcionarios.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Funcionario next = iterator.next();
            
        }
        jComboBox.setName("Funcionario");
        return jComboBox;
    }
    
    public JComboBox setComboAmbiente(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<Ambiente> ambientes = ambienteDAO.listar();
        for (Iterator<Ambiente> iterator = ambientes.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            
        }
        jComboBox.setName("Ambiente");
        return jComboBox;

    }

    public JComboBox setComboFornecedor(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<Fornecedor> fornecedores = fornecedorDAO.listar();
        for (Iterator<Fornecedor> iterator = fornecedores.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Fornecedor next = iterator.next();
            
        }
        jComboBox.setName("Fornecedor");
        return jComboBox;

    }

    public JComboBox setComboCliente(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");

        List<Cliente> clientes = clienteDAO.listar();
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Cliente next = iterator.next();
            
        }
        jComboBox.setName("Cliente");
        return jComboBox;
    }

    public JComboBox setComboExemplar(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<Exemplar> exemplares = exemplarDAO.listar();
        for (Iterator<Exemplar> iterator = exemplares.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Exemplar next = iterator.next();
            
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
        List<Filme> filmes = filmeDAO.listar();
        for (Iterator<Filme> it = filmes.iterator(); it.hasNext();) {
            Filme filme = it.next();
            if (filme.getExemplar().getGenero().getNome().equals(genero.getNome())) {
                jComboBox.addItem(filme);
            }
        }
        jComboBox.setName("Filme");
        return jComboBox;
    }

    public JComboBox setComboGenero(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");

        List<Genero> generos = generoDAO.listar();
        for (Iterator<Genero> iterator = generos.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Genero next = iterator.next();
            
        }
        jComboBox.setName("Genero");
        return jComboBox;

    }

    public JComboBox setComboEntidade(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<Entidade> entidades = entidadeDAO.listar();
        for (Iterator<Entidade> iterator = entidades.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            Entidade next = iterator.next();
            
        }
        jComboBox.setName("Entidade");
        return jComboBox;
    }

    public JComboBox setComboTipoCargo(JComboBox jComboBox) {
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecione");
        List<TipoCargo> tipocargos = tipocargoDAO.listar();
        for (Iterator<TipoCargo> iterator = tipocargos.iterator(); iterator.hasNext();) {
            jComboBox.addItem(iterator);
            TipoCargo next = iterator.next();
            
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
