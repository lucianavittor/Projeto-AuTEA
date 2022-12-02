package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument.Content;

import dao.ResponsavelDAO;
import model.PerfilUser;
import model.Responsavel;

public class TelaConfiguracoes extends JFrame {

	JLabel lbltitulo, lbltitulo2, lblNome, lblCpf, lblCpfuser, lblSenha;
	JTextPane paneResumo;
	JTextField txtNome, txtSenha;
	JButton btnSalvar, btnAlterar, btnExcluir, btnLimpar;
	JPanel panel = new JPanel();


	public TelaConfiguracoes() {
		super("AuTEA - configurações");
		
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
		
		Container tainer = getContentPane();
		tainer.setBackground(new Color(255, 255, 255));
		
		setLayout(null);
		
		lbltitulo = new JLabel("Configurações gerais");
		paneResumo = new JTextPane();
		panel = new JPanel();
		lblCpf = new JLabel("CPF");
		lblCpfuser = new JLabel(PerfilUser.responsavel.getCpf());
		lblNome = new JLabel("Nome de Usuário");
		lblSenha = new JLabel("Senha");

		panel.setBounds(30, 110, 230, 60);
		panel.setBackground(new Color(245,245,245));
		tainer.add(panel);
		
		lbltitulo.setBounds(120, 5, 200, 40);
		paneResumo.setBounds(30, 60, 365, 60);
		lblCpf.setBounds(32, 110, 90, 40);
		lblCpfuser.setBounds(32, 140, 230, 25);
		lblNome.setBounds(30, 170, 130, 40);
		lblSenha.setBounds(30, 230, 100, 40);

		lbltitulo.setFont((new Font("Arial", Font.BOLD, 16)));
		lblCpf.setFont(new Font("Arial", Font.BOLD, 13));
		lblCpfuser.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 13));
		
		lbltitulo.setForeground(new Color(51, 51, 102));
		paneResumo.setForeground(new Color(51, 51, 102));
		paneResumo.setEditable(false);
		paneResumo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		paneResumo.setText("Aqui você pode configurar, editar e excluir o perfil :)");
		paneResumo.setAlignmentX(CENTER_ALIGNMENT);
		paneResumo.setAlignmentY(CENTER_ALIGNMENT);
		paneResumo.setCaretPosition(SwingConstants.CENTER);

		tainer.add(lbltitulo);
		tainer.add(paneResumo);
		tainer.add(lblNome);
		tainer.add(lblSenha);

		tainer.add(lblCpf);
		tainer.add(lblCpfuser);
		tainer.add(panel);
	
		txtNome = new JTextField();
		txtSenha = new JTextField();

		txtNome.setBounds(30, 200, 230, 30);
		txtSenha.setBounds(30, 260, 230, 30);

		txtNome.setEditable(false);
		txtSenha.setEditable(false);

		txtNome.setText(PerfilUser.responsavel.getNome());
		txtSenha.setText(PerfilUser.responsavel.getSenha());

		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(92, 40, 220, 3);
		separator1.setBackground(new Color(255, 153, 51));
		separator1.setForeground(new Color(255, 153, 51));

		tainer.add(txtNome);
		tainer.add(txtSenha);
		tainer.add(separator1);

		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnLimpar = new JButton("Limpar");

		btnSalvar.setBounds(290, 130, 80, 30);
		btnAlterar.setBounds(290, 200, 80, 30);
		btnExcluir.setBounds(290, 260, 80, 30);

		tainer.add(btnSalvar);
		tainer.add(btnAlterar);
		tainer.add(btnExcluir);

		// BOTÃO ALTERAR
		btnAlterar.addActionListener(new ActionListener() {

			// CONTROLLER
			public void actionPerformed(ActionEvent e) {

				txtNome.setEditable(true);
				txtSenha.setEditable(true);
			}
		});
		

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Responsavel objresponsavelalterar = new Responsavel();
				
				objresponsavelalterar.setNome(txtNome.getText());
				objresponsavelalterar.setSenha(txtSenha.getText());
				
				ResponsavelDAO objresponsaveldao = new ResponsavelDAO();
				objresponsaveldao.alterar(objresponsavelalterar);
				
				txtNome.setEditable(false);
				txtSenha.setEditable(false);
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i =	JOptionPane.showConfirmDialog(null, "Tem certeza que deseja que excluir seu perfil? Todas as crianças cadastradas "
						+ "por você, também serão excluídas. Nenhum dado será mantido");
				if (i == 0) {
				Responsavel objresponsavelexcluir = new Responsavel();
				ResponsavelDAO objresponsaveldao = new ResponsavelDAO();
				objresponsaveldao.excluir(objresponsavelexcluir);
				
				TelaLogin sair = new TelaLogin();
				sair.TelaLogin.setVisible(true);
				TelaConfiguracoes.this.dispose();
			}
			}
			
		});

		setSize(430, 360);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/images/perfil.png")));
		setResizable(false);

	}

	public static void main(String[] args) {
		TelaConfiguracoes FrameConfig = new TelaConfiguracoes();
		FrameConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}