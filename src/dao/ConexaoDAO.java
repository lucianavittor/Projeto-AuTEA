package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	public static Connection abrirConexao() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autea?useTimezone=true&serverTimezone=UTC",
					"root", "fv2556");
					System.out.println("Conexão realizada!");
		
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());

		}

		return con;
	}
	
	  public void fecharConexao(Connection con) {   
	        try {   
	            if (con != null && !con.isClosed()) {     
	                con.close();   
	               // JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!!!");   
	            }   
	        } catch (SQLException ex) {   
	            JOptionPane.showMessageDialog(null, "Erro ao Fechar a conexão \n" + ex + JOptionPane.ERROR_MESSAGE);   
	        }   
	    }   
	       

	public static void main(String[] args) {
		ConexaoDAO.abrirConexao();
	}
}
