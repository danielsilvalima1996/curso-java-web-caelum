package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

    public static void main(String[] args) {

        // pronto para gravar
        Contato contato = new Contato();
        contato.setNome("Daniel da Silva de Lima");
        contato.setEmail("dsl15021996@gmail.com");
        contato.setEndereco("Rua Sebastianópolis do Sul, 67");
        Calendar data = new GregorianCalendar(1996,1,15);
        contato.setDataNascimento(data);
        contato.setId(2L);

        // grave nessa conexão
        ContatoDao dao = new ContatoDao();

        // método elegante
        dao.altera(contato);

        System.out.println("Gravado!");

    }

}
