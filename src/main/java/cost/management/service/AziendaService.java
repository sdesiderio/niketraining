package cost.management.service;

import java.util.List;

import cost.management.entities.Azienda;

public interface AziendaService {

	List<Azienda> trovaTutteAziende();

	Azienda trovaAziendaPerId(String id);

	Azienda trovaAziendaPerNome(String aziendaNome);

}