package cost.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Contratto;
import cost.management.repository.ContrattoRepository;

@Service
public class ContrattoServiceImpl implements ContrattoService {

	@Autowired
	private ContrattoRepository contrattoRepository;
	
	@Override
	public Contratto inserisciContratto(Contratto contratto) {
		return contrattoRepository.save(contratto);
	}
}
