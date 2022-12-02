package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import dao.ConexaoDAO;
import dao.CriancaDAO;
import dao.ResponsavelDAO;
import model.Crianca;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;

public class TelaConfiguracaoCrianca extends JFrame {

	JLabel lbltitulo, lbltitulo2, lblPrimeiroNome, lblSobrenome;
	JTextPane paneResumo, paneExcluir;
	JTextField txtPrimeiroNome, txtSobrenome;
	JButton btnSalvar, btnAlterar, btnExcluir, btnLimpar;

	public TelaConfiguracaoCrianca() {
		super("AuTEA - configurações");
		Container tainer = getContentPane();
		tainer.setBackground(new Color(255, 255, 255));

		setLayout(null);

		lbltitulo = new JLabel("Configurações gerais");
		paneResumo = new JTextPane();
		lblPrimeiroNome = new JLabel("Primeiro Nome");
		lblSobrenome = new JLabel("Sobrenome");
		paneExcluir = new JTextPane();

		lbltitulo.setBounds(120, 5, 200, 40);
		paneResumo.setBounds(30, 60, 365, 70);
		lblPrimeiroNome.setBounds(30, 110, 130, 40);
		lblSobrenome.setBounds(30, 170, 90, 40);
		paneExcluir.setBounds(30, 250, 235, 65);

		lbltitulo.setFont((new Font("Arial", Font.BOLD, 16)));
		lblPrimeiroNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblSobrenome.setFont(new Font("Arial", Font.BOLD, 13));

		lbltitulo.setForeground(new Color(51, 51, 102));
		paneResumo.setForeground(new Color(51, 51, 102));
		paneResumo.setEditable(false);
		paneResumo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		paneResumo.setText("Aqui você pode configurar, editar e excluir o perfil :)");
		paneResumo.setAlignmentX(CENTER_ALIGNMENT);
		paneResumo.setAlignmentY(CENTER_ALIGNMENT);
		paneResumo.setCaretPosition(SwingConstants.CENTER);
		
		paneExcluir.setText("*ATENÇÃO: se você excluir esse perfil, todos os dados da criança serão apagados permanentemente.");
		paneExcluir.setForeground(Color.red);
		paneExcluir.setBackground(new Color(245, 245, 245));
		paneExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		paneExcluir.setAlignmentX(CENTER_ALIGNMENT);
		paneExcluir.setAlignmentY(CENTER_ALIGNMENT);
		paneExcluir.setCaretPosition(SwingConstants.CENTER);

		tainer.add(lbltitulo);
		tainer.add(lblPrimeiroNome);
		tainer.add(lblSobrenome);
		tainer.add(paneResumo);
		tainer.add(paneExcluir);

		txtPrimeiroNome = new JTextField();
		txtSobrenome = new JTextField();

		txtPrimeiroNome.setBounds(30, 145, 230, 28);
		txtSobrenome.setBounds(30, 205, 230, 28);

		txtPrimeiroNome.setEditable(false);
		txtSobrenome.setEditable(false);

		txtPrimeiroNome.setText(PerfilCrianca.crianca.getPrimeiroNome());
		txtSobrenome.setText(PerfilCrianca.crianca.getSobrenome());

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(92, 40, 220, 3);
		separator1.setBackground(new Color(255, 153, 51));
		separator1.setForeground(new Color(255, 153, 51));

		tainer.add(txtPrimeiroNome);
		tainer.add(txtSobrenome);

		tainer.add(separator1);

		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnLimpar = new JButton("Limpar");

		btnSalvar.setBounds(280, 145, 80, 25);
		btnAlterar.setBounds(280, 205, 80, 25);
		btnExcluir.setBounds(280, 265, 80, 25);

		tainer.add(btnSalvar);
		tainer.add(btnAlterar);
		tainer.add(btnExcluir);

		btnAlterar.addActionListener(new ActionListener() {

			// CONTROLLER
			public void actionPerformed(ActionEvent e) {
				txtPrimeiroNome.setEditable(true);
				txtSobrenome.setEditable(true);

			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Crianca objcriancaalterar = new Crianca();

				objcriancaalterar.setPrimeiroNome(txtPrimeiroNome.getText());
				objcriancaalterar.setSobrenome(txtSobrenome.getText());

				CriancaDAO objcriancadao = new CriancaDAO();
				objcriancadao.alterar(objcriancaalterar);

				txtPrimeiroNome.setEditable(false);
				txtSobrenome.setEditable(false);

				if (txtPrimeiroNome != null) {
					PerfilCrianca.crianca.setPrimeiroNome(txtPrimeiroNome.getText());
					PerfilCrianca.crianca.setSobrenome(txtSobrenome.getText());

					view.PerfilCrianca mudar = new view.PerfilCrianca();
					dispose();
					mudar.framePerfilCrianca.setVisible(true);
				}
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Crianca objcriancaexcluir = new Crianca();
				CriancaDAO objcriancadao = new CriancaDAO();
				objcriancadao.excluir(objcriancaexcluir);
				
				TelaPerfilUsuario sair = new TelaPerfilUsuario();
				sair.TelaPerfilUsuario.setVisible(true);
				TelaConfiguracaoCrianca.this.dispose();
				
			}
		});

		setSize(430, 380);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/images/perfil.png")));

		setResizable(false);
	}

	public static void main(String[] args) {
		TelaConfiguracaoCrianca FrameConfig = new TelaConfiguracaoCrianca();
		FrameConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
