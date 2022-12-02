package dao;

import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Crianca;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;
import view.TelaConfiguracaoCrianca;
import view.TelaPerfilUsuario;

public class CriancaDAO {

	Connection conn;

	// MÉTODO RESPONSÁVEL POR SALVAR UM NOVO REGISTRO NO BANCO DE DADOS.
	public String cadastrarCrianca(String primeiroNome, String sobrenome, Responsavel responsavel) {
		ConexaoDAO crianca = new ConexaoDAO();
		String retorno = "erro";
		try {

			String sql = "INSERT INTO autea.Crianca(primeiroNome, sobrenome, cpf_responsavel) VALUES (?,?,?)";
			Connection ExConn = (Connection) crianca.abrirConexao();
			PreparedStatement stmt = ExConn.prepareStatement(sql);

			stmt.setString(1, primeiroNome);
			stmt.setString(2, sobrenome);
			stmt.setString(3, responsavel.getCpf());
			stmt.execute();

			System.out.println(sql);
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			stmt.close();
			crianca.fecharConexao(ExConn);

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser inseridos!");
			System.err.println(erro);
		}
		return retorno;

	}

	// MÉTODO ALTERAR CRIANCA
	public void alterar(Crianca objcriancaalterar) {
		conn = new ConexaoDAO().abrirConexao();
		PreparedStatement stmt = null;
		String retorno = "erro";

		try {
			String sql = "UPDATE autea.Crianca SET primeiroNome = ? , sobrenome = ? WHERE primeiroNome = ? and sobrenome = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, objcriancaalterar.getPrimeiroNome());
			stmt.setString(2, objcriancaalterar.getSobrenome());
			stmt.setString(3, PerfilCrianca.crianca.getPrimeiroNome());
			stmt.setString(4, PerfilCrianca.crianca.getSobrenome());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser alterados!" + erro);
		}

	}
	
	// MÉTODO EXCLUIR PERFIL CRIANCA
		public void excluir(Crianca objcriancaexcluir) {
			conn = new ConexaoDAO().abrirConexao();
			PreparedStatement stmt = null;

			try {

				String sql = "DELETE FROM Crianca C WHERE c.primeiroNome = ? AND sobrenome = ?;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, PerfilCrianca.crianca.getPrimeiroNome());
				stmt.setString(2, PerfilCrianca.crianca.getSobrenome());
				stmt.executeUpdate();
			
				conn.close();
				JOptionPane.showMessageDialog(null, "Perfil deletado!");

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro! " + erro);
			}

		}
	
	
	//MÉTODO PARA CHAMAR DADOS DO BANCO, ADICIONAR NA ARRAYLIST PRA DEPOIS CHAMAR NA JCOMBOBOX
	public static ArrayList<Crianca> criancas = new ArrayList<>();

	public ResultSet consultarcrianca() {
		conn = ConexaoDAO.abrirConexao();
		PreparedStatement stmt;
		try {
			String sql = "SELECT* FROM autea.Crianca WHERE primeiroNome = ? AND sobrenome = ?;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			stmt.setString(1, rs.getString("primeiroNome"));
			stmt.setString(2, rs.getString("sobrenome"));
		
			return rs;
		 }
		catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro!" + erro);
			return null;
		}

		
	}

}
