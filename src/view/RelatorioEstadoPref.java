package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioEstadoPref {

	private JFrame Relatorio;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioEstadoPref window = new RelatorioEstadoPref();
					window.Relatorio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RelatorioEstadoPref() {
		initialize();
	}

	
	private void initialize() {
		Relatorio = new JFrame();
		Relatorio.getContentPane().setBackground(new Color(255, 255, 255));
		Relatorio.setTitle("AuTEA");
		Relatorio.setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioEstadoPref.class.getResource("/images/perfil.png")));
		Relatorio.setBounds(10, 10, 1350, 720);
		Relatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Relatorio.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(0, 0, 1334, 105);
		Relatorio.getContentPane().add(panel);
		
		JLabel lblRelatrioDeHumor = new JLabel("Relatório de humor");
		lblRelatrioDeHumor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDeHumor.setForeground(Color.WHITE);
		lblRelatrioDeHumor.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lblRelatrioDeHumor.setBounds(451, 11, 443, 83);
		panel.add(lblRelatrioDeHumor);
		
		JButton btnSetaEsquerda = new JButton(new ImageIcon(RelatorioEstadoPref.class.getResource("/images/seta.png")));
		btnSetaEsquerda.setForeground(SystemColor.scrollbar);
		btnSetaEsquerda.setBackground(SystemColor.scrollbar);
		btnSetaEsquerda.setActionCommand("");
		btnSetaEsquerda.setBounds(52, 32, 70, 39);
		panel.add(btnSetaEsquerda);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Humor", "Cor escolhida", "Data Emitida", "Hora Emitida"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(76);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(78);
		table.setBackground(new Color(51, 51, 102));
		table.setBounds(435, 405, 364, -214);
		Relatorio.getContentPane().add(table);
	}
}
