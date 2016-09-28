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
    public void inserir(T t) throws RegistroException {
        List<T> lista = listar();
        for (T elemento : lista) {
            if (t.getCodigo() == elemento.getCodigo()) {
                throw new RegistroException();
            }
        }
        for (T elemento : lista) {
            if (codigo < elemento.getCodigo()) {
                codigo = elemento.getCodigo();
            }
        }
        codigo++;
        t.setCodigo(codigo);
        
        System.out.println(t.getCodigo());
        lista.add(t);
        salvarArquivo(lista);
        System.out.println("Inserido com Sucesso!");
    }

    @Override
    public void remover(int codigo) {
        List<T> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            T t = lista.get(i);
            if(t.getCodigo() == codigo){
                lista.remove(i);
            }
        }
        salvarArquivo(lista);
    }

    @Override
    public void alterar(T t) {
        List<T> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            T elemento = lista.get(i);
            if(elemento.getCodigo() == t.getCodigo()){
                lista.set(i,t);
            }
        }
        salvarArquivo(lista);
    }

    @Override
    public T consultar(int codigo) {
        List<T> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            T t = lista.get(i);
            if(t.getCodigo() == codigo){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> listar() {
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
    public abstract T converteParaObjeto(String[] fatiado);

    private void salvarArquivo(List<T> lista) {
        try {
            PrintWriter arq = new PrintWriter(getDiretorio());
            for (T generica : lista) {
                arq.println(converteParaString(generica));
            }
            arq.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Inexistente!");
        }
    }

    public abstract String getDiretorio();
    
    public abstract String converteParaString(T objeto);
    
}
