/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.ExemplarDAO;
import br.ufmt.ic.locadora.entidade.Exemplar;
import br.ufmt.ic.locadora.entidade.Genero;
import br.ufmt.ic.locadora.util.BancoArqu;
import br.ufmt.ic.locadora.util.FabricaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brunosette
 */
public class ExemplarDAOImplArq extends GenericaDAOArquivo<Exemplar> implements ExemplarDAO {

    @Override
    public Exemplar converteParaObjeto(String[] fatiado) {
        Exemplar exemplar = new Exemplar();

        exemplar.setCodigo(Integer.parseInt(fatiado[0]));
        exemplar.setNome(fatiado[1]);

        Date data = new Date("11/11/1111");
        try {
            data = sdf.parse(fatiado[2]);
        } catch (NullPointerException | ParseException err) {

        }
        exemplar.setDatalancamento(data);
        //Arrumar
        Genero genero = (Genero) FabricaDAO.CriarGeneroDAO().consultar(Integer.parseInt(fatiado[3]));
        exemplar.setGenero(genero);
        return exemplar;
    }

    @Override
    public String getDiretorio() {
        return BancoArqu.getCaminho() + "exemplar/exemplar.bd";
    }

    @Override
    public String converteParaString(Exemplar exemplar) {
        String data = "";
        try {
            data = sdf.format(exemplar.getDatalancamento());
        } catch (NullPointerException err) {

        }

        return exemplar.getCodigo() 
                 + delimitador +exemplar.getNome()
                + delimitador + data
                + delimitador + exemplar.getGenero().getCodigo();
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

}
