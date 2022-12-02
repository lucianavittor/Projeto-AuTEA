package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;

import dao.EstadoPreferenciasDAO;
import model.EstadoPrefStatic;
import model.EstadoPreferencias;
import model.PerfilCrianca;
import model.Responsavel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;

public class TelaEstado_Preferencias extends JFrame {

	public JFrame EstadoPref;
	Color color, color1, corjogo;
	ImageIcon imagembtn1, imagembtn2, imagembtn3, imagembtn4, imagembtn5;
	private String humor, cor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstado_Preferencias window = new TelaEstado_Preferencias();
					window.EstadoPref.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criando aplicação

	public TelaEstado_Preferencias() {
		initialize();
	}

	private void initialize() {

		// data e hora atual
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.format(new Date(System.currentTimeMillis()));

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

		// Dados do Frame
		EstadoPref = new JFrame();
		EstadoPref.setTitle("AuTEA");
		EstadoPref.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEstado_Preferencias.class.getResource("/images/perfil.png")));
		EstadoPref.getContentPane().setBackground(new Color(255, 255, 255));
		EstadoPref.getContentPane().setLayout(null);

		// Painel
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.scrollbar);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1334, 105);
		EstadoPref.getContentPane().add(panel);

		JLabel lbltitulo = new JLabel("Estado e Preferências");
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lbltitulo.setBounds(413, 11, 536, 83);
		panel.add(lbltitulo);

		// botao para voltar o frame
		JButton btnSetaEsquerda = new JButton(
				new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/seta esquerda cinza.png")));
		btnSetaEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.PerfilCrianca perfiluser = new view.PerfilCrianca();
				perfiluser.framePerfilCrianca.setVisible(true);
				EstadoPref.dispose();
			}
		});
		btnSetaEsquerda.setBounds(52, 32, 70, 39);
		panel.add(btnSetaEsquerda);

		btnSetaEsquerda.setForeground(SystemColor.scrollbar);
		btnSetaEsquerda.setBackground(SystemColor.scrollbar);
		btnSetaEsquerda.setActionCommand("");

		// Botões do humor da criança

		JLabel lblhumor = new JLabel("Como você está se sentindo hoje?");
		lblhumor.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblhumor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblhumor.setBounds(445, 145, 456, 46);
		EstadoPref.getContentPane().add(lblhumor);
		EstadoPref.setBounds(10, 10, 1350, 720);
		EstadoPref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * configuração botões humor aqui a criança deve escolher uma opção o botão
		 * selecionado muda a cor do frame
		 */

		// Botão feliz
		JButton btnfeliz = new JButton();
		btnfeliz.setSelected(true);
		btnfeliz.setBackground(Color.WHITE);
		btnfeliz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "feliz";
			}
		});
		btnfeliz.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojifeliz2.png")));
		btnfeliz.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojifeliz.png")));
		btnfeliz.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojifeliz2.png")));
		btnfeliz.setBounds(134, 238, 136, 138);
		btnfeliz.setToolTipText("Feliz");
		EstadoPref.getContentPane().add(btnfeliz);

		/*
		 * Configuração da cor do Frame aqui a criança vai escolher a cor do frame a cor
		 * selecionada será a cor principal do frame
		 */

		JLabel lblcor = new JLabel("Qual cor você prefere hoje?");
		lblcor.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblcor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblcor.setBounds(480, 430, 367, 46);
		EstadoPref.getContentPane().add(lblcor);

		JButton btnazul = new JButton();
		btnazul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = "azul";
				color = new Color(108, 180, 239);
				panel.setBackground(color);
				color1 = new Color(231, 240, 255);
				corjogo = color;

				imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1azul.png"));
				imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2azul.png"));
				imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4azul.png"));
				//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4azul.png"));
				//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5azul.png"));

				EstadoPref.getContentPane().setBackground(color1);

			}
		});
		btnazul.setToolTipText("Azul claro");
		btnazul.setBounds(267, 500, 120, 119);
		btnazul.setBackground(new Color(108, 180, 239));
		btnazul.setForeground(new Color(108, 180, 239));
		EstadoPref.getContentPane().add(btnazul);

		JButton btnrosa = new JButton();
		btnrosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = "rosa";
				color = new Color(243, 104, 136);
				panel.setBackground(color);
				color1 = new Color(255, 241, 247);
				corjogo = color;

				imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1rosa.png"));
				imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2rosa.png"));
				imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4rosa.png"));
				//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4rosa.png"));
				//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5rosa.png"));

				EstadoPref.getContentPane().setBackground(color1);
			}
		});
		btnrosa.setBackground(new Color(243, 104, 136));
		btnrosa.setToolTipText("Rosa claro");
		btnrosa.setBounds(451, 500, 120, 119);
		EstadoPref.getContentPane().add(btnrosa);

		JButton btnlaranja = new JButton();
		btnlaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = "alaranjado";
				color = new Color(249, 163, 98);
				panel.setBackground(color);
				color1 = new Color(255, 234, 215);
				corjogo = color;

				imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1laranja.png"));
				imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2laranja.png"));
				imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4laranja.png"));
				//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4laranja.png"));
				//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5laranja.png"));

				EstadoPref.getContentPane().setBackground(color1);
			}
		});
		btnlaranja.setBackground(new Color(249, 163, 98));
		btnlaranja.setToolTipText("Alaranjado");
		btnlaranja.setBounds(635, 500, 120, 119);
		EstadoPref.getContentPane().add(btnlaranja);

		JButton btnamarelo = new JButton();
		btnamarelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = "amarelo";
				color = new Color(255, 244, 92);
				panel.setBackground(color);
				color1 = new Color(255, 245, 202);
				corjogo = color;

				imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1amarelo.png"));
				imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2amarelo.png"));
				imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4amarelo.png"));
				//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4amarelo.png"));
				//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5amarelo.png"));

				EstadoPref.getContentPane().setBackground(color1);
			}
		});
		btnamarelo.setBackground(new Color(255, 244, 92));
		btnamarelo.setToolTipText("Amarelo");
		btnamarelo.setBounds(816, 500, 120, 119);
		EstadoPref.getContentPane().add(btnamarelo);

		JButton btnverde = new JButton();
		btnverde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = "verde";
				color = new Color(111, 235, 128);
				panel.setBackground(color);
				color1 = new Color(224, 252, 221);
				corjogo = color;

				imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1verde.png"));
				imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2verde.png"));
				imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4verde.png"));
				//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4verde.png"));
				//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5verde.png"));

				EstadoPref.getContentPane().setBackground(color1);

			}
		});
		btnverde.setBackground(new Color(111, 235, 128));
		btnverde.setToolTipText("Verde");
		btnverde.setBounds(1001, 500, 120, 119);
		EstadoPref.getContentPane().add(btnverde);

		// seta para o próximo frame
		JButton btnSetaRedonda = new JButton(
				new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/setaredonda.png")));
		btnSetaRedonda.setBackground(Color.WHITE);

		btnSetaRedonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (humor == null) {
					if(color != null) {
					JOptionPane.showMessageDialog(EstadoPref,"Ops, nenhum humor foi selecionado. Selecione algum para poder seguir em frente.", "Atenção",
							1);
					
					}
				}
				
				if (color == null) {
					if (humor != null) {
					cor = "padrão sistema";

					int i = JOptionPane.showConfirmDialog(EstadoPref,
							"Nenhuma cor foi selecionada. Deseja continuar com a cor padrão do sistema?", "Atenção",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			
					if (i == 0) {
						TelaJogos telamarela1 = new TelaJogos();

						telamarela1.painelprincipal.setBackground(new Color(51, 51, 102));
						telamarela1.panel.setBackground(new Color(255, 255, 255));
						imagembtn1 = new ImageIcon(getClass().getResource("/images/jogo1padrao.png"));
						imagembtn2 = new ImageIcon(getClass().getResource("/images/jogo2padrao.png"));
						imagembtn3 = new ImageIcon(getClass().getResource("/images/jogo4padrao.png"));
						//imagembtn4 = new ImageIcon(getClass().getResource("/images/jogo4padrao.png"));
						//imagembtn5 = new ImageIcon(getClass().getResource("/images/jogo5padrao.png"));

						telamarela1.btn1Colunas.setIcon(imagembtn1);
						telamarela1.btn2Memoria.setIcon(imagembtn2);
						telamarela1.btn3Formas.setIcon(imagembtn3);
						//telamarela1.btn4Vogais.setIcon(imagembtn4);
						//telamarela1.btn5Alfabeto.setIcon(imagembtn5);
						telamarela1.TelaJogos.setVisible(true);	
						EstadoPref.dispose();

					}
					}
				} else {
					if(humor != null) {
					

					TelaJogos telamarela = new TelaJogos();
					telamarela.painelprincipal.setBackground(color);
					telamarela.panel.setBackground(color1);

					// botões dos jogos
					telamarela.btn1Colunas.setIcon(imagembtn1);
					telamarela.btn2Memoria.setIcon(imagembtn2);
					telamarela.btn3Formas.setIcon(imagembtn3);
					//telamarela.btn4Vogais.setIcon(imagembtn4);
					//telamarela.btn5Alfabeto.setIcon(imagembtn5);
					EstadoPref.dispose();

				}}

				// CONTROLLER
				String dataEmitida, horaEmitida;
				dataEmitida = "02/12/2022";
				horaEmitida = "10:00";

				EstadoPreferencias objpreferencia = new EstadoPreferencias();
				objpreferencia.setHumor(humor);
				objpreferencia.setCor(cor);
				objpreferencia.setDataEmitida(dataEmitida);
				objpreferencia.setHoraEmitida(horaEmitida);
				objpreferencia.setId_crianca(PerfilCrianca.crianca.getId());

				System.out.println("-------- Estado e Preferencias");
				System.out.println("Id...: " + PerfilCrianca.crianca.getId());
				System.out.println("Humor...: " + humor);
				System.out.println("Cor...: " + cor);

				EstadoPreferenciasDAO objpreferenciadao = new EstadoPreferenciasDAO();
				objpreferenciadao.salvarRelatorio(humor, cor, dataEmitida, horaEmitida, objpreferencia.getId_crianca());

				EstadoPrefStatic.estado = objpreferencia;
			}
		});
		btnSetaRedonda.setBounds(1237, 576, 64, 64);
		EstadoPref.getContentPane().add(btnSetaRedonda);

		JButton btnbem = new JButton();
		btnbem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "bem";
			}
		});
		btnbem.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojibem2.png")));
		btnbem.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojibem2.png")));
		btnbem.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojibem.png")));
		btnbem.setToolTipText("Bem");
		btnbem.setSelected(true);
		btnbem.setBackground(Color.WHITE);
		btnbem.setBounds(320, 238, 136, 138);
		EstadoPref.getContentPane().add(btnbem);

		JButton btntriste = new JButton();
		btntriste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "triste";
			}
		});
		btntriste.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojitriste2.png")));
		btntriste.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojitriste2.png")));
		btntriste.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojitriste.png")));
		btntriste.setToolTipText("Feliz");
		btntriste.setSelected(true);
		btntriste.setBackground(Color.WHITE);
		btntriste.setBounds(506, 238, 136, 138);
		EstadoPref.getContentPane().add(btntriste);

		JButton btnserio = new JButton();
		btnserio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "sério";
			}
		});
		btnserio.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiserio.png")));
		btnserio.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiserio2.png")));
		btnserio.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiserio2.png")));
		btnserio.setToolTipText("Sério");
		btnserio.setSelected(true);
		btnserio.setBackground(Color.WHITE);
		btnserio.setBounds(692, 238, 136, 138);
		EstadoPref.getContentPane().add(btnserio);

		JButton btnchateado = new JButton();
		btnchateado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "chateado";
			}
		});
		btnchateado
				.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/desamparado2.png")));
		btnchateado
				.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/desamparado2.png")));
		btnchateado.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/desamparado.png")));
		btnchateado.setToolTipText("Chateado");
		btnchateado.setSelected(true);
		btnchateado.setBackground(Color.WHITE);
		btnchateado.setBounds(878, 238, 136, 138);
		EstadoPref.getContentPane().add(btnchateado);

		JButton btnconfuso = new JButton();
		btnconfuso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humor = "confuso";
			}
		});
		btnconfuso.setIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiconfudo.png")));
		btnconfuso
				.setRolloverIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiconfuso2.png")));
		btnconfuso
				.setPressedIcon(new ImageIcon(TelaEstado_Preferencias.class.getResource("/images/emojiconfuso2.png")));
		btnconfuso.setToolTipText("Confuso");
		btnconfuso.setSelected(true);
		btnconfuso.setBackground(Color.WHITE);
		btnconfuso.setBounds(1064, 238, 136, 138);
		EstadoPref.getContentPane().add(btnconfuso);
	}

	public String getHumor() {
		return humor;
	}

	public void setHumor(String humor) {
		this.humor = humor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
