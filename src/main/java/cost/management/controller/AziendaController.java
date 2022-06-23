package cost.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Azienda;
import cost.management.service.AziendaService;

@RestController
@RequestMapping("/api/azienda-service")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class AziendaController {
	
	@Autowired
	private AziendaService aziendaService;
	
	@Value("${azienda.name}")
	private String nomeAzienda;
	
	
	@GetMapping("/aziende")
	public List<Azienda> trovaTutteAziende(){
		System.out.println("INSIDE TEST CONTROLLER FIND ALL AZIENDE");
		List<Azienda> listaAziende = new ArrayList<Azienda>();
		listaAziende = aziendaService.trovaTutteAziende();
		System.out.println("AZIENDE: " +listaAziende.toString());
		return listaAziende;
	}
	
	@GetMapping("/aziende/nome")
	public Azienda trovaAziendaPerId() {
		System.out.println("INSIDE TEST CONTROLLER FIND  AZIENDE BY NOME");
		return aziendaService.trovaAziendaPerId(nomeAzienda);
		
	}
	
	@GetMapping("/aziende/{aziendaNome}")
	public Azienda trovaAziendaPerNome(@PathVariable String aziendaNome) {
		//System.out.println("RETURN AZIENDA OBJ BACK END :" + aziendaService.findAziendaById(id));
		//System.out.println("INSIDE FIND BY ID");
		return aziendaService.trovaAziendaPerNome(aziendaNome);
		
	}
	
	
	
	

}
