package it.myexolab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.myexolab.model.Progetto;
import it.myexolab.service.ProgettoService;

@RestController
@RequestMapping("/progetto")
@CrossOrigin
@Api("Gestisci i progetti")
public class ProgettoController {
	
	@Autowired
	private ProgettoService progettoService;
	
	@ApiOperation("Aggiungi progetto")
	@PostMapping("/create")
	public Progetto create ( @RequestBody Progetto progetto) {
		System.out.println(progetto);
		return progettoService.create(progetto);
	}
	@ApiOperation("Visualizza progetti esistenti")
	@GetMapping("/findAll")
	public List<Progetto> findAll(){
		return progettoService.findAll();
	}

}