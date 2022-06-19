package cost.management.service;

import cost.management.entities.Utente;

public interface LoginService {

	Utente addUtente(Utente utente);

	Utente finUtenteByEmail(String email);

}