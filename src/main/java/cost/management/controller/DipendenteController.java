package cost.management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/dipendente-service")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class DipendenteController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DipendenteService dipendenteService;
	
	
	
	// inserici un dipendente nel db
	@PostMapping("/dipendenti/{id}")
	public Dipendente inserisciDipendente(@Valid @RequestBody Dipendente dipendente,
			@PathVariable String id) { 
		return dipendenteService.inserisciDipendente(dipendente, Integer.parseInt(id));

	}


	// trova tutti i dipendenti
	@GetMapping("/dipendenti")
	public List<Dipendente> trovaTuttiDipendenti() {
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipendenteService.trovaTuttiDipendenti();
		log.info("Lista2 " + listaDipendenti.size());
		return listaDipendenti;
	}

	// find dipendente by codice fiscale
	@GetMapping("/dipendenti/{codiceFiscale}")
	public Optional<Dipendente> trovaDipendentePerCodiceFiscale(@PathVariable String codiceFiscale) {
		return dipendenteService.trovaDipendentePerCodiceFiscale(codiceFiscale);
	}

	//update un dipendente
	@PutMapping("/dipendenti/{codiceFiscale}/{aziendaId}")
	public Dipendente aggiornaDipendente(@RequestBody Dipendente dipendente, 
			@PathVariable String codiceFiscale, @PathVariable int aziendaId) {
		//System.out.println("INSIDE UPDATE METHOD CONTROLLER");
		//System.out.println("CODICE FISCALE :"+ codiceFiscale +"AZIENDAID :"+ aziendaId);
		return dipendenteService.aggiornaDipendente(dipendente, codiceFiscale,aziendaId);
	}

	//delete un dipendente
	@PutMapping("/dipendenti/{codiceFiscale}")
	public Dipendente archiviaDipendente(@PathVariable String codiceFiscale) {
		
		return dipendenteService.archiviaDipendente(codiceFiscale);
		
		
	}

}
