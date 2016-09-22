/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.locadora.dao.impl.arquivo;

import br.ufmt.ic.locadora.dao.GenericaDAO;
import br.ufmt.ic.locadora.entidade.Generica;
import br.ufmt.ic.locadora.exception.RegistroException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericaDAOArquivo<T extends Generica> implements GenericaDAO<T> {

    protected int codigo = 0;
    protected final String delimitador = ";";

    @Override
    public void inserir(Generica generica) throws RegistroException {
        List<Generica> lista = listar();
        for (Generica elemento : lista) {
            if (generica.getCodigo() == elemento.getCodigo()) {
                throw new RegistroException();
            }
        }
        for (Generica elemento : lista) {
            if (codigo < elemento.getCodigo()) {
                codigo = elemento.getCodigo();
            }
        }
        codigo++;
        generica.setCodigo(codigo);
        lista.add(generica);
        salvarArquivo(lista);
        System.out.println("Inserido com Sucesso!");
    }

    @Override
    public void remover(int codigo) {
        List<Generica> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Generica generica = lista.get(i);
            if(generica.getCodigo() == codigo){
                lista.remove(i);
            }
        }
        salvarArquivo(lista);
    }

    @Override
    public void alterar(Generica generica) {
        List<Generica> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Generica elemento = lista.get(i);
            if(elemento.getCodigo() == generica.getCodigo()){
                lista.set(i,generica);
            }
        }
        salvarArquivo(lista);
    }

    @Override
    public Generica consultar(int codigo) {
        List<Generica> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Generica generica = lista.get(i);
            if(generica.getCodigo() == codigo){
                return generica;
            }
        }
        return null;
    }

    @Override
    public List<Generica> listar() {
        List lista = new ArrayList();
        try {
            BufferedReader arq =
                    new BufferedReader(new FileReader(getDiretorio()));
            String linha = arq.readLine();
            while(linha != null){
                String[] fatiado = linha.split(delimitador);
                Generica generica = converteParaObjeto(fatiado);
                lista.add(generica);
                linha = arq.readLine();
            }
            arq.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado!");
        } catch (IOException ex) {
            Logger.getLogger(GenericaDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public abstract Generica converteParaObjeto(String[] fatiado);

    private void salvarArquivo(List<Generica> lista) {
        try {
            PrintWriter arq = new PrintWriter(getDiretorio());
            for (Generica generica : lista) {
                arq.println(converteParaString(generica));
            }
            arq.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Inexistente!");
        }
    }

    public abstract String getDiretorio();
    
    public abstract String converteParaString(Generica objeto);
    
}
