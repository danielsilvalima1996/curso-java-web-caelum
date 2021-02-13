package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarioId {
    
    public static void main(String[] args) {
        
        FuncionarioDao dao = new FuncionarioDao();
        
        Funcionario funcionario = dao.getFuncionarioPorId(1);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Usuário: " + funcionario.getUsuario());
        System.out.println("Senha: " + funcionario.getSenha());

    }

}
