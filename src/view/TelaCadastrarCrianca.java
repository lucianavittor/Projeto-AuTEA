package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;

import dao.CriancaDAO;
import dao.ResponsavelDAO;
import model.Crianca;
import model.PerfilCrianca;
import model.PerfilUser;
import model.Responsavel;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaCadastrarCrianca {

	private JFrame TelaCadastrarCrianca;
	private JTextField txtSobrenome;
	private JTextField txtNome;
	String dataRecebida;
	
	 private Date formatarData(String data) throws ParseException {
	        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        return new Date( formatter.parse(data).getTime() );
	    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCrianca window = new TelaCadastrarCrianca();
					window.getPerfilKids().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCadastrarCrianca() {
		initialize();
	}

	
	private void initialize() {
		setPerfilKids(new JFrame());
		getPerfilKids().getContentPane().setBackground(new Color(255, 255, 255));
		getPerfilKids().setBounds(10, 10, 1350, 720);
		getPerfilKids().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getPerfilKids().getContentPane().setLayout(null);
		
		JButton btnCriar = new JButton("CRIAR");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				//CONTROLLER
				String primeiroNome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				
				Crianca objcrianca = new Crianca();
				objcrianca.setPrimeiroNome(primeiroNome);
				objcrianca.setSobrenome(sobrenome);
				
				PerfilCrianca.crianca = objcrianca;

				CriancaDAO objcriancadao = new CriancaDAO();
				objcriancadao.cadastrarCrianca(primeiroNome, sobrenome, PerfilUser.responsavel);
				 
				
				JOptionPane.showMessageDialog(null, "O perfil da criança foi criado. Quando precisar editá-lo, vá em "
						+ "configurações gerais :)", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				
				txtNome.setText("");
				txtSobrenome.setText("");
			}
		});
				
		
		btnCriar.setForeground(new Color(255, 255, 255));
		btnCriar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCriar.setBackground(new Color(51, 51, 102));
		btnCriar.setBounds(598, 486, 119, 48);
		getPerfilKids().getContentPane().add(btnCriar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(0, 0, 1334, 105);
		getPerfilKids().getContentPane().add(panel);
		
		JLabel lblPerfilKids = new JLabel("Perfil KIDs");
		lblPerfilKids.setForeground(Color.WHITE);
		lblPerfilKids.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lblPerfilKids.setBounds(539, 11, 263, 83);
		panel.add(lblPerfilKids);
		
		JButton btnSetaEsquerda = new JButton(new ImageIcon(TelaCadastrarCrianca.class.getResource("/images/seta.png")));
		btnSetaEsquerda.setBounds(52, 32, 70, 39);
		panel.add(btnSetaEsquerda);
		
		btnSetaEsquerda.setForeground(SystemColor.scrollbar);
		btnSetaEsquerda.setBackground(SystemColor.scrollbar);
		btnSetaEsquerda.setActionCommand("");
		
		btnSetaEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfilUsuario perfiluser = new TelaPerfilUsuario();
				perfiluser.TelaPerfilUsuario.setVisible(true);
				getPerfilKids().dispose();
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(394, 221, 557, 176);
		getPerfilKids().getContentPane().add(panel_1);
		
		JLabel lblPrimeiroNome = new JLabel("Primeiro Nome");
		lblPrimeiroNome.setForeground(Color.WHITE);
		lblPrimeiroNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPrimeiroNome.setBounds(32, 35, 144, 32);
		panel_1.add(lblPrimeiroNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setForeground(Color.WHITE);
		lblSobrenome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSobrenome.setBounds(62, 102, 114, 32);
		panel_1.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 19));
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(186, 101, 339, 38);
		panel_1.add(txtSobrenome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 19));
		txtNome.setColumns(10);
		txtNome.setBounds(186, 34, 339, 38);
		panel_1.add(txtNome);
		
		JLabel lblNewLabel = new JLabel("Não se preocupe, você poderá editar esses dados mais tarde.");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(435, 409, 477, 48);
		TelaCadastrarCrianca.getContentPane().add(lblNewLabel);
	}

	public JFrame getPerfilKids() {
		return TelaCadastrarCrianca;
	}

	public void setPerfilKids(JFrame perfilKids) {
		TelaCadastrarCrianca = perfilKids;
		TelaCadastrarCrianca.setTitle("AuTEA");
		TelaCadastrarCrianca.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarCrianca.class.getResource("/images/perfil.png")));
	}
}
