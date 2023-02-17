package it.myexolab.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.myexolab.model.Dipendente;

@Repository
public interface DipendenteRepository extends MongoRepository<Dipendente,String>{

	
	
	@Query("{'nome':?0}")
	List<Dipendente> findByNome(String nome);
	
	@Query("{'ruolo':?0}")
	List<Dipendente> findByRuolo(String ruolo);
//	case insensitive
	@Query("{'$regex':?0,'$options':'i'}")
	List<Dipendente> findByCognome(String cognome);
	
	@Query(value="{'eta':?0},{'cognome':?1}", fields="{'id':0}")
	List<Dipendente> findByEtaAndCognome(int eta, String cognome);
	
	@Query("{'eta':{'$gte':?0,'$lte':?1}}")
	List<Dipendente> findDipendenteByEta(int min, int max);
	
//	List<Dipendente> findByRuoloOrderByNome();
	
}
