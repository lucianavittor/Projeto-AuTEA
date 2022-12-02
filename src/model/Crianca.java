package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Crianca {
	private int id;
	private String primeiroNome;
	private String sobrenome;
	private Responsavel cpf_responsavel;

	public Crianca() {

	}

	public Crianca(int id, String primeiroNome, String sobrenome, Responsavel cpf_responsavel) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.cpf_responsavel = cpf_responsavel;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Responsavel getCpf_responsavel() {
		return cpf_responsavel;
	}

	public void setCpf_responsavel(Responsavel cpf_responsavel) {
		this.cpf_responsavel = cpf_responsavel;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCpf_responsavel(String text) {
		// TODO Auto-generated method stub

	}
	public String toString() {
		return this.primeiroNome + " " + sobrenome;
		
	}
	
}