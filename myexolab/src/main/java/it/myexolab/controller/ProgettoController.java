package it.myexolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.myexolab.model.Progetto;
import it.myexolab.service.ProgettoService;

@RestController
@RequestMapping("/progetto")
@CrossOrigin
public class ProgettoController {
	
	@Autowired
	private ProgettoService progettoService;
	
	@PostMapping("/create")
	public Progetto create ( @RequestBody Progetto progetto) {
		System.out.println(progetto);
		return progettoService.create(progetto);
	}

}
