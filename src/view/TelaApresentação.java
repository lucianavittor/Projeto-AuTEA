package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.List;
import java.awt.Label;
import javax.swing.JMenu;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaApresentação {

JFrame MainFrame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApresentação window = new TelaApresentação();
					window.MainFrame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	
	public TelaApresentação() {
		initialize();
	}

	
	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setResizable(false);
		MainFrame.getContentPane().setBackground(new Color(255, 255, 255));
		//frame.setSize(1350, 750);
		//ajustando tamanho do frame:
		MainFrame.setBounds(10,10, 1350, 720);
		MainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaApresentação.class.getResource("/images/perfil.png")));
		MainFrame.setTitle("AuTEA");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 105);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		panel.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Seja Bem Vindo ao AuTEA!");
		lbltitulo.setBounds(352, 11, 623, 83);
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		panel.add(lbltitulo);
		
		JLabel lblsubt1 = new JLabel("Sobre o AuTEA");
		lblsubt1.setBounds(204, 142, 327, 59);
		lblsubt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		lblsubt1.setForeground(new Color(51, 51, 102));
		
		JLabel lblsubt2 = new JLabel("Instruções");
		lblsubt2.setBounds(854, 142, 231, 59);
		lblsubt2.setForeground(new Color(51, 51, 102));
		lblsubt2.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		
		JTextPane txt1 = new JTextPane();
		txt1.setBounds(165, 225, 426, 359);
		txt1.setEditable(false);
		txt1.setForeground(new Color(153, 153, 204));
		txt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		txt1.setText("O AuTEA é um aplicativo que auxiliará no desenvolvimento da coordenação motora, das funções cognitivas e das habilidades sociais da criança com TEA.");
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(165, 204, 426, 3);
		separator1.setBackground(new Color(255, 153, 51));
		separator1.setForeground(new Color(255, 153, 51));
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(754, 204, 426, 3);
		separator2.setForeground(new Color(255, 153, 51));
		separator2.setBackground(new Color(255, 153, 51));
		
		JTextPane txtpnAsAtividadesPropostas = new JTextPane();
		txtpnAsAtividadesPropostas.setBounds(754, 225, 426, 359);
		txtpnAsAtividadesPropostas.setText("As atividades propostas pelo AuTEA devem ser feitas pela criança com a supervisão de um responsável. O acompanhamento deve ser feito do inicio ao fim. ");
		txtpnAsAtividadesPropostas.setForeground(new Color(153, 153, 204));
		txtpnAsAtividadesPropostas.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		txtpnAsAtividadesPropostas.setEditable(false);
		
		JButton btnproximatela = new JButton("");
		btnproximatela.setIcon(new ImageIcon(TelaApresentação.class.getResource("/images/setaEsquerdaazul.png")));
		btnproximatela.setBackground(new Color(51, 51, 102));
		btnproximatela.setForeground(new Color(51, 51, 102));
		btnproximatela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2 jf = new Tela2();
				jf.Frame2.setVisible(true);
				MainFrame.dispose();
			}
		});
		
		btnproximatela.setBounds(1209, 618, 71, 39);		
		btnproximatela.setFont(new Font("Arial", Font.PLAIN, 25));
		MainFrame.getContentPane().setLayout(null);
		MainFrame.getContentPane().add(panel);
		MainFrame.getContentPane().add(lblsubt1);
		MainFrame.getContentPane().add(lblsubt2);
		MainFrame.getContentPane().add(separator1);
		MainFrame.getContentPane().add(separator2);
		MainFrame.getContentPane().add(txt1);
		MainFrame.getContentPane().add(txtpnAsAtividadesPropostas);
		MainFrame.getContentPane().add(btnproximatela);
	}
}
