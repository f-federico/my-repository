package it.myexolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myexolab.model.Progetto;
import it.myexolab.repository.ProgettoRepository;

@Service
public class ProgettoService {
	
	@Autowired
	private ProgettoRepository progettoRepository;
	
	public Progetto create(Progetto progetto) {
		return progettoRepository.save(progetto);
	}

}
