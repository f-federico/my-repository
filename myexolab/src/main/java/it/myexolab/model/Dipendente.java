package it.myexolab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//@Getter
//@Setter
//@ToString
//@Builder
@Document(collection = "dipendente")
public class Dipendente {
	@Id
	private String id;
	
	@Field(name = "nome")
	private String nome;
	@Field(name = "cognome")
	private String cognome;
	@Field(name = "eta")
	private int eta;
//	@DBRef(lazy = true)
//    @JsonIgnoreProperties(value ={"listadipendenti"})
//	@JsonManagedReference
//	private Progetto progetto;
//	@DBRef(lazy = true)
//	@JsonIgnoreProperties(value ={"listadipendenti"})
//	@JsonManagedReference
//	private Ruolo ruolo;
	
	

//	public Progetto getProgetto() {
//		return progetto;
//	}
//
//	public void setProgetto(Progetto progetto) {
//		this.progetto = progetto;
//	}
//
//	public Ruolo getRuolo() {
//		return ruolo;
//	}
//
//	public void setRuolo(Ruolo ruolo) {
//		this.ruolo = ruolo;
//	}

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

	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}

	

	

}
