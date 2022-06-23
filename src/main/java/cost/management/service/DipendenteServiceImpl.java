package cost.management.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;
import cost.management.repository.AziendaRepository;
import cost.management.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	// inietta il repository nel service
	@Autowired
	private DipendenteRepository dipendenteRepository;

	@Autowired
	private AziendaRepository aziendaRepository;

	// aggiungi dipendente
	@Override
	public Dipendente inserisciDipendente(Dipendente dipendente, int id) {

		String message = "Dipendente NON INSERITO!!";
		String codiceFiscale = dipendente.getCodiceFiscale();
		Dipendente dipendenteFindByCF = dipendenteRepository.findByCodiceFiscale(codiceFiscale);
		if (dipendenteFindByCF == null) {
			Azienda azienda = aziendaRepository.findById(id).get();
			dipendente.setAzienda(azienda);
			dipendente.setCreateDate(new Date());

			try {
				return dipendenteRepository.save(dipendente);
			} catch (IllegalArgumentException ex) {
				log.info(message);
				ex.printStackTrace();
			}

		}
		System.out.println("RETURNING NULL");
		return null;
	}
	
	@Override
	public Dipendente aggiornaDipendente(Dipendente dipendente, String codiceFiscale, int aziendaId) {

		Dipendente vecchioDipendente = null;

		Optional<Dipendente> vecchioDipendenteTemp = dipendenteRepository.findById(codiceFiscale);

		if (vecchioDipendenteTemp.isPresent()) {
			vecchioDipendente = vecchioDipendenteTemp.get();

			//oldDipendente.setCodiceFiscale(dipendente.getCodiceFiscale());
			vecchioDipendente.setAzienda(dipendente.getAzienda());
			vecchioDipendente.setNome(dipendente.getNome());
			vecchioDipendente.setCognome(dipendente.getCognome());
			vecchioDipendente.setCellulare(dipendente.getCellulare());
			vecchioDipendente.setDataNascita(dipendente.getDataNascita());
			vecchioDipendente.setEmail(dipendente.getEmail());
			vecchioDipendente.setResidenza(dipendente.getResidenza());
			vecchioDipendente.setDomicilio(dipendente.getDomicilio());
			vecchioDipendente.setLuogoNascita(dipendente.getLuogoNascita());
			vecchioDipendente.setEmAziendale(dipendente.getEmAziendale());
			//System.out.println("*********** updated dipdendente " + oldDipendente + "**********************");
			Azienda azienda = aziendaRepository.findById(aziendaId).get();
			vecchioDipendente.setAzienda(azienda);
			System.out.println("UPDATING DIPENDENTE");
			return dipendenteRepository.save(vecchioDipendente);

		} else {
			log.info("*******Dipendente non trovato!!*****");
		}
		return null;

	}
	
	

	@Override
	public Optional<Dipendente> trovaDipendentePerCodiceFiscale(String codiceFiscale) {

		return dipendenteRepository.findById(codiceFiscale);
	}

	@Override
	public List<Dipendente> trovaTuttiDipendenti() {
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipendenteRepository.findAll();
		
		log.info("Lista " + listaDipendenti.size());
		
		//get age from data di nascita
		for(Dipendente dipendente : listaDipendenti) {
			//System.out.println( "DATA NASCITA CONTROLLER :" +dipendente.getDataNascita());
			
			LocalDate start = new java.sql.Date(dipendente.getDataNascita().getTime()).toLocalDate();
			LocalDate end = LocalDate.now(); 
			
			long years = ChronoUnit.YEARS.between(start, end);
			
			dipendente.setAge(years);
			log.info("Anni " + dipendente.getAge());
		}

		return listaDipendenti;
	}



	@Override
	public Dipendente archiviaDipendente(String codiceFiscale) {

		Dipendente dipendenteDaArchiviare = dipendenteRepository.findById(codiceFiscale).get();
		dipendenteDaArchiviare.setActive((byte) 0);
		return dipendenteRepository.save(dipendenteDaArchiviare);
	}
	


}
