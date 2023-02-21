package it.myexolab.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;


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
    
    public void deleteById(String id) {
    	dipendenteRepository.deleteById(id);
    }
    
    public Page<Dipendente> findDipendente(
    		 String nome,
    		 Integer min,
    		 Integer max,
    		 String cognome,
    		 Integer page,
    		 Integer dimensione
    		){
    	Pageable  pageable= PageRequest.of(page,dimensione);
    	Query query= new Query().with(pageable);
    	List<Criteria> criteria=new ArrayList<Criteria>();
    	if(nome!=null && !(nome.isEmpty())) {
//    		"i" è l'ption che consente l'ignorecase
    		criteria.add(Criteria.where("nome").regex(nome,"i"));
    	}
    	if(min!=null && max!= null) {
         criteria.add(Criteria.where("eta").gte(min).lte(max));
    	}
    	if(cognome!=null && !(cognome.isEmpty())) {
    		criteria.add(Criteria.where("cognome").is(cognome));
    	}
    	if(!(criteria.isEmpty())) {
    		query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
    	}
    	
    	Page<Dipendente> dipendenti = PageableExecutionUtils.getPage(mongoTemplate.find(query, Dipendente.class), pageable,(() -> mongoTemplate.count(query.skip(0).limit(0), Dipendente.class)));
    	return dipendenti;
    }
    
   
}
