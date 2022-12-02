package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.PacketReceivedTimeHolder;

import model.Crianca;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;

public class ResponsavelDAO {
	Connection con, conn;
	PreparedStatement stmt;
	public ResultSet rs;
	private String primeiroNome, sobrenome;

	// MÉTODO RESPONSÁVEL POR SALVAR UM NOVO REGISTRO NO BANCO DE DADOS.
	public String cadastrarResponsavel(String cpf, String nome, String senha) {
		ConexaoDAO responsavel = new ConexaoDAO();
		String retorno = "erro";
		try {

			Connection ExConn = (Connection) responsavel.abrirConexao();
			Statement stmt = (Statement) ExConn.createStatement();
			String sql = "INSERT INTO autea.Responsavel VALUES ('" + cpf + "', '" + nome + "', '" + senha + "');";
			System.out.println(sql);
			boolean res = stmt.execute(sql);

			JOptionPane.showMessageDialog(null,
					(!res) ? "Dados inseridos com sucesso!" : "" + "Os dados não puderam ser inseridos!");
			stmt.close();
			responsavel.fecharConexao(ExConn);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser inseridos!");
		}
		return retorno;

	}

	// MÉTODO ALTERAR RESPONSÁVEL
	public void alterar(Responsavel objresponsavelalterar) {
		conn = new ConexaoDAO().abrirConexao();
		PreparedStatement stmt = null;

		try {
			String sql = "UPDATE autea.Responsavel SET nome = ? , senha = ? WHERE cpf = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, objresponsavelalterar.getNome());
			stmt.setString(2, objresponsavelalterar.getSenha());
			stmt.setString(3, PerfilUser.responsavel.getCpf());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser alterados!" + erro);
		}
	}

	// MÉTODO EXCLUIR PERFIL RESPONSÁVEL
	public void excluir(Responsavel objresponsavelexcluir) {
		con = new ConexaoDAO().abrirConexao();
		conn = new ConexaoDAO().abrirConexao();
		PreparedStatement stmt = null;

		try {

			String comando1 = "DELETE FROM Crianca C WHERE c.cpf_responsavel = ?;";
			String comando2 = "DELETE FROM Responsavel WHERE cpf = ?;";

			stmt = con.prepareStatement(comando1);
			stmt.setString(1, PerfilUser.responsavel.getCpf());
			stmt.executeUpdate();
			con.close();

			stmt = conn.prepareStatement(comando2);
			stmt.setString(1, PerfilUser.responsavel.getCpf());
			stmt.executeUpdate();
			conn.close();
			JOptionPane.showMessageDialog(null, "Usuário deletado!");

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro! " + erro);
		}

	}

	// MÉTODO DE AUTENTICAÇÃO LOGIN
	public ResultSet autenticacaoResponsavel(Responsavel objresponsavellogin) {
		conn = new ConexaoDAO().abrirConexao();

		try {
			String sql = "SELECT* FROM autea.Responsavel WHERE cpf = ? AND senha = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, objresponsavellogin.getCpf());
			stmt.setString(2, objresponsavellogin.getSenha());

			ResultSet rs = stmt.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ResponsavelDAO" + erro);
			return null;
		}

	}

	/*
	 * MÉTODO DE CONSULTA: PEGANDO O NOME E O SOBRENOME DA CRIANCA E ADICIONANDO EM
	 * UMA VARIÁVEL PARA CHAMAR ESSAS VARIÁVEIS NA JCOMBOBOX E NO FRONT(TELA DE
	 * CONFIG) TESTE
	 */
	Crianca crianca = new Crianca();

	// TESTE MÉTODO LISTA JCOMBOBOX
	public List<Crianca> listaCriancas() {
		conn = ConexaoDAO.abrirConexao();

		try {
			String sql = "SELECT* FROM autea.Crianca WHERE cpf_responsavel = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, PerfilUser.responsavel.getCpf());
			ResultSet rs = stmt.executeQuery();

			List<Crianca> lista = new ArrayList();

			while (rs.next()) {
				
				Crianca crianca = new Crianca();
				
				crianca.setPrimeiroNome(rs.getString("primeiroNome"));
				crianca.setSobrenome(rs.getString("sobrenome"));
				crianca.setId(rs.getInt("id"));
				
				lista.add(crianca);
			}
			return lista;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro! ResponsavelDAO listaCriancas " + erro);
			return null;
		}
	
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
