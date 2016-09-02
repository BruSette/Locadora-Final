/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.exception.RegistroException;
import br.ufmt.ic.locadora.util.BancoArqu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class PontoDAOImplArq implements PontoDAO {

    private static final String dir = BancoArqu.getCaminho() + "ponto/ponto.bd";
    private String delimitador = ";";

    @Override
    public void inserir(Ponto ponto) throws RegistroException {
        List<Ponto> pontos = listar();
        for (Ponto pontolist : pontos) {
            if (pontolist.getFuncionario().getCpf().equals(ponto.getFuncionario().getCpf())) {
                if (pontolist.getDataPonto().equals(ponto.getDataPonto())) {
                    if (pontolist.getTipoPonto().equals(ponto.getTipoPonto())) {
                        throw new RegistroException();
                    }
                }
            }

        }

        pontos.add(ponto);

    }

    @Override
    public void remover(Ponto ponto) {
        List<Ponto> pontos = listar();
        for (Ponto pontolist : pontos) {
            if (pontolist.getFuncionario().getCpf().equals(ponto.getFuncionario().getCpf())) {
                if (pontolist.getDataPonto().equals(ponto.getDataPonto())) {
                    if (pontolist.getTipoPonto().equals(ponto.getTipoPonto())) {
                        pontos.remove(ponto);
                    }
                }
            }

        }
        
    }

    @Override
    public void alterar(Ponto ponto, Ponto chave) throws RegistroException {
        this.remover(chave);
        try{
            this.inserir(ponto);
        }catch(RegistroException erro){
            this.inserir(chave);
            throw new RegistroException();
        }
    
    }

    @Override
    public List<Ponto> consultar(String cpf, Date dataponto, String tipoponto) {
        List<Ponto> pontos = listar();
        
        return null;
    }

    @Override
    public List<Ponto> listar() {
        List<Ponto> pontos = new ArrayList<Ponto>();
        return pontos;
    }

}
