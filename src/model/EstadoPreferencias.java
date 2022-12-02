package model;

import java.sql.Date;

public class EstadoPreferencias {

	private String humor;
	private String cor;
	private String dataEmitida;
	private String horaEmitida;
	private Crianca id_crianca;

	public EstadoPreferencias() {

	}

	public EstadoPreferencias(String humor, String cor, String dataEmitida, String horaEmitida, Crianca id_crianca) {

		this.humor = humor;
		this.cor = cor;
		this.dataEmitida = dataEmitida;
		this.horaEmitida = horaEmitida;
		this.setId_crianca(id_crianca);
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

	public String getDataEmitida() {
		return dataEmitida;
	}

	public void setDataEmitida(String dataEmitida) {
		this.dataEmitida = dataEmitida;
	}

	public String getHoraEmitida() {
		return horaEmitida;
	}

	public void setHoraEmitida(String horaEmitida) {
		this.horaEmitida = horaEmitida;

	}

	public Crianca getId_crianca() {
		return id_crianca;
	}

	public void setId_crianca(Crianca id_crianca) {
		this.id_crianca = id_crianca;
	}

	public void setId_crianca(int id) {
		// TODO Auto-generated method stub
		
	}

}
