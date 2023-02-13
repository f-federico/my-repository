package it.myexolab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.myexolab.model.Ruolo;

@Repository
public interface RuoloRepository extends MongoRepository<Ruolo, String> {

}
