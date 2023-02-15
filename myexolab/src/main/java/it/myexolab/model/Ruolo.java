package it.myexolab.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="ruolo")
public class Ruolo {
	
	@Id
	private String id;
	
	@Field (name="specializzazione")
	private String specializzazione;
	
	private List<Dipendente> listaDipendenti;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public List<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}

	public void setListaDipendenti(List<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
	
	

}
