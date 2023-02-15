package it.myexolab.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.myexolab.model.Ruolo;

@Repository
public interface RuoloRepository extends MongoRepository<Ruolo, String> {

	@Query("specializzazione:?0")
	List<Ruolo> findDipendenteBySpecializzazione(String specializzazione);
	
	
		
	
	
}
