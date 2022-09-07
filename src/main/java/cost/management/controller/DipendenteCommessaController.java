package cost.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.DipendenteCommessa;
import cost.management.service.DipendenteCommessaService;

@RestController
@RequestMapping("/api/dipendente-commessa-service")
@CrossOrigin(origins = "http://localhost:4200")
public class DipendenteCommessaController {

	@Autowired
	private DipendenteCommessaService dipendenteCommessaService;

	@PostMapping("/dipendenti-commesse/{commessaCodice}" )
	public DipendenteCommessa inserisciDipendenteCommessa(@RequestBody DipendenteCommessa dipendenteCommessa,
			@PathVariable String commessaCodice ) {
		
		dipendenteCommessa.getId().setCommessaCodice(commessaCodice);
		//@PathVariable String commessaCodice, @PathVariable String dipendenteCF
		//{commessaCodice}/{dipendenteCF}
		//DipendenteCommessa dipCommessa = new DipendenteCommessa();
		System.out.println("INSIDE CONTROLLER&&&&&&&&&&&&&&&&");
		//System.out.println("DIPENDENTE COMMESSA CODICE :"+ dipCommessa.getCommessa().getCodice() );
		//System.out.println("DIPEENDENTE COMMESSA DIPENDENTE :"+ dipCommessa.getDipendente().getCodiceFiscale());
		//System.out.println("DIP COMMESSA IMPORTO :");
		//System.out.println("DIP COMMESSA DATA INIZIO ATTIVITA :"+ dipCommessa.getDataInizioAttivita());
		//System.out.println("DIP COMMESSA DATA FINE ATTIVITA :"+ dipCommessa.getDataFineAttivita());
		System.out.println("ID  DIPENDENTE CF :"+ dipendenteCommessa.getId().getDipendenteCodiceFiscale());
		System.out.println( "tariffa gg :"+dipendenteCommessa.getTariffaGg());
		
		//String tariffaGg = Float.parseFloat(dipCommessa.getTariffaGg());
		//double tariffaGG = Double.parseDouble(dipCommessa.getTariffaGg());
		//System.out.println("OGGETTO DIPEDNETECOMEESSa id !@@@@@@: "+ dipCommessa.getId());
		//System.out.println("OGGETTO DIPEDNETECOMEESSa id -CODICE COMMESSA !@@@@@@: "+ dipCommessa.getId().getCommessaCodice());

		//System.out.println("OGGETTO DIPEDNETECOMEESSA ID - dipendente CF: "+ dipCommessa.getId().getDipendenteCodiceFiscale().toString());

		return dipendenteCommessaService.inserisciDipendenteCommessa(dipendenteCommessa);
	}
	
	@GetMapping("/dipendenti-commesse")
	public List<DipendenteCommessa> trovaTuttiDipendenteCommesse() {
		return dipendenteCommessaService.trovaTuttiDipendenteCommesse();
	}
}
