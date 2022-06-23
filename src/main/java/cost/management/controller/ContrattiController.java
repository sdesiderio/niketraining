package cost.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Contratto;
import cost.management.entities.DatiContrattuali;
import cost.management.entities.Dipendente;
import cost.management.entities.TipologiaContratto;
import cost.management.service.ContrattoService;
import cost.management.service.DipendenteService;
import cost.management.service.TipologiaContrattoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contratto-service")
public class ContrattiController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DipendenteService dipendenteService;
	
	@Autowired
	private TipologiaContrattoService tipologiaContrattoService;
	
	@Autowired
	private ContrattoService contrattoService;
	
	@GetMapping("/daticontratti")
	public ArrayList<DatiContrattuali> RecuperaDatiContrattuali() {
		
		ArrayList<DatiContrattuali> listaDatiContrattuali = new ArrayList<DatiContrattuali>();
		
		List<TipologiaContratto> listaTipologieContratti = tipologiaContrattoService.trovaTuttiContratti();
		
		log.info("Tipologia Contratti " + listaTipologieContratti.size());
		
		List<Dipendente> listaDipendenti = dipendenteService.trovaTuttiDipendenti();
		
		log.info("Lista Dipendenti " + listaDipendenti.size());
		
		for (Dipendente dipendente : listaDipendenti) {
			listaDatiContrattuali.add(new DatiContrattuali(dipendente.getCodiceFiscale(),
					dipendente.getAzienda().getNome(),
					dipendente.getNome(),
					dipendente.getCognome(),
					listaTipologieContratti));
		}
		
		return listaDatiContrattuali;
		
	}
	
	@PostMapping("/insertcontratto")
	public Contratto inserisciContratto(@RequestBody Contratto contratto)
	{
		return contrattoService.inserisciContratto(contratto);
	}

}
