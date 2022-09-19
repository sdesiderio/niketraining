package cost.management.applicationrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cost.management.entities.Azienda;
import cost.management.repository.AziendaRepository;
import cost.management.service.AziendaService;

@Component
public class AziendeLoader implements ApplicationRunner {

    private AziendaRepository aziendaRepository;
    
    @Autowired
	private AziendaService aziendaService;
    
    @Autowired
    public AziendeLoader(AziendaRepository aziendaRepository) {
        this.aziendaRepository = aziendaRepository;
    }
        
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Azienda nikeWebConsulting = new Azienda();
		
		nikeWebConsulting.setActive((byte)1);
		nikeWebConsulting.setId(1);
		nikeWebConsulting.setNome("Nike Web Consulting");
		
		Azienda evolviti = new Azienda();
		
		evolviti.setActive((byte)1);
		evolviti.setId(2);
		evolviti.setNome("Evolviti");
		
		String nikePartitaIva = nikeWebConsulting.getNome();
		
		Azienda clienteDaControllare0 = aziendaService.trovaAziendaPerNome(nikePartitaIva);
		
		if(clienteDaControllare0==null) {
			aziendaRepository.save(nikeWebConsulting);
		}
		
		String evolvitiPartitaIva = evolviti.getNome();
		
		Azienda clienteDaControllare1 = aziendaService.trovaAziendaPerNome(evolvitiPartitaIva);
		
		if(clienteDaControllare1==null) {
			aziendaRepository.save(evolviti);
		}
	}
}