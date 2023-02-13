package it.myexolab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Data

@Document
//@SuppressWarnings("unused")
public class Dipendente {
     @Id
	private String id;
	private String nome;
	private String cognome;
	private int eta;
	private String ruolo;
	
	private String lemiemodifiche;
	
	private String aggroba;
	
	private String vedisefunje;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
	
	
}
