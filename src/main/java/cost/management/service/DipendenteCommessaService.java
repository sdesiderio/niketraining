package cost.management.service;

import java.util.List;

import cost.management.entities.DipendenteCommessa;

public interface DipendenteCommessaService {


	DipendenteCommessa inserisciDipendenteCommessa(DipendenteCommessa dipendenteCommessa);
	
	List<DipendenteCommessa> trovaTuttiDipendenteCommesse();

}