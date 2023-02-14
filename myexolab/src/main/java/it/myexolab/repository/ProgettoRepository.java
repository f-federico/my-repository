package it.myexolab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.myexolab.model.Progetto;

@Repository
public interface ProgettoRepository extends MongoRepository<Progetto, String> {

	
}
