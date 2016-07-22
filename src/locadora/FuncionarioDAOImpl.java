/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author bruno
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    
    private Funcionario[] funcionarios = new Funcionario[10];

    public void inserir(Funcionario funcionario) throws CPFException,UsuarioException {
        boolean achou = false;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null) {
                if (funcionarios[i].getCpf().equals(funcionario.getCpf())) {
                    throw new CPFException();
                }
                
                if(funcionarios[i].getUsuario().getUsuario().equals(funcionario.getUsuario().getUsuario())){
                    throw new UsuarioException();
                }
            }
        }
        if (!achou) {
            for (int i = 0; i < funcionarios.length; i++) {
                if (funcionarios[i] == null) {
                    funcionarios[i] = funcionario;
                    System.out.println("Inserido com Sucesso!");
                    break;
                }
            }
        }
    }

    public void remover(String cpf) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null) {
                if (funcionarios[i].getCpf().equals(cpf)) {
                    funcionarios[i] = null;
                    break;
                }
            }
        }
    }

    public void alterar(Funcionario funcionario) {

    }

    public Funcionario consultar(String cpf) {
        return null;
    }

    public Funcionario[] listar() {
        return funcionarios;
    }
    
}
