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
@RequestMapping("/api")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class AziendaController {
	
	@Autowired
	private AziendaService aziendaService;
	
	@Value("${azienda.name}")
	private String nomeAzienda;
	
	
	@GetMapping("/aziende")
	public List<Azienda> findAllAziende(){
		System.out.println("INSIDE TEST CONTROLLER FIND ALL AZIENDE");
		List<Azienda> aziende = new ArrayList<Azienda>();
		aziende = aziendaService.findAllAziende();
		System.out.println("AZIENDE: " +aziende.toString());
		return aziende;
	}
	
	@GetMapping("/aziende/nome")
	public Azienda findAziendaByName() {
		System.out.println("INSIDE TEST CONTROLLER FIND  AZIENDE BY NOME");
		return aziendaService.findAziendaByNome(nomeAzienda);
		
	}
	
	@GetMapping("/aziende/{id}")
	public Azienda findAziendaById(@PathVariable String id) {
		//System.out.println("RETURN AZIENDA OBJ BACK END :" + aziendaService.findAziendaById(id));
		//System.out.println("INSIDE FIND BY ID");
		return aziendaService.findAziendaById(id);
		
	}
	
	
	
	

}
