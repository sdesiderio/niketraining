package cost.management.applicationrunner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cost.management.entities.TipologiaContratto;
import cost.management.repository.TipologiaContrattoRepository;

@Component
public class TipologiaContrattiLoader implements ApplicationRunner{
	
	private TipologiaContrattoRepository tipologiaContrattoRepository;

	@Autowired
    public TipologiaContrattiLoader(TipologiaContrattoRepository tipologiaContrattoRepository) {
        this.tipologiaContrattoRepository = tipologiaContrattoRepository;
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		TipologiaContratto tipologiaContratto = new TipologiaContratto();
		
		tipologiaContratto.setId(1);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("tempo indeterminato");
		
		int idContratto = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare = tipologiaContrattoRepository.findById(idContratto);
		
		if (tipologiaDaControllare.isEmpty()){
		tipologiaContrattoRepository.save(tipologiaContratto);
		}
		
		tipologiaContratto.setId(2);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("tempo determinato");
		
		int idContratto1 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare1 = tipologiaContrattoRepository.findById(idContratto1);
		
		
		if (tipologiaDaControllare1.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(3);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("apprendistato professionalizzante");
		
		int idContratto2 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare2 = tipologiaContrattoRepository.findById(idContratto2);
		
		
		if (tipologiaDaControllare2.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(4);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("collaborazione occasionale");
		
		int idContratto3 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare3 = tipologiaContrattoRepository.findById(idContratto3);
		
		
		if (tipologiaDaControllare3.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(5);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("partita iva");
		
		int idContratto4 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare4 = tipologiaContrattoRepository.findById(idContratto4);
		
		
		if (tipologiaDaControllare4.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(6);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("somministrazione");
		
		int idContratto5 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare5 = tipologiaContrattoRepository.findById(idContratto5);
		
		
		if (tipologiaDaControllare5.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(7);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("stage");
		
		int idContratto6 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare6 = tipologiaContrattoRepository.findById(idContratto6);
		
		
		if (tipologiaDaControllare6.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
		tipologiaContratto.setId(8);
		tipologiaContratto.setActive((byte) 1);
		tipologiaContratto.setTipologia("training");
		
		int idContratto7 = tipologiaContratto.getId();
		
		Optional<TipologiaContratto> tipologiaDaControllare7 = tipologiaContrattoRepository.findById(idContratto7);
		
		
		if (tipologiaDaControllare7.isEmpty()){
			tipologiaContrattoRepository.save(tipologiaContratto);
			}
		
	}

}
