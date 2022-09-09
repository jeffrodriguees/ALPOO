package np2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;





public class NAlunos {

    Connection conexao;

    public Connection getConexao() {
        return conexao;
    }
    Statement stm;
    ResultSet rs;
    Statement statement = null;

    public void conexao() throws SQLException {
        conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

    }

    public NAlunos() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {

        }

    }

    public String incluir(EAlunos eAlunos) {
       try {
            conexao();
            PreparedStatement instrucao = conexao.prepareStatement("insert into cadastro values(?,?,?)");
            instrucao.setString(1, eAlunos.getRa());
            instrucao.setString(2, eAlunos.getNome());
            instrucao.setString(3, eAlunos.getCurso());
            /*instrucao.setInt(4, eAlunos.getDtMatricula());
            instrucao.setInt(5, eAlunos.getDtNascimento());
            instrucao.setString(6, eAlunos.getCidadeNatal());
            instrucao.setString(7, eAlunos.getUfNatal());
            instrucao.setString(8, eAlunos.getPai());
            instrucao.setString(9, eAlunos.getMae());
            instrucao.setString(10, eAlunos.getRua());
            instrucao.setString(11, eAlunos.getSetor());
            instrucao.setString(12, eAlunos.getCidade());
            instrucao.setString(13, eAlunos.getUf());
            instrucao.setInt(14, eAlunos.getCep());*/

            instrucao.executeUpdate();
            
            //System.out.println();
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        return null;
    }
}





