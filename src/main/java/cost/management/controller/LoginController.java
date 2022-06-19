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
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/registration")
	public Utente addUtente(@Valid @RequestBody Utente utente)
	{
		Utente findUtente = loginService.finUtenteByEmail(utente.getEmail());
		if (findUtente==null) {		
			return loginService.addUtente(utente);
		}
		return null;
	}
	
	@PostMapping("/login")
	public boolean checkUtente(@Valid @RequestBody Utente utente)
	{
		Utente utenteReal = loginService.finUtenteByEmail(utente.getEmail());
		if (utenteReal == null) {
			return false;
		}
		if (utente.getPassword().equals(utenteReal.getPassword())) {
			return true;
		}
		return false;
	}

}
