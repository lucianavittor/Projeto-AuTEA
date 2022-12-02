package JogoMemoriaObjetos;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.PrincipalJogoMemoria;


public class ControleBtnPares {

    private List<ModelPares> pares = new ArrayList<>();
    private List<ModelPares> ok = new ArrayList<>();

    //MÉTODO ONDE OS NÚMEROS DE RAMDON SÃO CARREGADOS EM LINHA    
    public static List<Integer> rowsTable() {
        List<Integer> lista = new ArrayList<>();
        Random r = new Random();
        int aumentar = 1;
        for (int i = 0; i < aumentar; i++) {
            if (lista.size() != 4) {
                aumentar++;
            }
            int valor = r.nextInt(5);
            if (!lista.contains(valor) && lista.size() != 5 && valor != 0) {
                lista.add(valor);
            }
        }
        return lista;
    }

  //MÉTODO PARA INSERIR AS DUAS LINHAS
    public static List<Integer> rowsTableAll() {
        List<Integer> todas = new ArrayList<>();
        todas.addAll(rowsTable());
        todas.addAll(rowsTable());
        return todas;
    }

  //MÉTODO PARA PINTAR AS IMAGENS
    public void paintImage(JButton btn, int valor) {
        try {
            btn.setIcon(new ImageIcon(getClass().getResource("/images/0" + valor + ".png")));
            btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

 // MÉTODO QUE INICIALIZA AS IMAGENS
    public void imgStart() {
        paintImage(PrincipalJogoMemoria.btn01, 9);
        paintImage(PrincipalJogoMemoria.btn02, 9);
        paintImage(PrincipalJogoMemoria.btn03, 9);
        paintImage(PrincipalJogoMemoria.btn04, 9);
        paintImage(PrincipalJogoMemoria.btn05, 9);
        paintImage(PrincipalJogoMemoria.btn06, 9);
        paintImage(PrincipalJogoMemoria.btn07, 9);
        paintImage(PrincipalJogoMemoria.btn08, 9);
    }

  //MÉTODO PARA QUANDO OS DOIS VALORES SÃO IGUAIS
    	public void paintMatch() {
        System.out.println(getPares().size());
        if (getPares().size() == 1) {
            paintImage(getPares().get(0).getBtn(), getPares().get(0).getValorCorresponde());
        } else if(getPares().size() == 2) {
            paintImage(getPares().get(1).getBtn(), getPares().get(1).getValorCorresponde());
        }
    }

    	//MÉTODO ONDE AS IMAGENS JÁ CORRESPONDEM
    	public void imgStartMatch() {
        if (ok.size() == 8) {
            JOptionPane.showMessageDialog(null, "Você venceu!");

            for (int i = 0; i < ok.size(); i++) {
                paintImage(ok.get(i).getBtn(), ok.get(i).getValorCorresponde());
                ok.get(i).getBtn().setEnabled(true);
            }
            ok.clear();
            imgStart();
        }
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i).getNumBtn() + "_" + ok.get(i).getValorCorresponde());
            paintImage(ok.get(i).getBtn(), ok.get(i).getValorCorresponde());
            ok.get(i).getBtn().setEnabled(false);
        }
    }

    	//MÉTODO QUE CONTROLA A EXECUÇÃO
    	public void reset() {
        imgStart();
        imgStartMatch();
    }

    	// MÉTODO DE CORRESPONDÊNCIA
    	public void match() {
        if (getPares().size() == 2) {
            if (getPares().get(0).getNumBtn() != 0 && getPares().get(1).getNumBtn() != 0) {

                if (getPares().get(0).getValorCorresponde() == getPares().get(1).getValorCorresponde()) {
                    ok.add(getPares().get(0));
                    ok.add(getPares().get(1));
                    getPares().clear();
                    reset();
                } else {                    
                    Runnable mx = new Runnable() {
                        @Override
                        public void run() {
                        	getPares().clear();
                            reset();
                        }
                    };
                    setTimeout(mx, 2000);
                }
            }
        }
    }

    public void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public List<ModelPares> getPares() {
        return pares;
    }

    public void setPares(List<ModelPares> pares) {
        this.pares = pares;
    }

}