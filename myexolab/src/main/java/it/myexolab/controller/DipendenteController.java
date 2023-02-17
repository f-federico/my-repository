package it.myexolab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin("*")
public class DipendenteController {
	
	@Autowired
	private DipendenteService dipendenteService;
	
	List<Dipendente> listaDip=new ArrayList<Dipendente>();
	Dipendente dip= new Dipendente();
	
	
//	insertMany
	@PostMapping("/create")
	public ResponseEntity<List<Dipendente>> create (@RequestBody List<Dipendente> listaDipendenti){
		try {
			listaDip=dipendenteService.create(listaDipendenti);
			return ResponseEntity.ok(listaDip);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
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
	
	@DeleteMapping("/delete")
	public String deleteById (@RequestParam String id) {
		dipendenteService.deleteById(id);
		return "Eliminazione avvenuta con successo";
	}
	
	@GetMapping("/pagina")
	public Page<Dipendente> findDipendente(
    		@RequestParam(required= false) String nome,
    		@RequestParam(required = false) Integer min,
    		@RequestParam(required= false) Integer max,
    		@RequestParam(required= false) String cognome,
    		@RequestParam(defaultValue= "0") Integer page,
    		@RequestParam(defaultValue= "3") Integer dimensione
    		){
		return dipendenteService.findDipendente(nome, min, max, cognome, page, dimensione);
	}

}
