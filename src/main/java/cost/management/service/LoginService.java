package cost.management.service;

import cost.management.entities.Utente;

public interface LoginService {

	Utente inserisciUtente(Utente utente);

	Utente trovaUtentePerEmail(String email);

}