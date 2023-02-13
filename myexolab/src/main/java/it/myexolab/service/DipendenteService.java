package it.myexolab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import it.myexolab.model.AgeCount;
import it.myexolab.model.Dipendente;
import it.myexolab.repository.DipendenteRepository;

@Service
public class DipendenteService {
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	@Autowired 
	private MongoTemplate mongoTemplate; 

	public List<Dipendente> create (List<Dipendente> listaDipendenti){
		return dipendenteRepository.saveAll(listaDipendenti);
		
	}
	
	public Dipendente update(Dipendente dipendente) {
		return dipendenteRepository.save(dipendente);
	}
	
	
     public List<Dipendente> findAll(){
		return dipendenteRepository.findAll();
	}
	
	public List<Dipendente> findByName(String nome){
		 
//		Query query=new Query();
//		query.addCriteria(Criteria.where("nome").is(nome));
//		return mongoTemplate.find(query,Dipendente.class);
		return dipendenteRepository.findByNome(nome);
	}
	
     public List<Dipendente> findByRuolo(String ruolo){
		
//		Query query=new Query();
//		query.addCriteria(Criteria.where("ruolo").is(ruolo));
//		return mongoTemplate.find(query,Dipendente.class);
    	 return dipendenteRepository.findByRuolo(ruolo);
	}
     
    public  List<Dipendente> findByEtaAndCognome(int eta,String cognome){
    	return dipendenteRepository.findByEtaAndCognome(eta, cognome);
    }
    
    public List<Dipendente> findByCognome(String cognome){
    	return dipendenteRepository.findByCognome(cognome);
    	
    }
    
    public List<Dipendente> findDipendenteByEta(int min, int max){
    	return dipendenteRepository.findDipendenteByEta(min, max);
    }
    
    public List<Dipendente> findByRuoloOrderByNome(){
    	Sort sort= Sort.by(Sort.Direction.ASC, "nome");
    	return dipendenteRepository.findAll(sort);
    }
    
    public List<Dipendente> findByEtaMatch(int eta){
//    	Group
    	GroupOperation groupByEta= Aggregation.group("eta").count().as("count");
    	
//    	MatchOperation
    	MatchOperation matchOperation= Aggregation.match(new Criteria("count").is(eta));
    	
//    	SortOperation
    	SortOperation sortOperation= Aggregation.sort(Sort.by(Sort.Direction.ASC,"count"));
//    	Aggregation
    	Aggregation aggregation = Aggregation.newAggregation(groupByEta,matchOperation,sortOperation);
    	
        AggregationResults output= mongoTemplate.aggregate(aggregation,"dipendente", AgeCount.class);
        return output.getMappedResults();
    }
}
