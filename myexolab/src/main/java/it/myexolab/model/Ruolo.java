package it.myexolab.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@Builder
@Document(collection="ruolo")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ruolo {
	
	@Id
	private String id;
	@Field (name="specializzazione")
	private String specializzazione;
	@DBRef (lazy=true)
//	@JsonBackReference
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
	
	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", specializzazione=" + specializzazione + ", listaDipendenti=" + listaDipendenti
				+ "]";
	}
	

}
