/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl;

import br.ufmt.ic.locadora.dao.PontoDAO;
import br.ufmt.ic.locadora.entidade.Ponto;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brunosette
 */
public class PontoDAOImpl implements PontoDAO {

    private List<Ponto> pontos = new ArrayList<Ponto>();

    @Override
    public void inserir(Ponto ponto) throws RegistroException {
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
        List<Ponto> consulta = new ArrayList<Ponto>();
        for (Ponto pontolist : pontos) {
            if(pontolist.getFuncionario().getCpf().equals(cpf)){
                consulta.add(pontolist);
            }
        }
        return consulta;
    }

    @Override
    public List<Ponto> listar() {
        return pontos;
    }

}
