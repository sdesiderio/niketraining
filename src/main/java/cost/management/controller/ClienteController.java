package cost.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import cost.management.entities.Cliente;
import cost.management.service.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/api/cliente-service")
//@Validated
public class ClienteController {
	Logger logger=LogManager.getLogger(ClienteController.class);
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clienti/{partitaIva}")
	public Cliente trovaPerPartitaIva(@Valid @PathVariable String partitaIva) {
		return clienteService.trovaPerPartitaIva(partitaIva);
	}
	@GetMapping("/clienti/partita-iva/{partitaIva}")
	public List<Cliente> trovaPerPartitaIvaContenente(@PathVariable String partitaIva) {
		
		List<Cliente> listaClienti=clienteService.trovaPerPartitaIvaContenente(partitaIva);
		logger.info("--------calledgetpi  "+listaClienti.size());
		return clienteService.trovaPerPartitaIvaContenente(partitaIva);
	}
	@GetMapping("/clienti/codice-fiscale/{codiceFiscale}")
	public List<Cliente> trovaPerCodiceFiscaleContenente(@PathVariable String codiceFiscale) {
		return clienteService.trovaPerCodiceFiscaleContenente(codiceFiscale);
	}
	
	@GetMapping("/clienti/codice-interscambio/{codiceInterscambio}")
	public List<Cliente> trovaPerCodiceInterscambioContenente(@PathVariable String codiceInterscambio) {
		return clienteService.trovaPerCodiceInterscambioContenente(codiceInterscambio);
	}
	@GetMapping("/clienti/pec/{pec}")
	public List<Cliente> trovaPerPecContenente(@PathVariable String pec) {
		return clienteService.trovaPerPecContenente(pec);
	}
	
	@GetMapping("/clienti/ragione-sociale/{ragioneSociale}")
	public List<Cliente> trovaPerRagioneSocialeContenente(@PathVariable String ragioneSociale) {
		return clienteService.trovaPerRagioneSocialeContenente(ragioneSociale);
	}
	@GetMapping("/clienti")
	public List<Cliente> trovaTutti(){
		logger.info("----------lista");
		return clienteService.trovaTuttiClienti();	
	}
	
	@PostMapping("/clienti")
	public Cliente inserisciCliente(@Valid @RequestBody Cliente cliente) {
		logger.info("----------add");
		return clienteService.inserisciCliente(cliente);
	}
	
	@PutMapping("/clienti/{partitaIva}")
	public Cliente aggiornaCliente(@Valid @RequestBody Cliente cliente,@PathVariable String partitaIva) {
		return clienteService.aggiornaCliente(cliente,partitaIva);
	}
		
	@PutMapping("/clienti/archivia/{partitaIva}")
	public Cliente archiviaCliente(@Valid @PathVariable String partitaIva) {
		return clienteService.archiviaCliente(partitaIva);
	}
}
