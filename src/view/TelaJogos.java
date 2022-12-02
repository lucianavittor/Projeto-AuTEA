package view;

import java.awt.Color;
import view.TelaEstado_Preferencias;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PerfilCrianca;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaJogos extends JFrame {

	 JFrame TelaJogos;
	 JLabel lbltitulo;
	 JPanel panel, painelprincipal;
	// JButton btn1Colunas, btn2Memoria, btn3Formas, btn4Vogais, btn5Alfabeto;
	 JButton btn1Colunas, btn2Memoria, btn3Formas, btn5Alfabeto;
	 private JButton btnConfiguraesGerais;
	 TelaEstado_Preferencias color = new TelaEstado_Preferencias();
		Color cor = color.color;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogos window = new TelaJogos();
					window.TelaJogos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaJogos() {
		initialize();
	}

	private void initialize() {

		// Look and Feel
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

		Font sans = new Font("Comic Sans MS", Font.PLAIN, 50);
		Font sansJogos = new Font("Comic Sans MS", Font.PLAIN, 20);
		

		TelaJogos = new JFrame();
		TelaJogos.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogos.class.getResource("/images/perfil.png")));

		TelaJogos.setTitle("AuTEA");
		//JogosAmarela.getContentPane().setBackground(new Color(255, 244, 92));
		TelaJogos.getContentPane().setLayout(null);


		painelprincipal = new JPanel();
		painelprincipal.setBounds(0, 0, 1334, 681);
		
		TelaJogos.getContentPane().add(painelprincipal);
	    		painelprincipal.setLayout(null);
	    
	    		JButton btnSair = new JButton("Sair");
	    		btnSair.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				TelaEstado_Preferencias voltar = new TelaEstado_Preferencias();
	    				voltar.EstadoPref.setVisible(true);
	    				TelaJogos.dispose();
	    				
	    			}
	    		});
	    		btnSair.setBackground(new Color(255, 255, 255));
	    		btnSair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
	    		btnSair.setForeground(new Color(160, 82, 45));
	    		btnSair.setLayout(null);
	    		btnSair.setBounds(28, 22, 59, 31);
	    		painelprincipal.add(btnSair);

	    panel = new JPanel();

		panel.setBounds(120, 110, 1090 , 510);
		panel.setLayout(null);
		panel.setBorder(null);

		//panel.setBackground(new Color(255, 245, 202));

		//JogosAmarela.getContentPane().add(panel);
		painelprincipal.add(panel);

		
		//btn1Colunas = new JButton(new ImageIcon(getClass().getResource("/images/jogo1amarelo.png")));
		btn1Colunas = new JButton();
		btn1Colunas.setBounds(97, 136, 152, 155);
		panel.add(btn1Colunas);

		btn2Memoria = new JButton();
		btn2Memoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrincipalJogoMemoria jogomemoria = new PrincipalJogoMemoria();
				jogomemoria.getContentPane().setBackground(cor);
				jogomemoria.setVisible(true);
				TelaJogos.dispose();
			}
		});
		btn2Memoria.setBounds(466, 136, 152, 155);
		panel.add(btn2Memoria);

		btn3Formas = new JButton();
		btn3Formas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalMemoriaVogais abrir = new PrincipalMemoriaVogais();
				abrir.setVisible(true);
			}
		});
		btn3Formas.setBounds(837, 136, 152, 155);
		panel.add(btn3Formas);

		/*btn4Vogais = new JButton();
		btn4Vogais.setBounds(282, 288, 152, 155);
		panel.add(btn4Vogais);

		btn5Alfabeto = new JButton();
		btn5Alfabeto.setBounds(656, 288, 152, 155);
		panel.add(btn5Alfabeto);*/

		JLabel lblJogo1 = new JLabel("Interligar Colunas");
		lblJogo1.setBounds(97, 302, 175, 47);
		lblJogo1.setForeground(new Color(160, 82, 45));
		lblJogo1.setFont(sansJogos);
		panel.add(lblJogo1);

		JLabel lblJogo2 = new JLabel("Jogo da Memória - Objetos");
		lblJogo2.setBounds(417, 302, 257, 47);
		lblJogo2.setForeground(new Color(160, 82, 45));
		lblJogo2.setFont(sansJogos);
		panel.add(lblJogo2);

		JLabel lblJogo3 = new JLabel("Jogo da Memória - Vogais");
		lblJogo3.setBounds(793, 302, 242, 47);
		lblJogo3.setForeground(new Color(160, 82, 45));
		lblJogo3.setFont(sansJogos);
		panel.add(lblJogo3);

		/*JLabel lblJogo4 = new JLabel("Exercicio de Vogais");
		lblJogo4.setBounds(272, 454, 189, 47);
		lblJogo4.setForeground(new Color(160, 82, 45));
		lblJogo4.setFont(sansJogos);
		panel.add(lblJogo4);*/

		/*JLabel lblJogo5 = new JLabel("Exercicio do Alfabeto");
		lblJogo5.setBounds(634, 454, 212, 47);
		lblJogo5.setForeground(new Color(160, 82, 45));
		lblJogo5.setFont(sansJogos);
		panel.add(lblJogo5);*/

		//JLabel lbltitulo = new JLabel(PerfilCrianca.crianca.getPrimeiroNome());
		JLabel lbltitulo = new JLabel("Teste 1");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);

		lbltitulo.setForeground(Color.white);
		// lblNewLabel.setBackground(new Color(160, 82, 45));
		lbltitulo.setBounds(120, 28, 1090, 71);
		lbltitulo.setFont(sans);

		//JogosAmarela.getContentPane().add(lbltitulo);
		painelprincipal.add(lbltitulo);
		
		btnConfiguraesGerais = new JButton("");
		btnConfiguraesGerais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.PerfilCrianca abrir = new view.PerfilCrianca();
				abrir.framePerfilCrianca.setVisible(true);
				TelaJogos.dispose();
			}
		});
		btnConfiguraesGerais.setIcon(new ImageIcon(TelaJogos.class.getResource("/images/config.gerais.png")));
		btnConfiguraesGerais.setForeground(new Color(160, 82, 45));
		btnConfiguraesGerais.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnConfiguraesGerais.setBackground(Color.WHITE);
		btnConfiguraesGerais.setBounds(28, 71, 59, 41);
		painelprincipal.add(btnConfiguraesGerais);

		//JogosAmarela.getContentPane().add(btnSair);

		TelaJogos.setBounds(10, 10, 1350, 720);
		TelaJogos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TelaJogos.setLocationRelativeTo(null);
		TelaJogos.setResizable(false);
		TelaJogos.setVisible(true);
	}
}