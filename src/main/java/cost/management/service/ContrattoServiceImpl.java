package cost.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Contratto;
import cost.management.repository.ContrattoRepository;

@Service
public class ContrattoServiceImpl implements ContrattoService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ContrattoRepository contrattoRepository;
	
	@Override
	public Contratto inserisciContratto(Contratto contratto) {
		//log.info("CONTRATTOMESSAGGIO " +contratto.getTipologiaContrattoBean());
		return contrattoRepository.save(contratto);
	}
}
