package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
    
    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Funcionario funcionario) {
        String sql = "insert into funcionarios " + 
                "(nome, usuario, senha)" + 
                "values (?, ?, ?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());

            // executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public List<Funcionario> getLista() {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.connection
                    .prepareStatement("SELECT * FROM funcionarios");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto funcionario
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));

                // adicionando objeto a lista
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario getFuncionarioPorId(int id) {

        try {
            PreparedStatement stmt = this.connection
                .prepareStatement("SELECT * FROM funcionarios where id = ?");
            
            stmt.setInt(1, id);

            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            Funcionario funcionario = new Funcionario();

            if (rs.next()) {
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
            }

            return funcionario;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        
    }

    public void altera(Funcionario funcionario) {
        
        String sql = "update funcionarios set nome=?, usuario=?," + 
                "senha=? where id=?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setLong(4, funcionario.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

    }

    public void deleta(Funcionario funcionario) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from funcionarios where id=?");
            stmt.setLong(1, funcionario.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

}
