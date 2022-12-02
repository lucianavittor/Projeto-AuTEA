package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import dao.CriancaDAO;
import dao.ResponsavelDAO;
import model.Crianca;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaPerfilUsuario extends JFrame {

	public JFrame TelaPerfilUsuario;
	JLabel lblPerfil;
	JComboBox<Crianca> cbxcrianca;
	String nomeCrianca;
	ResponsavelDAO objresponsaveldao = new ResponsavelDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfilUsuario window = new TelaPerfilUsuario();
					window.TelaPerfilUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPerfilUsuario() {
		initialize();
		// restaurarDadosComboBoxCrianca();
		lotarCombo();
	}

	private void initialize() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);

		}

		TelaPerfilUsuario = new JFrame();
		TelaPerfilUsuario.setTitle("AuTEA");
		TelaPerfilUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPerfilUsuario.class.getResource("/images/perfil.png")));
		TelaPerfilUsuario.getContentPane().setBackground(new Color(255, 255, 255));
		TelaPerfilUsuario.setBounds(10, 10, 1350, 720);
		TelaPerfilUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon img = new ImageIcon("configurarUser.png");

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 105);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));

		lblPerfil = new JLabel(PerfilUser.responsavel.getNome());
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lblPerfil.setBounds(172, 11, 984, 83);
		panel.add(lblPerfil);
		TelaPerfilUsuario.getContentPane().setLayout(null);
		TelaPerfilUsuario.getContentPane().add(panel);

		JPanel panelNomePerfil = new JPanel();
		panelNomePerfil.setLayout(null);
		panelNomePerfil.setBorder(null);
		panelNomePerfil.setBackground(new Color(51, 51, 102));
		panelNomePerfil.setBounds(0, 616, 1334, 65);
		TelaPerfilUsuario.getContentPane().add(panelNomePerfil);

		cbxcrianca = new JComboBox<Crianca>();

		cbxcrianca.setToolTipText("Selecione uma criança");
		cbxcrianca.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		cbxcrianca.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));
		cbxcrianca.setSelectedIndex(0);
		cbxcrianca.setBounds(520, 448, 199, 32);
		TelaPerfilUsuario.getContentPane().add(cbxcrianca);

		JButton btnCadastrarcrianca = new JButton("Cadastrar Nova Criança");
		btnCadastrarcrianca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastrarCrianca userKid = new TelaCadastrarCrianca();
				userKid.getPerfilKids().setVisible(true);
				TelaPerfilUsuario.dispose();

			}
		});
		btnCadastrarcrianca.setToolTipText("Cadastre uma nova criança");
		btnCadastrarcrianca.setForeground(new Color(255, 255, 255));
		btnCadastrarcrianca.setBackground(new Color(51, 51, 102));
		btnCadastrarcrianca.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCadastrarcrianca.setBounds(742, 256, 211, 45);
		TelaPerfilUsuario.getContentPane().add(btnCadastrarcrianca);

		JButton btnEditarPerfil = new JButton("Editar Perfil de Usuário");
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConfiguracoes entrar = new TelaConfiguracoes();
				entrar.setVisible(true);
			}
		});
		btnEditarPerfil.setToolTipText("Edite seu perfil de usuário");
		btnEditarPerfil.setForeground(new Color(255, 255, 255));
		btnEditarPerfil.setBackground(new Color(51, 51, 102));
		btnEditarPerfil.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnEditarPerfil.setBounds(742, 312, 211, 45);
		TelaPerfilUsuario.getContentPane().add(btnEditarPerfil);

		JLabel lbltitulo = new JLabel("Selecione uma criança");
		lbltitulo.setForeground(new Color(0, 0, 0));
		lbltitulo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbltitulo.setBounds(504, 179, 228, 47);
		TelaPerfilUsuario.getContentPane().add(lbltitulo);

		JLabel lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon(TelaPerfilUsuario.class.getResource("/images/perfiluserG.png")));
		lblIcone.setBounds(520, 237, 199, 199);
		TelaPerfilUsuario.getContentPane().add(lblIcone);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(255, 153, 102));

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Crianca crianca = new Crianca();
				crianca = PegarObjeto();

				if (crianca != null) {
					view.PerfilCrianca abrir = new view.PerfilCrianca();
					PerfilCrianca.crianca.setPrimeiroNome(String.valueOf(crianca.getPrimeiroNome()));
					PerfilCrianca.crianca.setSobrenome(String.valueOf(crianca.getSobrenome()));
					PerfilCrianca.crianca.setId(crianca.getId());
					abrir.lblNomeCrianca.setText(
							String.valueOf(crianca.getPrimeiroNome()) + " " + String.valueOf(crianca.getSobrenome()));

					System.out.println("Primeiro Nome....: " + String.valueOf(crianca.getPrimeiroNome()));
					System.out.println("Sobrenome....: " + String.valueOf(crianca.getSobrenome()));
					System.out.println("Id....: " + String.valueOf(crianca.getId()));
					
					abrir.framePerfilCrianca.setVisible(true);
					TelaPerfilUsuario.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma criança!" );
					
				}
			}
		});
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnEntrar.setBounds(569, 502, 99, 32);
		TelaPerfilUsuario.getContentPane().add(btnEntrar);

		JButton btnSairDoPerfil = new JButton("Sair do Perfil");
		btnSairDoPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				login.TelaLogin.setVisible(true);
				TelaPerfilUsuario.dispose();
			}
		});
		btnSairDoPerfil.setToolTipText("");
		btnSairDoPerfil.setForeground(Color.WHITE);
		btnSairDoPerfil.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSairDoPerfil.setBackground(new Color(51, 51, 102));
		btnSairDoPerfil.setBounds(742, 368, 211, 45);
		TelaPerfilUsuario.getContentPane().add(btnSairDoPerfil);

	}

	// adicionando variáveis na combobox
	public void lotarCombo() {
		List<Crianca> lista = new ArrayList<Crianca>();
		lista = objresponsaveldao.listaCriancas();

		cbxcrianca.removeAllItems();
		cbxcrianca.addItem(null);

		for (Crianca crianca : lista) {
			cbxcrianca.addItem(crianca);
		}
	}

	public Crianca PegarObjeto() {
		Crianca crianca = new Crianca();
		crianca = (Crianca) cbxcrianca.getSelectedItem();
		return crianca;
	}

}
