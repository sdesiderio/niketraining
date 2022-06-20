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
@RequestMapping("/api")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class CommessaController {

	
	
	@Autowired
	private CommessaService commessaService;
	
	@PostMapping("/commesse")
	private Commessa addCommessa(@RequestBody Commessa commessa) {
		System.out.println("###### INSIDE COMMESSE CONTROLLER");
		System.out.println(commessa.getDescrizioneCommessa());
		System.out.println(commessa.getCodice());

		System.out.println(commessa.getTipologiaCommessa());

		System.out.println(commessa.getDataInizioCommessa());
		System.out.println(commessa.getDataFineCommessa());
		System.out.println(commessa.getCliente());


		return commessaService.addCommessa(commessa);
		
	}
	
	@GetMapping("/commesse")
	public List<Commessa> findAllCommesse() {
		System.out.println("INSIDE FIND ALL COMMESSE");
		return commessaService.findAll();
	}
	@PutMapping("/commesse/{codice}")
	public Commessa archiveCommessa(@PathVariable String codice) {
		return commessaService.archiveCommessa(codice);
	}
	
	@DeleteMapping("/commesse/{codice}")
	public void deleteCommessa(@PathVariable String codice) {
		commessaService.deleteCommessa(codice);
		
	}
}
