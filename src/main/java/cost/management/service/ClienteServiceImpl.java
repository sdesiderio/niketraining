package cost.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cost.management.entities.Cliente;
import cost.management.repository.ClienteRepository;
@Service
public class ClienteServiceImpl implements ClienteService {
	
	private String pIvaRegex="\\d{11}";

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente trovaPerPartitaIva(String partitaIva) {
		return clienteRepository.findByPartitaIva(partitaIva);
	}
	@Override
	public List<Cliente> trovaPerPartitaIvaContenente(String partitaIva) {
		return clienteRepository.findByPartitaIvaContaining(partitaIva);
	}
	@Override
	public List<Cliente> trovaPerPecContenente(String pec) {
		return clienteRepository.findByPecContaining(pec);
	}
	@Override
	public List<Cliente> trovaPerRagioneSocialeContenente(String ragioneSociale){
		return clienteRepository.findByRagioneSocialeContaining(ragioneSociale);
	}
	@Override
	public List<Cliente> trovaTuttiClienti(){
		return clienteRepository.findAll();
	}
	@Override
	public List<Cliente> trovaPerCodiceFiscaleContenente(String codiceFiscale) {
			return clienteRepository.findByCodiceFiscaleContaining(codiceFiscale);
	
	}
	@Override
	public List<Cliente> trovaPerCodiceInterscambioContenente(String codiceInterscambio) {
		return clienteRepository.findByCodiceInterscambioContaining(codiceInterscambio);
	}
	
	@Override
	public Cliente inserisciCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente aggiornaCliente(Cliente cliente,String id) {
		if(isValidId(id)) {
			cliente.setPartitaIva(id);
			Cliente clienteToUpdate = trovaPerPartitaIva(id);
			clienteToUpdate.setRagioneSociale(cliente.getRagioneSociale());
			clienteToUpdate.setIndirizzo(cliente.getIndirizzo());
			clienteToUpdate.setNCivico(cliente.getNCivico());
			clienteToUpdate.setCitta(cliente.getCitta());
			clienteToUpdate.setProvincia(cliente.getProvincia());
			clienteToUpdate.setCap(cliente.getCap());
			clienteToUpdate.setStato(cliente.getStato());
			clienteToUpdate.setPartitaIva(cliente.getPartitaIva());
			clienteToUpdate.setCodiceFiscale(cliente.getCodiceFiscale());
			clienteToUpdate.setCodiceInterscambio(cliente.getCodiceInterscambio());
			clienteToUpdate.setPec(cliente.getPec());
			
			return clienteRepository.save(clienteToUpdate);
		}return null;
	}
	
	@Override
	public Cliente archiviaCliente(String id) {
		Cliente clienteToArchive = clienteRepository.findByPartitaIva(id);
		clienteToArchive.setActive((byte)0);
		return clienteRepository.save(clienteToArchive);
	}
	
	private boolean isValidId(String id) {
		if (id.matches(pIvaRegex))return true;
		return false;
	}
}
