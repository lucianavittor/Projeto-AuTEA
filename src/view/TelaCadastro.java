package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;

import dao.ResponsavelDAO;
import model.PerfilUser;
import model.Responsavel;

import java.awt.Button;

public class TelaCadastro extends JFrame{
	
//não é privada porque precisa ser chamada pelo botao
	JFrame TelaCadastro;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JTextField txtCpf;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.TelaCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaCadastro() {
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
		
		TelaCadastro = new JFrame();
		TelaCadastro.getContentPane().setBackground(new Color(255, 255, 255));
		TelaCadastro.setResizable(false);
		TelaCadastro.setBounds(10, 10, 1350, 720);
		TelaCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/images/perfil.png")));
		TelaCadastro.setTitle("AuTEA");
		TelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TelaCadastro.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(325, 223, 687, 236);
		TelaCadastro.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNome = new JLabel("Nome do Responsável");
		lblNome.setBounds(39, 93, 221, 32);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_1.add(lblNome);

		txtNome = new JTextField();
		txtNome.setToolTipText("Insira seu nome");
		txtNome.setBounds(270, 92, 350, 38);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 19));
		txtNome.setColumns(10);
		panel_1.add(txtNome);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Crie sua senha");
		txtSenha.setBounds(270, 153, 114, 38);
		panel_1.add(txtSenha);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSenha.setBackground(new Color(255, 204, 153));

		JLabel lblSenha = new JLabel("Criar Senha");
		lblSenha.setBounds(146, 155, 114, 32);
		panel_1.add(lblSenha);
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 20));
		
		txtCpf = new JTextField();
		txtCpf.setToolTipText("Insira seu cpf");
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 19));
		txtCpf.setColumns(10);
		txtCpf.setBounds(270, 29, 350, 38);
		panel_1.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF do Responsável");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblCpf.setBounds(62, 30, 198, 32);
		panel_1.add(lblCpf);
		
		JLabel lblNewLabel = new JLabel("*apenas 10 caracteres são permitidos ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel.setBounds(395, 162, 247, 21);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(0, 0, 1334, 105);
		TelaCadastro.getContentPane().add(panel);

		JLabel lbltitulo = new JLabel("Cadastro AuTEA");
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lbltitulo.setBounds(459, 11, 389, 83);
		panel.add(lbltitulo);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CONTROLLER
				String cpf = txtCpf.getText();
				String nome = txtNome.getText();
				String senha = txtSenha.getText();
				
				PerfilUser.responsavel.setNome(nome);
				
				Responsavel objresponsavel = new Responsavel();
				objresponsavel.setCpf(cpf);
				objresponsavel.setNome(nome);
				objresponsavel.setSenha(senha);
				
				
				ResponsavelDAO objresponsaveldao = new ResponsavelDAO();
				objresponsaveldao.cadastrarResponsavel(cpf, nome, senha);
				
				PerfilUser.responsavel = objresponsavel;
				
				JOptionPane.showMessageDialog(null, "Dados Registrados! Volte e faça login", "Informação",
						JOptionPane.INFORMATION_MESSAGE);

		
			}
		});
		btnCadastrar.setBackground(new Color(153, 153, 153));
		btnCadastrar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCadastrar.setBounds(609, 524, 119, 48);
		TelaCadastro.getContentPane().add(btnCadastrar);
		
		JButton button = new JButton(new ImageIcon(TelaCadastrarCrianca.class.getResource("/images/seta.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2 fr2 = new Tela2();
				fr2.Frame2.setVisible(true);
				TelaCadastro.dispose();
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.setBackground(new Color(51, 51, 102));
		button.setActionCommand("");
		button.setBounds(31, 618, 72, 39);
		TelaCadastro.getContentPane().add(button);
	}
	
}
