package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Crianca;
import model.EstadoPreferencias;
import model.PerfilCrianca;
import model.Responsavel;

public class EstadoPreferenciasDAO {
EstadoPreferencias objpreferencia = new EstadoPreferencias();

	// MÉTODO RESPONSÁVEL POR SALVAR UM NOVO REGISTRO NO BANCO DE DADOS.
		public String salvarRelatorio(String humor, String cor, String dataEmitida, String horaEmitida, Crianca crianca) {
	
		ConexaoDAO conn = new ConexaoDAO();
		String retorno = "erro";
		try {

			String sql = "INSERT INTO autea.EstadoPreferencia(humor, cor, dataEmitida, horaEmitida, id_crianca) VALUES (?,?,?,?,?);";

			Connection ExConn = (Connection) conn.abrirConexao();
			PreparedStatement stmt = ExConn.prepareStatement(sql);

			stmt.setString(1, humor);
			stmt.setString(2, cor);
			stmt.setString(3, dataEmitida);
			stmt.setString(4, horaEmitida);
			stmt.setInt(5, PerfilCrianca.crianca.getId());
			//stmt.setInt(6, PerfilCrianca.crianca.getId());
			stmt.execute();

			System.out.println(sql);
			//JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Informação",
					//JOptionPane.INFORMATION_MESSAGE);
			stmt.close();
			conn.fecharConexao(ExConn);

		} catch (SQLException erro) {
			//JOptionPane.showMessageDialog(null, "Os dados não puderam ser inseridos!");
			System.err.println(erro);
		}
		return retorno;

	}

}
