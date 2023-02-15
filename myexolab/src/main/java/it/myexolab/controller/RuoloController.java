package it.myexolab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.myexolab.model.Ruolo;
import it.myexolab.service.RuoloService;


@RestController
@RequestMapping("/ruolo")
@CrossOrigin
@Api("Gestisci i progetti")
public class RuoloController {
	
	 @Autowired
	 private RuoloService ruoloService;
	 
	 @ApiOperation("Specializzazioni presenti in azienda")
	 @GetMapping("/findAll")
	 public List<Ruolo> findAll(){
		 return ruoloService.findAll();
	 }
	 
	 @GetMapping("/findBySpecializzazione")
	 public List<Ruolo> findBySpecializzazione(@RequestParam String specializzazione){
		 return ruoloService.findDipendenteBySpecializzazione(specializzazione);
	 }
	 
	 @PostMapping("/createAll")
	 public List<Ruolo> createAll(@RequestBody List<Ruolo> listaRuoli){
		 return ruoloService.createAll(listaRuoli);
	 }
	
	 @PostMapping("/update")
	 public Ruolo update (@RequestBody Ruolo ruolo) {
		 return ruoloService.update(ruolo);
	 }

}
