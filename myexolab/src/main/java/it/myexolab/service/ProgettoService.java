package it.myexolab.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Service;

import it.myexolab.model.Dipendente;
import it.myexolab.model.Progetto;
import it.myexolab.repository.ProgettoRepository;

@Service
public class ProgettoService {
	
	@Autowired
	private ProgettoRepository progettoRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Progetto create(Progetto progetto) {
		return progettoRepository.save(progetto);
	}
	
	public List<Progetto> findAll(){
		List<Progetto> listaProg=progettoRepository.findAll();
		System.out.println(listaProg);
		return progettoRepository.findAll();
	}
	
	public List<Progetto> findDipendentiByCliente(String cliente, String nome){
		return progettoRepository.findDipendentiByCliente(cliente, nome);
	}
	
	public Progetto update (Progetto progetto) {
		return progettoRepository.save(progetto);
	}

	public void deleteById(String id) {
		progettoRepository.deleteById(id);
	}
	
	public List<Document> findLaPiùAnziana(){
		UnwindOperation unwindOperation = Aggregation.unwind("listaDipendenti");
	    
		SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "cognome");
	    
		GroupOperation groupOperation = Aggregation.group("listaDipendenti.cognome").first(Aggregation.ROOT).as("laPersonaPiuAnziana");   
	
//		ProjectionOperation projectionOperation = Aggregation.project().andExpression("laPersonaPiuAnziana.listaDipendenti").as("dipendente").andExclude("tecnologia").andExclude("cliente").andExclude("_id");                          
	    Aggregation aggregation= Aggregation.newAggregation(unwindOperation,groupOperation, sortOperation);
	
	   
	   List<Document> dipendenti= mongoTemplate.aggregate(aggregation,Progetto.class, Document.class).getMappedResults();
	
	   return dipendenti;
	}
}
