package it.myexolab.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.myexolab.model.Progetto;

@Repository
public interface ProgettoRepository extends MongoRepository<Progetto, String> {

//	@Query("listaDipendenti:{$elemMatch:{'nome'=1}}" )
//	List<Progetto> findAll();
	
	@Query("{cliente:?0,listaDipendenti:{$elemMatch:{nome:?1}}}")
	List<Progetto> findDipendentiByCliente( String cliente, String nome);
}
//@Query(value="{'eta':?0},{'cognome':?1}", fields="{'id':0}")