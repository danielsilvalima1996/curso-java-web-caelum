package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

    public static void main(String[] args) {

        // pronto para gravar
        Contato contato = new Contato();
        contato.setNome("Daniel");
        contato.setEmail("dsl15021996@caelum.com.br");
        contato.setEndereco("Rua Sebastianópolis do Sul, 67");
        contato.setDataNascimento(Calendar.getInstance());

        // grave nessa conexão
        ContatoDao dao = new ContatoDao();

        // método elegante
        dao.adicionar(contato);

        System.out.println("Gravado!");

    }

}
