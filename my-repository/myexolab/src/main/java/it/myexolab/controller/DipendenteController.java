package it.myexolab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.myexolab.model.Dipendente;
import it.myexolab.repository.DipendenteRepository;
import it.myexolab.service.DipendenteService;

@RestController
@RequestMapping("/dipendente")
@CrossOrigin
public class DipendenteController {
	
	@Autowired
	private DipendenteService dipendenteService;
	
	
//	insertMany
	@PostMapping("/create")
	public List<Dipendente> create (@RequestBody List<Dipendente> listaDipendenti){
		return dipendenteService.create(listaDipendenti);
	}
	@PostMapping("/update")
	public Dipendente update(@RequestBody Dipendente dipendente) {
		return dipendenteService.update(dipendente);
	}
	
	@GetMapping("/findAll")
	public List<Dipendente> findAll(){
		return dipendenteService.findAll();
	}
	
	@GetMapping("/findByNome/{nome}")
	public List<Dipendente> findByName(@PathVariable(value="nome") String nome){
		return dipendenteService.findByName(nome);
	}
	
	@GetMapping("/findByRuolo/{ruolo}")
	public List<Dipendente> findByRuolo(@PathVariable(value="ruolo") String ruolo){
		return dipendenteService.findByRuolo(ruolo);
	}
	
	@GetMapping("/findByEtaAndCognome/{eta}/{cognome}")
	public List<Dipendente> findByEtaAndCognome(@PathVariable(value="eta") int eta,@PathVariable(value="cognome") String cognome){
		return dipendenteService.findByEtaAndCognome(eta, cognome);
		
	}
	@GetMapping("/findByCognome")
	public List<Dipendente> findByCognome(@RequestParam String cognome){
    	return dipendenteService.findByCognome(cognome);
    	
    }
	@GetMapping("/findDipendenteByEta")
	public List<Dipendente> findDipendenteByEta( @RequestParam int min, @RequestParam int max){
    	return  dipendenteService.findDipendenteByEta(min, max);
    }
	@GetMapping("/findByRuoloOrderByNome")
	public List<Dipendente> findByRuoloOrderByNome(){
    	return dipendenteService.findByRuoloOrderByNome();
    }
	
	@GetMapping("/findByEtaMatch/{eta}")
	public List<Dipendente> findByEtaMatch(@PathVariable(value="eta") int eta){
		return dipendenteService.findByEtaMatch(eta);
	}

}
