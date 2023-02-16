package it.myexolab.service;

import java.util.List;

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
}
