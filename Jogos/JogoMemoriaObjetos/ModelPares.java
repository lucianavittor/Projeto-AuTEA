package JogoMemoriaObjetos;

import javax.swing.JButton;

public class ModelPares {

    private int numBtn;
    private JButton btn;
    private int valorCorresponde;

    public ModelPares() {
    }

    public ModelPares(int numBtn, JButton btn, int valorCorresponde) {
        this.numBtn = numBtn;
        this.btn = btn;
        this.setValorCorresponde(valorCorresponde);
    }

    public int getNumBtn() {
        return numBtn;
    }

    public void setNumBtn(int numberBtn) {
        this.numBtn = numberBtn;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

	public int getValorCorresponde() {
		return valorCorresponde;
	}

	public void setValorCorresponde(int valorCorresponde) {
		this.valorCorresponde = valorCorresponde;
	
	}
	
    @Override
    public String toString() {
        return "Pares{" + "numbBtn=" + numBtn + ", btn=" + btn + ", valorCorresponde=" + numBtn + '}';
    }


}