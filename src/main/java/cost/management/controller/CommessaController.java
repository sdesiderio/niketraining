	package cost.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;
import cost.management.service.CommessaService;

@RestController
@RequestMapping("/api/commessa-service")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class CommessaController {

	
	
	@Autowired
	private CommessaService commessaService;
	
	@PostMapping("/commesse")
	private Commessa inserisciCommessa(@RequestBody Commessa commessa) {
		System.out.println("###### INSIDE COMMESSE CONTROLLER");
		System.out.println(commessa.getDescrizioneCommessa());
		System.out.println(commessa.getCodice());

		System.out.println(commessa.getTipologiaCommessa());

		System.out.println(commessa.getDataInizioCommessa());
		System.out.println(commessa.getDataFineCommessa());
		System.out.println(commessa.getCliente());


		return commessaService.inserisciCommessa(commessa);
		
	}
	
	@GetMapping("/commesse")
	public List<Commessa> trovaTutteCommesse() {
		System.out.println("INSIDE FIND ALL COMMESSE");
		return commessaService.trovaTutteCommesse();
	}
	
	@GetMapping("/commesse/{codice}")
	public Commessa trovaCommessaPerCodice(@PathVariable String codice) {
		return commessaService.trovaCommessaPerCodice(codice);
		
	}
	
	@GetMapping("/commesse/codice/{codice}")
	public List<Commessa> trovaPerCodiceContenente(@PathVariable String codice) {
		return commessaService.trovaPerCodiceContenente(codice);
	}
	@GetMapping("/commesse/descrizione-commessa/{descrizioneCommessa}")
	public List<Commessa> trovaPerDescrizioneCommessaContenente(@PathVariable String descrizioneCommessa) {
		return commessaService.trovaPerDescrizioneCommessaContenente(descrizioneCommessa);
	}
	
	@GetMapping("/commesse/tipologia-contratto/{tipologiaContratto}")
	public List<Commessa> trovaPerTipologiaCommessaContenente(@PathVariable String tipologiaContratto) {
		return commessaService.trovaPerTipologiaCommessaContenente(tipologiaContratto);
	}
	@PutMapping("/commesse/archivia/{codice}")
	public Commessa archiviaCommessa(@PathVariable String codice) {
		return commessaService.archiviaCommessa(codice);
	}
	
	@PutMapping("/commesse/{codice}")
	public Commessa aggiornaCommessa(@RequestBody Commessa com,@PathVariable String codice) {
		return commessaService.aggiornaCommessa(com, codice);
		
	}
	
	@DeleteMapping("/commesse/{codice}")
	public void eliminaCommessa(@PathVariable String codice) {
		commessaService.eliminaCommessa(codice);
		
	}
	
	@PostMapping("/commesse-dipendenti")
	public List<String> trovaDipendentiPerCommessa(@RequestBody Commessa commessa){
		return commessaService.trovaDipendentiPerCommessa(commessa);
	}
	
	@PostMapping("/commesse-clienti")
	public List<Commessa> trovaCommessaPerCliente(@RequestBody Cliente cliente){
		return commessaService.trovaCommessaPerCliente(cliente);
	}
	
	@PostMapping("/commesse-clienti/{nominativo}")
	public List<Commessa> trovaCommessaPerClienteNominativo(@RequestBody Cliente cliente,@PathVariable String nominativo){
		return commessaService.trovaCommessaPerCliente(cliente,nominativo);
	}
	
	@PostMapping("/commesse-attuali")
	public List<Commessa> confrontaCommessaPerDataFineCommessaAttuali(@RequestBody Commessa commessa){
		return commessaService.confrontaCommessaPerDataFineCommessaAttuali(commessa);
	}
	
	@PostMapping("/commesse-storico")
	public List<Commessa> confrontaCommessaPerDataFineCommessaStorico(@RequestBody Commessa commessa){
		return commessaService.confrontaCommessaPerDataFineCommessaStorico(commessa);
	}
	}
