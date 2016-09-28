/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.entidade;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author brunosette
 */
public class ReservaFilme implements Generica {

    private Cliente cliente;
    private Funcionario funcionario;
    private Filme filme;
    private Date dataReserva;
    private Date dataDevolucao;
    private Double valorCompra;
    private PagamentoCompra pagamento;
    private int codigo;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.cliente);
        hash = 11 * hash + Objects.hashCode(this.filme);
        hash = 11 * hash + Objects.hashCode(this.dataReserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservaFilme other = (ReservaFilme) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        if (!Objects.equals(this.dataReserva, other.dataReserva)) {
            return false;
        }
        return true;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public ReservaFilme() {
        super();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filmes) {
        this.filme = filmes;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return getCliente().getNome() + " - " + getFilme().getExemplar().getNome();
    }

    public PagamentoCompra getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoCompra pagamento) {
        this.pagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
