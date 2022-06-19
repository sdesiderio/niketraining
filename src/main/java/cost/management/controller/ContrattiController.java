package cost.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
@RequestMapping("/api")
public class ContrattiController {
	
	@Autowired
	private DipendenteService dipendenteService;
	
	@Autowired
	private TipologiaContrattoService tipologiaContrattoService;
	
	@Autowired
	private ContrattoService contrattoService;
	
	@GetMapping("/daticontratti")
	public ArrayList<DatiContrattuali> getDatiContrattuali() {
		
		ArrayList<DatiContrattuali> daticontrattuali = new ArrayList<DatiContrattuali>();
		
		List<TipologiaContratto> tipologiecontratti = tipologiaContrattoService.findAllContratto();
		
		List<Dipendente> dipendentes = dipendenteService.findAllDipendentes();
		
		for (Dipendente dipendente : dipendentes) {
			daticontrattuali.add(new DatiContrattuali(dipendente.getCodiceFiscale(),
					dipendente.getAzienda().getNome(),
					dipendente.getNome(),
					dipendente.getCognome(),
					tipologiecontratti));
		}
		
		return daticontrattuali;
		
	}
	
	@PostMapping("/insertcontratto")
	public Contratto addConratto(@RequestBody Contratto contratto)
	{
		return contrattoService.addContratto(contratto);
	}

}
