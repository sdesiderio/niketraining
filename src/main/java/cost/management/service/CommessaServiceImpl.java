package cost.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Commessa;
import cost.management.repository.CommessaRepository;
@Service
public class CommessaServiceImpl implements CommessaService {
	

	@Autowired
	private CommessaRepository commessaRepository;
	
	
	@Override
	public Commessa trovaCommessaPerCodice(String codice) {
		return commessaRepository.findByCodice(codice);
	}
	
	@Override
	public List<Commessa> trovaPerCodiceContenente(String codice) {
		return commessaRepository.findByCodiceContaining(codice);
	}
	
	
	@Override
	public List<Commessa> trovaTutteCommesse(){
		return commessaRepository.findAll();
	}
	
	@Override
	public List<Commessa> trovaPerDescrizioneCommessaContenente(String descrizioneCommessa){
		return commessaRepository.findByDescrizioneCommessaContaining(descrizioneCommessa);
	}
	
	@Override
	public List<Commessa> trovaPerTipologiaCommessaContenente(String tipologiaCommessa) {
			return commessaRepository.findByTipologiaCommessaContaining(tipologiaCommessa);
	
	}
	
	
	@Override
	public Commessa inserisciCommessa(Commessa commessa) {
		return commessaRepository.save(commessa);
	}
	
	
	@Override
	public Commessa aggiornaCommessa(Commessa commessa,String codice) {
		Commessa commessaToUpdate = trovaCommessaPerCodice(codice);
		commessaToUpdate.setCodice(commessa.getCodice());
		commessaToUpdate.setDescrizioneCommessa(commessa.getDescrizioneCommessa());
		commessaToUpdate.setImporto(commessa.getImporto());
		commessaToUpdate.setCliente(commessa.getCliente());
		commessaToUpdate.setTipologiaCommessa(commessa.getTipologiaCommessa());
		commessaToUpdate.setDataInizioCommessa(commessa.getDataInizioCommessa());
		commessaToUpdate.setDataFineCommessa(commessa.getDataFineCommessa());
		
		return commessaRepository.save(commessaToUpdate);
	}
	
	@Override
	public Commessa archiviaCommessa(String codice) {
		Commessa commessaToArchive = commessaRepository.findById(codice).get();
		commessaToArchive.setActive((byte) 0);
		return commessaRepository.save(commessaToArchive);
	}
	
	
	@Override
	public void eliminaCommessa(String id) {
		commessaRepository.deleteById(id);
	}


}
