package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import dao.ResponsavelDAO;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.SystemColor;

public class TelaLogin extends JFrame{

	JFrame TelaLogin;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JTextField txtCpf;
	public String senhauser;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.TelaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaLogin() {
		initialize();
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
		
		TelaLogin = new JFrame();
		TelaLogin.getContentPane().setBackground(new Color(255, 255, 255));
		TelaLogin.setResizable(false);
		TelaLogin.setBounds(10, 10, 1350, 720);
		TelaLogin.setBackground(new Color(255, 255, 255));
		TelaLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/images/perfil.png")));
		TelaLogin.setTitle("AuTEA");
		TelaLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(0, 0, 1334, 105);
		TelaLogin.getContentPane().add(panel);
		
		JLabel lbltitulo = new JLabel("Login AuTEA");
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lbltitulo.setBounds(529, 11, 301, 83);
		panel.add(lbltitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(477, 202, 415, 293);
		TelaLogin.getContentPane().add(panel_1);
		
		JLabel lblNome = new JLabel("Nome Usuário");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNome.setBounds(33, 11, 169, 32);
		panel_1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 19));
		txtNome.setColumns(10);
		txtNome.setBounds(33, 54, 350, 38);
		panel_1.add(txtNome);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSenha.setBackground(new Color(255, 204, 153));
		txtSenha.setBounds(33, 238, 114, 32);
		panel_1.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSenha.setBounds(33, 195, 60, 32);
		panel_1.add(lblSenha);
		
		JLabel lblCpfUsurio = new JLabel("CPF Usuário");
		lblCpfUsurio.setForeground(Color.WHITE);
		lblCpfUsurio.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblCpfUsurio.setBounds(33, 103, 169, 32);
		panel_1.add(lblCpfUsurio);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 19));
		txtCpf.setColumns(10);
		txtCpf.setBounds(33, 146, 350, 38);
		panel_1.add(txtCpf);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Autenticação de login
				String cpf, senha, nome;
				
				nome = txtNome.getText();
				cpf = txtCpf.getText();
				senha = txtSenha.getText();
				
				
				Responsavel objresponsavellogin = new Responsavel();
				objresponsavellogin.setNome(nome);
				objresponsavellogin.setCpf(cpf);
				objresponsavellogin.setSenha(senha);
				
				ResponsavelDAO objresponsaveldao = new ResponsavelDAO();
				ResultSet rsresponsaveldao = objresponsaveldao.autenticacaoResponsavel(objresponsavellogin);
				
				PerfilUser.responsavel = objresponsavellogin;
				PerfilCrianca.crianca.setCpf_responsavel(PerfilUser.responsavel.getCpf());

				try {
					if (rsresponsaveldao.next()) {
					
					JOptionPane.showMessageDialog(null, "Seja Bem Vindo ao AuTEA!", "Informação", 1);
					//TelaCriarPerfil abrir = new TelaCriarPerfil();
					//abrir.TelaCriarPerfil.setVisible(true);
					TelaPerfilUsuario abrir = new TelaPerfilUsuario();
					abrir.TelaPerfilUsuario.setVisible(true);
					TelaLogin.dispose();				

					} else {
						
						JOptionPane.showMessageDialog(null, "Dados invalidos!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
	

				}
		});
		
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEntrar.setBackground(new Color(153, 153, 153));
		btnEntrar.setBounds(623, 536, 119, 48);
		TelaLogin.getContentPane().add(btnEntrar);
		
		JButton button = new JButton(new ImageIcon(TelaCadastrarCrianca.class.getResource("/images/seta.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2 fr2 = new Tela2();
				fr2.Frame2.setVisible(true);
				TelaLogin.dispose();
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.setBackground(new Color(51, 51, 102));
		button.setActionCommand("");
		button.setBounds(33, 618, 68, 39);
		TelaLogin.getContentPane().add(button);
		TelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
