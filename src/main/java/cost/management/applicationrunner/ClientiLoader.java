package cost.management.applicationrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cost.management.entities.Cliente;
import cost.management.repository.ClienteRepository;
import cost.management.service.ClienteService;

@Component
public class ClientiLoader implements ApplicationRunner {

    private ClienteRepository clienteRepository;
    
    @Autowired
	private ClienteService clienteService;
    
    @Autowired
    public ClientiLoader(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
        
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente nikeWebConsulting = new Cliente();
		
		nikeWebConsulting.setActive((byte)1);
		nikeWebConsulting.setPartitaIva("11111111111");
		nikeWebConsulting.setRagioneSociale("Nike Web Consulting");
		nikeWebConsulting.setCodiceInterscambio("abc1234");
		nikeWebConsulting.setCodiceFiscale("11111111110");
		
		Cliente evolviti = new Cliente();
		
		evolviti.setActive((byte)1);
		evolviti.setPartitaIva("11111111112");
		evolviti.setRagioneSociale("Evolviti");
		evolviti.setCodiceInterscambio("abc1235");
		evolviti.setCodiceFiscale("11111111100");
		
		String nikePartitaIva = nikeWebConsulting.getPartitaIva();
		
		Cliente clienteDaControllare0 = clienteService.trovaPerPartitaIva(nikePartitaIva);
		
		if(clienteDaControllare0==null) {
		clienteRepository.save(nikeWebConsulting);
		}
		
		String evolvitiPartitaIva = evolviti.getPartitaIva();
		
		Cliente clienteDaControllare1 = clienteService.trovaPerPartitaIva(evolvitiPartitaIva);
		
		if(clienteDaControllare1==null) {
		clienteRepository.save(evolviti);
		}
	}
}