package it.myexolab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myexolab.model.Ruolo;
import it.myexolab.repository.RuoloRepository;

@Service
public class RuoloService {
	
	@Autowired
	private RuoloRepository ruoloRepository;

	
	public List<Ruolo> findAll(){
		return ruoloRepository.findAll();
	}
	
	public List<Ruolo> findDipendenteBySpecializzazione(String specializzazione){
		return ruoloRepository.findDipendenteBySpecializzazione(specializzazione);
	}
	
	public List<Ruolo> createAll(List<Ruolo> listaRuoli){
		return ruoloRepository.saveAll(listaRuoli);
	}
	
	public Ruolo update (Ruolo ruolo) {
		return ruoloRepository.save(ruolo);
	}
}
