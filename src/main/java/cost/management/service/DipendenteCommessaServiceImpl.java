package cost.management.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Azienda;
import cost.management.entities.Commessa;
import cost.management.entities.Dipendente;
import cost.management.entities.DipendenteCommessa;
import cost.management.repository.CommessaRepository;
import cost.management.repository.DipendenteCommessaRepository;
import cost.management.repository.DipendenteRepository;

@Service
public class DipendenteCommessaServiceImpl implements DipendenteCommessaService {
	
	@Autowired
	private DipendenteCommessaRepository dipendenteCommessaRepository;
	
	@Autowired
	private CommessaRepository commessaRepository;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	
	public DipendenteCommessa inserisciDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {

		System.out.println("FULL OBJ :" + dipendenteCommessa.toString());
		//System.out.println("IMPORTO :"+ importo);
		//Commessa commessa = commessaRepo.findById(dipendenteCommessa.getId().getCommessaCodice()).get();
		//commessa.setImporto(importo);
		//commessaRepo.save(commessa);
		//Commessa dipendenteFindByCF = commessaRepo.findByCodice(dipendenteCommessa.getId().getDipendenteCodiceFiscale());
		//Commessa commessaFindByCodice = commessaRepo.findByCodice(dipendenteCommessa.getId().getCommessaCodice());
		//Dipendente dipendenteFindByCF = dipRepo.findByCodiceFiscale(dipendenteCommessa.getId().getDipendenteCodiceFiscale());
		/*if (dipendenteFindByCF == null && (commessaFindByCodice == null || (commessaFindByCodice.getTipologiaCommessa() == "Produzione" 
				&& commessaFindByCodice.getTipologiaCommessa()=="Time Material")))*/
		//System.out.println(dipendenteCommessa.getId().toString());
		String dipendenteCodiceFiscale = dipendenteCommessaRepository.findCF(dipendenteCommessa.getId().getDipendenteCodiceFiscale(),dipendenteCommessa.getId().getCommessaCodice() );
		//if (dipendenteFindByCF.getCodiceFiscale() != dipendenteCommessa.getId().getDipendenteCodiceFiscale()) {
		System.out.println("dipendenteCodiceFiscale : "+ dipendenteCodiceFiscale);
		if( dipendenteCodiceFiscale == null ) {
			System.out.println("INSIDE IF: ");
			try {
				return dipendenteCommessaRepository.save(dipendenteCommessa);
			} catch (IllegalArgumentException ex) {
				//log.info(message);
				ex.printStackTrace();
			}

			
		}

		System.out.println("RETURNING NULL");
		return null;
		
		
	}


	@Override
	public List<DipendenteCommessa> trovaTuttiDipendenteCommesse() {
		return dipendenteCommessaRepository.findAll();
	}
	
}
