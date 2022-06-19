package cost.management.service;

import java.util.List;

import cost.management.entities.Azienda;

public interface AziendaService {

	List<Azienda> findAllAziende();

	Azienda findAziendaById(String id);

	Azienda findAziendaByNome(String aziendaNome);

}