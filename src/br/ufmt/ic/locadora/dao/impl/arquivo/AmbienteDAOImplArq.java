/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;


import br.ufmt.ic.locadora.dao.AmbienteDAO;
import br.ufmt.ic.locadora.entidade.Ambiente;
import br.ufmt.ic.locadora.util.BancoArqu;

/**
 *
 * @author bruno
 */
public class AmbienteDAOImplArq extends GenericaDAOArquivo<Ambiente> implements AmbienteDAO {

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "ambiente/ambiente.bd";
    }
    
    @Override
    public Ambiente converteParaObjeto(String[] fatiado) {
        Ambiente ambiente = new Ambiente();
        ambiente.setNome(fatiado[0]);

        return ambiente;
    }

    @Override
    public String converteParaString(Ambiente objeto) {
        return objeto.getNome();
    }

}
