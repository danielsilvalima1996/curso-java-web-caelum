package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarioDelete {
    
    public static void main(String[] args) {

        // pronto para gravar
        Funcionario funcionario = new Funcionario();
        funcionario.setId(3L);

        // grave nessa conexão
        FuncionarioDao dao = new FuncionarioDao();

        // método elegante
        dao.deleta(funcionario);

        System.out.println("Deleta!");

    }

}
