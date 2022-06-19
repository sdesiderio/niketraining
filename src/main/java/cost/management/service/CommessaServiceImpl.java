package cost.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;
import cost.management.repository.CommessaRepository;
@Service
public class CommessaServiceImpl implements CommessaService {
	

	@Autowired
	private CommessaRepository commessaRepository;
	
	
	@Override
	public Commessa findByCodice(String codice) {
		return commessaRepository.findByCodice(codice);
	}
	
	@Override
	public List<Commessa> findByCodiceContaining(String codice) {
		return commessaRepository.findByCodiceContaining(codice);
	}
	
	
	@Override
	public List<Commessa> findAll(){
		return commessaRepository.findAll();
	}
	
	@Override
	public List<Commessa> findByDescrizioneCommessaContaining(String dc){
		return commessaRepository.findByDescrizioneCommessaContaining(dc);
	}
	
	@Override
	public List<Commessa> findByTipologiaCommessaContaining(String tc) {
			return commessaRepository.findByTipologiaCommessaContaining(tc);
	
	}
	
	
	@Override
	public Commessa addCommessa(Commessa com ) {
		
		
		
		return commessaRepository.save(com);
	}
	
	
	@Override
	public Commessa updateCommessa(Commessa com,String id) {
		com.setCodice(id);
		return commessaRepository.save(com);
	}
	
	
	@Override
	public Commessa archiveCommessa(String codice) {
		Commessa commessaToArchive = commessaRepository.findById(codice).get();
		commessaToArchive.setActive((byte) 0);
		return commessaRepository.save(commessaToArchive);
	}


}
