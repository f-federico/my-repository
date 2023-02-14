package it.myexolab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.myexolab.model.Ruolo;
import it.myexolab.service.RuoloService;


@RestController
@RequestMapping("/ruolo")
@CrossOrigin
public class RuoloController {
	
	 @Autowired
	 private RuoloService ruoloService;
	 
	

}
