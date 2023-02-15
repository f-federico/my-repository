package it.myexolab.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="progetto")
public class Progetto {
    
	@Id
	private String id;
	
	@Field(name="tecnologia")
	private String tecnologia;
	
	@Field (name="cliente")
	private String cliente;
	
	private List<Dipendente> listaDipendenti;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}

	public void setListaDipendenti(List<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}

	@Override
	public String toString() {
		return "Progetto [id=" + id + ", tecnologia=" + tecnologia + ", cliente=" + cliente + ", listaDipendenti="
				+ listaDipendenti + "]";
	}
	
	
}
