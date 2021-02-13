package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarioAltera {
    
    public static void main(String[] args) {

        // pronto para gravar
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Daniel da Silva de Lima");
        funcionario.setUsuario("daniel.lima");
        funcionario.setSenha("P@ssW0rd");
        funcionario.setId(2L);

        // grave nessa conexão
        FuncionarioDao dao = new FuncionarioDao();

        // método elegante
        dao.altera(funcionario);

        System.out.println("Gravado!");

    }

}
