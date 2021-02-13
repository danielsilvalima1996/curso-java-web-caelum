package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarioInsere {
    
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Deleta Esse");
        funcionario.setUsuario("deleta.esse");
        funcionario.setSenha("error404");

        // grave nessa conexão
        FuncionarioDao dao = new FuncionarioDao();

        // método elegante
        dao.adicionar(funcionario);

        System.out.println("Gravado!");

    }

}
