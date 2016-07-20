/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author brunosette
 */
public class OperacaoEstoqueFilmes {

    private EstoqueFilmes estoque;
    private Double valorCompra;
    private Pagamento pagamento;

    public EstoqueFilmes getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueFilmes estoque) {
        this.estoque = estoque;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "OperacaoEstoqueFilmes []";
    }

}
