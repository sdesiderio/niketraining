package cost.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Utente;
import cost.management.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Utente addUtente(Utente utente) {
		return loginRepository.save(utente);
	}
	
	@Override
	public Utente finUtenteByEmail(String email) {
		Optional<Utente> utenteOptional = loginRepository.findById(email);
		if (utenteOptional.isPresent()) {
			return utenteOptional.get();
		}
		return null;
	}

}
