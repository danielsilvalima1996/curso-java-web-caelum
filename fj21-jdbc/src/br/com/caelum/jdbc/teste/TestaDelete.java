package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDelete {

    public static void main(String[] args) {

        // pronto para gravar
        Contato contato = new Contato();
        contato.setId(3L);

        // grave nessa conexão
        ContatoDao dao = new ContatoDao();

        // método elegante
        dao.deleta(contato);

        System.out.println("Deleta!");

    }

}
