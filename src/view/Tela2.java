package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

public class Tela2 {

	 JFrame Frame2;
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2 window = new Tela2();
					window.Frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Tela2() {
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
		
		Frame2 = new JFrame();
		Frame2.setResizable(false);
		Frame2.getContentPane().setBackground(new Color(255, 255, 255));
		Frame2.setBounds(10, 10, 1350, 720);		
		Frame2.setIconImage(Toolkit.getDefaultToolkit().getImage(Tela2.class.getResource("/images/perfil.png")));
		Frame2.setTitle("AuTEA");
		Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(550, 250, 232, 99);
		btnCadastrar.setInheritsPopupMenu(false);
		btnCadastrar.setSelected(true);
		btnCadastrar.setAutoscrolls(true);
		btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCadastrar.setFont(new Font("Century Gothic", Font.BOLD, 35));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrindo a próxima tela 
				TelaCadastro frcadastro = new TelaCadastro();
				frcadastro.TelaCadastro.setVisible(true);
				Frame2.dispose();
			}
		});
		Frame2.getContentPane().setLayout(null);
		btnCadastrar.setForeground(new Color(51, 51, 102));
		btnCadastrar.setBackground(new Color(255, 153, 102));
		Frame2.getContentPane().add(btnCadastrar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(550, 398, 232, 99);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin frlogin = new TelaLogin();
				frlogin.TelaLogin.setVisible(true);
				Frame2.dispose();
				
			}
		});
		btnLogin.setAutoscrolls(true);
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogin.setForeground(new Color(51, 51, 102));
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 35));
		btnLogin.setBackground(new Color(255, 153, 102));
		Frame2.getContentPane().add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 105);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		Frame2.getContentPane().add(panel);
		
		JLabel lbltitulo = new JLabel("AuTEA");
		lbltitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lbltitulo.setBounds(588, 11, 165, 83);
		panel.add(lbltitulo);
		
		JButton button = new JButton(new ImageIcon(TelaCadastrarCrianca.class.getResource("/images/seta.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentação mainframe = new TelaApresentação();
				mainframe.MainFrame.setVisible(true);
				Frame2.dispose();
				
			}
		});
		button.setBounds(36, 617, 70, 39);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.setBackground(new Color(51, 51, 102));
		button.setActionCommand("");
		Frame2.getContentPane().add(button);
		

		JPanel panel2 = new JPanel();
		panel2.setBorder(null);
		panel2.setBounds(0, 0, 434, 45);
		panel2.setBackground(new Color(51, 51, 102));
		panel2.setLayout(null);
		
		JLabel lbltitulo2 = new JLabel("AuTEA");
		lbltitulo2.setBounds(68, 5, 297, 34);
		lbltitulo2.setForeground(Color.WHITE);
		lbltitulo2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		panel2.add(lbltitulo2);
		
	}
}
