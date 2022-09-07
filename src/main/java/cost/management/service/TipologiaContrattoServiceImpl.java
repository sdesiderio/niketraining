package cost.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.TipologiaContratto;
import cost.management.repository.TipologiaContrattoRepository;

@Service
public class TipologiaContrattoServiceImpl implements TipologiaContrattoService {
	
	@Autowired
	private TipologiaContrattoRepository tipologiaContrattoRepository;
	
	@Override
	public TipologiaContratto inserisciTipologiaContratto(TipologiaContratto contratto) {
		return tipologiaContrattoRepository.save(contratto);
	}
	
	@Override
	public List<TipologiaContratto> trovaTuttiContratti() {
		return tipologiaContrattoRepository.findAll();
	}

}
