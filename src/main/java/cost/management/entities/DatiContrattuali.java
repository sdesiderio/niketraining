package cost.management.entities;

import java.util.ArrayList;
import java.util.List;

public class DatiContrattuali {
	
	private String codiceFiscale;
	
	private String azienda;
	
	private String nome;
	
	private String cognome;
	
	private List<TipologiaContratto> tipologiecontratto;
	
	public DatiContrattuali() {
	}

	public DatiContrattuali(String codiceFiscale, String azienda, String nome, String cognome,
			List<TipologiaContratto> tipologiecontratto) {
		this.codiceFiscale = codiceFiscale;
		this.azienda = azienda;
		this.nome = nome;
		this.cognome = cognome;
		this.tipologiecontratto = tipologiecontratto;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<TipologiaContratto> getTipologiecontratto() {
		return tipologiecontratto;
	}

	public void setTipologiecontratto(List<TipologiaContratto> tipologiecontratto) {
		this.tipologiecontratto = tipologiecontratto;
	}
	
	

}
