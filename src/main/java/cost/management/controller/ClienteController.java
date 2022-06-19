package cost.management.controller;

import java.util.List;

import javax.validation.Valid;

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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import cost.management.entities.Cliente;
import cost.management.service.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/api")
//@Validated
public class ClienteController {
	Logger logger=LogManager.getLogger(ClienteController.class);
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clienti/{partitaIva}")
	public Cliente findByPartitaIva(@Valid @PathVariable String partitaIva) {
		return clienteService.findByPartitaIva(partitaIva);
	}
	@GetMapping("/clienti/pi/{pi}")
	public List<Cliente> findByPartitaIvaContaining(@PathVariable String pi) {
		
		List<Cliente> list=clienteService.findByPartitaIvaContaining(pi);
		logger.info("--------calledgetpi  "+list.size());
		return clienteService.findByPartitaIvaContaining(pi);
	}
	@GetMapping("/clienti/cf/{cf}")
	public List<Cliente> findByCodiceFiscaleContaining(@PathVariable String cf) {
		return clienteService.findByCodiceFiscaleContaining(cf);
	}
	
	@GetMapping("/clienti/ci/{ci}")
	public List<Cliente> findByCodiceInterscambioContaining(@PathVariable String ci) {
		return clienteService.findByCodiceInterscambioContaining(ci);
	}
	@GetMapping("/clienti/pec/{pec}")
	public List<Cliente> findByPecContaining(@PathVariable String pec) {
		return clienteService.findByPecContaining(pec);
	}
	
	@GetMapping("/clienti/rs/{rs}")
	public List<Cliente> findByRagioneSocialeContaining(@PathVariable String rs) {
		return clienteService.findByRagioneSocialeContaining(rs);
	}
	@GetMapping("/clienti")
	public List<Cliente> findAll(){
		logger.info("----------lista");
		return clienteService.findAll();	
	}
	
	@PostMapping("/clienti")
	public Cliente addCliente(@Valid @RequestBody Cliente cli) {
		logger.info("----------add");
		return clienteService.addCliente(cli);
	}
	
	@PutMapping("/clienti/{partitaIva}")
	public Cliente updateCliente(@Valid @RequestBody Cliente cli,@PathVariable String partitaIva) {
		return clienteService.updateCliente(cli,partitaIva);
	}
		
	@PutMapping("/clientiToArchive/{partitaIva}")
	public Cliente archiveCliente(@Valid @PathVariable String partitaIva) {
		return clienteService.archiveCliente(partitaIva);
	}
}
