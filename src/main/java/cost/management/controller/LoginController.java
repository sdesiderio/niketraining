package cost.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Utente;
import cost.management.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login-service")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/registrazioni")
	public Utente inserisciUtente(@Valid @RequestBody Utente utente)
	{
		Utente trovaUtente = loginService.trovaUtentePerEmail(utente.getEmail());
		if (trovaUtente==null) {		
			return loginService.inserisciUtente(utente);
		}
		return null;
	}
	
	@PostMapping("/login")
	public boolean verificaUtente(@Valid @RequestBody Utente utente)
	{
		Utente utenteReale = loginService.trovaUtentePerEmail(utente.getEmail());
		if (utenteReale == null) {
			return false;
		}
		if (utente.getPassword().equals(utenteReale.getPassword())) {
			return true;
		}
		return false;
	}

}
