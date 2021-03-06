package cost.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cost.management.entities.Azienda;
import cost.management.repository.AziendaRepository;

@Service
public class AziendaServiceImpl implements AziendaService {
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
	
	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Azienda> trovaTutteAziende(){
		
		List<Azienda> listaAziende = new ArrayList<>();
		listaAziende = aziendaRepository.findAll();
		//System.out.println("@@@@@@@ AZIENDA NOME FORM PORPERTIES :"+ aziendaNome);
		if(!listaAziende.isEmpty()) {
			
			log.info("La lista delle aziende e' piena");

		
			return listaAziende;
		}else {
			log.info("la lista delle aziende e' vuota");
		}

		return null;
	}

	@Override
	public Azienda trovaAziendaPerId(String id) {
		// TODO Auto-generated method stub
		log.info("AZIENDA ID ************* "+ aziendaRepository.findById(Integer.parseInt(id)).get());
		return aziendaRepository.findById(Integer.parseInt(id)).get();
	}

	@Override
	public Azienda trovaAziendaPerNome(String aziendaNome) {
		//System.out.println("################## "+ aziendaRepo.findAziendaByNome(aziendaNome));
		return aziendaRepository.findAziendaByNome(aziendaNome);
	}
	
}
