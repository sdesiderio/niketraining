package cost.management.service;

import java.util.List;

import cost.management.entities.TipologiaContratto;

public interface TipologiaContrattoService {

	TipologiaContratto inserisciTipologiaContatto(TipologiaContratto contratto);
	
	List<TipologiaContratto> trovaTuttiContratti();
}