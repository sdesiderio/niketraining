package cost.management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Dipendente;
import cost.management.service.DipendenteService;

@RestController
@RequestMapping("/api")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class DipendenteController {

	@Autowired
	private DipendenteService dipService;
	
	
	
	// inserici un dipendente nel db
	@PostMapping("/dipendenti/{id}")
	public Dipendente addDipendente(@Valid @RequestBody Dipendente dipendente,
			@PathVariable String id) { 
		return dipService.addDipendente(dipendente, Integer.parseInt(id));

	}


	// trova tutti i dipendenti
	@GetMapping("/dipendenti")
	public List<Dipendente> findAllDipendenti() {
		System.out.println("find all dimpendenti VACALLED");
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipService.findAllDipendenti();
		return listaDipendenti;
	}

	// find dipendente by codice fiscale
	@GetMapping("/dipendenti/{codiceFiscale}")
	public Optional<Dipendente> findDipendenteByCodiceFiscale(@PathVariable String codiceFiscale) {
		return dipService.findDipendenteByCodiceFiscale(codiceFiscale);
	}

	//update un dipendente
	@PutMapping("/dipendenti/{codiceFiscale}/{aziendaId}")
	public Dipendente updateDipendente(@RequestBody Dipendente dipendente, 
			@PathVariable String codiceFiscale, @PathVariable int aziendaId) {
		//System.out.println("INSIDE UPDATE METHOD CONTROLLER");
		//System.out.println("CODICE FISCALE :"+ codiceFiscale +"AZIENDAID :"+ aziendaId);
		return dipService.updateDipendente(dipendente, codiceFiscale,aziendaId);
	}

	//delete un dipendente
	@PutMapping("/dipendenti/{codiceFiscale}")
	public Dipendente archiveDipendente(@PathVariable String codiceFiscale) {
		
		return dipService.archiveDipendente(codiceFiscale);
		
		
	}

}
