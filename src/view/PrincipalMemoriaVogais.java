package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import JogoMemoriaObjetos.ControleBtnPares;
import JogoMemoriaObjetos.ControleBtnParesVogais;
import JogoMemoriaObjetos.ModelPares;

import java.awt.SystemColor;

public class PrincipalMemoriaVogais extends JFrame {

    int clic = 0;
    JButton btnsair;
    ControleBtnParesVogais u = new    ControleBtnParesVogais();

    List<Integer> next = u.rowsTableAll();

    public PrincipalMemoriaVogais() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalJogoMemoria.class.getResource("/images/perfil.png")));
    	setBounds(new Rectangle(10, 10, 1350, 720));
  
    	getContentPane().setBounds(10, 10, 1350, 720);
    	setBounds(10, 10, 1350, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	
        iniciarComponentes();
        this.setTitle("Jogo da Memória com Vogais");
        this.setLocationRelativeTo(this);
        
        u.imgStart();
        getContentPane().add(btn01);
        getContentPane().add(btn03);
        getContentPane().add(btn05);
        getContentPane().add(btn07);
        getContentPane().add(btn02);
        getContentPane().add(btn04);
        getContentPane().add(btn06);
        getContentPane().add(btn08);
        getContentPane().add(btn09);
        getContentPane().add(btn10);

        getContentPane().setLayout(null);
 
    }

   
    @SuppressWarnings("unchecked")
    private void iniciarComponentes() {
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        
        btn01 = new javax.swing.JButton();
        btn01.setBackground(new Color(255, 255, 255));
        btn02 = new javax.swing.JButton();
        btn02.setBackground(new Color(255, 255, 255));
        btn03 = new javax.swing.JButton();
        btn03.setBackground(new Color(255, 255, 255));
        btn04 = new javax.swing.JButton();
        btn04.setBackground(new Color(255, 255, 255));
        
        btn05 = new javax.swing.JButton();
        btn05.setBackground(new Color(255, 255, 255));
        btn06 = new javax.swing.JButton();
        btn06.setBackground(new Color(255, 255, 255));
        btn07 = new javax.swing.JButton();
        btn07.setBackground(new Color(255, 255, 255));
        btn08 = new javax.swing.JButton();
        btn08.setBackground(new Color(255, 255, 255));
        btn09 = new javax.swing.JButton();
        btn09.setLocation(812, 384);
        btn09.setBackground(new Color(255, 255, 255));
        btn10 = new javax.swing.JButton();
        btn10.setLocation(1043, 384);
        btn10.setBackground(new Color(255, 255, 255));

        btn02.setSize(169, 214);
        btn03.setSize(169, 214);
        btn04.setSize(169, 214);
        btn05.setSize(169, 214);
        btn06.setSize(169, 214);
        btn07.setSize(169, 214);
        btn08.setSize(169, 214);
        btn09.setSize(169, 214);
        btn10.setSize(169, 214);

        btn02.setLocation(353, 113);
        btn03.setLocation(583, 113);
        btn04.setLocation(812, 113);
        btn05.setLocation(1043, 113);
        btn06.setLocation(123, 384);
        btn07.setLocation(353, 384);
        btn08.setLocation(583, 384);

        jButton3.setText("jButton1");
        jButton4.setText("jButton1");
        jButton5.setText("jButton1");

      //CONFIGURAÇÕES SAIR DO JOGO
     	btnsair = new JButton("Sair");
     	btnsair.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			TelaEstado_Preferencias sair = new TelaEstado_Preferencias();
				sair.EstadoPref.setVisible(true);
				dispose();
     		}
     	});
     	btnsair.setBackground(new Color(255, 255, 255));
     	btnsair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnsair.setForeground(new Color(160, 82, 45));
		btnsair.setLayout(null);
		btnsair.setBounds(28, 22, 62, 31);
		getContentPane().add(btnsair);
		
		
        
        btn01.setForeground(new java.awt.Color(240, 240, 240));
   
        btn01.setBounds(123, 113, 169, 214);
        getContentPane().add(btn01);

        btn01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn01MouseClicked(evt);
            }
        });

        btn02.setForeground(new java.awt.Color(240, 240, 240));
 
        btn02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn02MouseClicked(evt);
            }
        });

        btn03.setForeground(new java.awt.Color(240, 240, 240));
        btn03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn03MouseClicked(evt);
            }
        });

        btn04.setForeground(new java.awt.Color(240, 240, 240));
        btn04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn04MouseClicked(evt);
            }
        });

        btn05.setForeground(new java.awt.Color(240, 240, 240));
        btn05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn05MouseClicked(evt);
            }
        });

        btn06.setForeground(new java.awt.Color(240, 240, 240));
        btn06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn06MouseClicked(evt);
            }
        });

        btn07.setForeground(new java.awt.Color(240, 240, 240));
        btn07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn07MouseClicked(evt);
            }
        });

        btn08.setForeground(new java.awt.Color(240, 240, 240));
        btn08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn08MouseClicked(evt);
            }
        
        });
        
        btn09.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		btn09MouseClicked(evt);
        	}
        });
        
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		btn10MouseClicked(evt);
        	}
        });
    }

    private void btn01MouseClicked(java.awt.event.MouseEvent evt) { //Método usado quando o btn01 for clicado
        //u.evtBtn(btn01,evt,next.get(0));
    	
        ModelPares m = new ModelPares();
        m.setBtn(btn01);
        m.setNumBtn(1);
        m.setValorCorresponde(next.get(0));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn02MouseClicked(java.awt.event.MouseEvent evt) { //Método usado quando o btn02 for clicado

    	ModelPares m = new ModelPares();
        m.setBtn(btn02);
        m.setNumBtn(2);
        m.setValorCorresponde(next.get(1));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn03MouseClicked(java.awt.event.MouseEvent evt) { //Método usado quando o btn03 for clicado
       
    	ModelPares m = new ModelPares();
        m.setBtn(btn03);
        m.setNumBtn(3);
        m.setValorCorresponde(next.get(2));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn04MouseClicked(java.awt.event.MouseEvent evt) { //Método usado quando o btn04 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn04);
        m.setNumBtn(4);
        m.setValorCorresponde(next.get(3));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn05MouseClicked(java.awt.event.MouseEvent evt) { //Método usado quando o btn05 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn05);
        m.setNumBtn(5);
        m.setValorCorresponde(next.get(4));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn06MouseClicked(java.awt.event.MouseEvent evt) {//Método usado quando o btn06 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn06);
        m.setNumBtn(6);
        m.setValorCorresponde(next.get(5));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn07MouseClicked(java.awt.event.MouseEvent evt) {//Método usado quando o btn07 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn07);
        m.setNumBtn(7);
        m.setValorCorresponde(next.get(6));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    private void btn08MouseClicked(java.awt.event.MouseEvent evt) {//Método usado quando o btn08 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn08);
        m.setNumBtn(8);
        m.setValorCorresponde(next.get(7));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }
    
    private void btn09MouseClicked(java.awt.event.MouseEvent evt) {//Método usado quando o btn09 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn09);
        m.setNumBtn(9);
        m.setValorCorresponde(next.get(8));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }
    
    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//Método usado quando o btn10 for clicado
    	ModelPares m = new ModelPares();
        m.setBtn(btn10);
        m.setNumBtn(10);
        m.setValorCorresponde(next.get(9));
        u.getPares().add(m);
        u.paintMatch();
        u.match();
    }

    public static void main(String args[]) {
    //Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalMemoriaVogais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalMemoriaVogais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalMemoriaVogais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalMemoriaVogais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalMemoriaVogais().setVisible(true);
            }
        });
    }

    // Declaração das variáveis 
    public static javax.swing.JButton btn01;
    public static javax.swing.JButton btn02;
    public static javax.swing.JButton btn03;
    public static javax.swing.JButton btn04;
    public static javax.swing.JButton btn05;
    public static javax.swing.JButton btn06;
    public static javax.swing.JButton btn07;
    public static javax.swing.JButton btn08;
    public static javax.swing.JButton btn09;
    public static javax.swing.JButton btn10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
}
