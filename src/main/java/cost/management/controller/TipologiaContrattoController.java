package cost.management.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.TipologiaContratto;
import cost.management.entities.Utente;
import cost.management.service.TipologiaContrattoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tipologia-contratto-service")
public class TipologiaContrattoController {
	
	@Autowired
	private TipologiaContrattoService tipologiaContrattoService;
	
	@PostMapping("/tipologie-contratto")
	public boolean inserisciTipologiaContatto(@RequestBody TipologiaContratto contratto)
	{
		//DONE  controllo se tipologia di contratto gia esiste su db (con findALL)  return boolean
		List<TipologiaContratto> contratti = tipologiaContrattoService.trovaTuttiContratti();
		for (TipologiaContratto tipologiaContratto : contratti) {
			if (tipologiaContratto.getTipologia().equals(contratto.getTipologia())) {
				return false;
			}
		}
		tipologiaContrattoService.inserisciTipologiaContatto(contratto);
		return true;
	}

	
	@GetMapping("/tipologie-contratto")
	public List<TipologiaContratto> findAllTipologiaContrattos()
	{
		return tipologiaContrattoService.trovaTuttiContratti();
	}

}
