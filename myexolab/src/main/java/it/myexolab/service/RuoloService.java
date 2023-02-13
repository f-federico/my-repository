package it.myexolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myexolab.repository.RuoloRepository;

@Service 
public class RuoloService {
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	

}
