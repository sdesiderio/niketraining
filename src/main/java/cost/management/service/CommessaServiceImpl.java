package cost.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;
import cost.management.entities.Dipendente;
import cost.management.entities.DipendenteCommessa;
import cost.management.repository.CommessaRepository;
import cost.management.repository.DipendenteRepository;
@Service
public class CommessaServiceImpl implements CommessaService {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommessaRepository commessaRepository;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	
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
		List<Commessa> commesse = commessaRepository.findAll();
		System.out.println("COMMESSE!" + commesse);
		return commesse;
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

	
	@Override
	public List<String> trovaDipendentiPerCommessa(Commessa commessa) {
		Dipendente dipendente = null;
		String nominativo = null;
		List<String> nominativi = new ArrayList<>();
		List<DipendenteCommessa> dipendentiCommessa = new ArrayList<>();
		dipendentiCommessa = commessa.getDipendenteCommesse();
		if (dipendentiCommessa != null) {
			for (DipendenteCommessa dipendenteCommessa : dipendentiCommessa) {
				dipendente = dipendenteRepository
						.findByCodiceFiscale(dipendenteCommessa.getId().getDipendenteCodiceFiscale());
				nominativo = " " + dipendente.getNome() + " " + dipendente.getCognome();
				nominativi.add(nominativo);
			}
		} else {
			nominativi = null;
		}
		return nominativi;
	}

	@Override
	public List<Commessa> trovaCommessaPerCliente(Cliente cliente) {
		List<Commessa> commesse = new ArrayList<>();
		commesse = commessaRepository.findByCliente(cliente);
		return commesse;
	}

	@Override
	public List<Commessa> trovaCommessaPerCliente(Cliente cliente, String nominativo) {
		List<Commessa> commesse = new ArrayList<>();
		List<Commessa> commesseFinale = new ArrayList<>();
		List<DipendenteCommessa> dipendenteCommesse = new ArrayList<>();
		Dipendente dipendente = null;
		String dipendenteNominativo = null;
		commesse = commessaRepository.findByCliente(cliente);
		for (Commessa commessa: commesse) {
			dipendenteCommesse = commessa.getDipendenteCommesse();
			if(!dipendenteCommesse.isEmpty()) {
				for (DipendenteCommessa dipendenteCommessa: dipendenteCommesse) {
					dipendente = dipendenteCommessa.getDipendente();
					dipendenteNominativo = dipendente.getNome() + " " + dipendente.getCognome();
					if (dipendenteNominativo.equals(nominativo)) {
						commesseFinale.add(commessa);
					}
				}
			}
		}
		
		return commesseFinale;
	}

	@Override
	public List<Commessa> trovaCommessaPerDataFineCommessaAttuali() {
		List<Commessa> commesse = new ArrayList<>();
		Date date = new Date();
		commesse = commessaRepository.findByDataFineCommessaAfter(date);
		return commesse;
	}
	
	@Override
	public List<Commessa> trovaCommessaPerDataFineCommessaStorico() {
		List<Commessa> commesse = new ArrayList<>();
		Date date = new Date();
		commesse = commessaRepository.findByDataFineCommessaBefore(date);
		return commesse;
	}
	
	@Override
	public List<Commessa> confrontaCommessaPerDataFineCommessaAttuali(Commessa commessa) {
		List<Commessa> commesse = new ArrayList<>();
		if (commessa.getDataFineCommessa() != null) {
			Date dataFineCommessa = commessa.getDataFineCommessa();
			Date date = new Date();

			if (dataFineCommessa.after(date)) {
				commesse.add(commessa);
			}
		} else {
			commesse.add(commessa);
		}
		return commesse;
	}
	
	@Override
	public List<Commessa> confrontaCommessaPerDataFineCommessaStorico(Commessa commessa) {
		List<Commessa> commesse = new ArrayList<>();
		if (commessa.getDataFineCommessa() != null) {
			Date dataFineCommessa = commessa.getDataFineCommessa();
			Date date = new Date();

			if (dataFineCommessa.before(date)) {
				commesse.add(commessa);
			}
		}
		return commesse;
	}

}
