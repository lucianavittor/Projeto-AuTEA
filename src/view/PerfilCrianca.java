package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.CriancaDAO;
import dao.ResponsavelDAO;
import model.Crianca;

import java.awt.Toolkit;
import javax.swing.JInternalFrame;

public class PerfilCrianca {

	public JFrame framePerfilCrianca;
	JLabel lblNomeCrianca;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCrianca window = new PerfilCrianca();
					window.framePerfilCrianca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PerfilCrianca() {
		initialize();
	}

	private void initialize() {
		framePerfilCrianca = new JFrame();
		framePerfilCrianca.setTitle("AuTEA");
		framePerfilCrianca.setIconImage(Toolkit.getDefaultToolkit().getImage(PerfilCrianca.class.getResource("/images/perfil.png")));
		framePerfilCrianca.getContentPane().setBackground(new Color(255, 255, 255));
		framePerfilCrianca.setBounds(10, 10, 1350, 720);
		framePerfilCrianca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePerfilCrianca.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 105);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		framePerfilCrianca.getContentPane().add(panel);
		
		JLabel lblPerfil = new JLabel("Bem Vindo ao seu Perfil Kids!");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lblPerfil.setBounds(203, 11, 953, 83);
		panel.add(lblPerfil);
		
		JButton btnCadastrarcrianca = new JButton("Gerar Relatório de humor");
		btnCadastrarcrianca.setBounds(725, 286, 224, 47);
		btnCadastrarcrianca.setToolTipText("Veja os dados do relatório criado");
		btnCadastrarcrianca.setForeground(Color.WHITE);
		btnCadastrarcrianca.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCadastrarcrianca.setBackground(new Color(51, 51, 102));
		framePerfilCrianca.getContentPane().add(btnCadastrarcrianca);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil Kids");
		btnEditarPerfil.setBounds(725, 354, 224, 45);
		
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//consultarcrianca
				
				TelaConfiguracaoCrianca entrar = new TelaConfiguracaoCrianca();
				/*ResponsavelDAO obj = new ResponsavelDAO();
				
				String primeiroNome, sobrenome;
			
				primeiroNome = model.PerfilCrianca.crianca.getPrimeiroNome();
	
				entrar.txtPrimeiroNome.setText(primeiroNome);*/
				entrar.setVisible(true);
				
				/*TelaPerfilUsuario obj = new TelaPerfilUsuario();
				Crianca crianca = new Crianca();
				crianca = obj.PegarObjeto();
				
				if(crianca != null) {
					entrar.txtPrimeiroNome.setText(String.valueOf(crianca.getPrimeiroNome()));
					entrar.txtSobrenome.setText(String.valueOf(crianca.getSobrenome()));
				}*/
				
			}
		});
		btnEditarPerfil.setToolTipText("Edite o perfil kids");
		btnEditarPerfil.setForeground(Color.WHITE);
		btnEditarPerfil.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnEditarPerfil.setBackground(new Color(51, 51, 102));
		framePerfilCrianca.getContentPane().add(btnEditarPerfil);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(403, 242, 272, 269);
		btnNewButton.setToolTipText("Clique aqui para entrar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(PerfilCrianca.class.getResource("/images/perfiluserG.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstado_Preferencias perfis = new TelaEstado_Preferencias();
				perfis.EstadoPref.setVisible(true);
				framePerfilCrianca.dispose();
			}
		});
		
		framePerfilCrianca.getContentPane().add(btnNewButton);
		
		lblNomeCrianca = new JLabel(model.PerfilCrianca.crianca.getPrimeiroNome() + " " + model.PerfilCrianca.crianca.getSobrenome());
		//lblNomeCrianca = new JLabel(model.PerfilCrianca.crianca.getSobrenome());
		
		lblNomeCrianca.setBounds(403, 184, 272, 47);
		lblNomeCrianca.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCrianca.setFont(new Font("Century Gothic", Font.BOLD, 25));
		framePerfilCrianca.getContentPane().add(lblNomeCrianca);
		
		JButton btnSair = new JButton("Sair do perfil kids");
		btnSair.setBounds(725, 420, 224, 45);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfilUsuario sair = new TelaPerfilUsuario();
				sair.TelaPerfilUsuario.setVisible(true);
				framePerfilCrianca.dispose();
				
			}
		});
		btnSair.setToolTipText("");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSair.setBackground(new Color(51, 51, 102));
		framePerfilCrianca.getContentPane().add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Clique no ícone para entrar");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(440, 522, 203, 47);
		framePerfilCrianca.getContentPane().add(lblNewLabel);
	}
}
