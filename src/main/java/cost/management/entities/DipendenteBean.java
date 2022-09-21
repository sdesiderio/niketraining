package cost.management.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DipendenteBean {
	
	private String codiceFiscale;
	
	private byte active;

	private String cellulare;

	long age;
	
	private String cognome;
	
	private Date createDate;
	
	private Date dataNascita;
	
	private String domicilio;
	
	private String emAziendale;
	
	private String email;
	
	private String luogoNascita;

	private String nome;

	private String residenza;
	
	private List<Contratto> contratti = new ArrayList<>();
	
	private Azienda azienda;
	
	private List<DipendenteCommessa> dipendenteCommesse;
	
	private Commessa commessa;
	

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmAziendale() {
		return emAziendale;
	}

	public void setEmAziendale(String emAziendale) {
		this.emAziendale = emAziendale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public List<Contratto> getContratti() {
		return contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public List<DipendenteCommessa> getDipendenteCommesse() {
		return dipendenteCommesse;
	}

	public void setDipendenteCommesse(List<DipendenteCommessa> dipendenteCommesse) {
		this.dipendenteCommesse = dipendenteCommesse;
	}

	public Commessa getCommessa() {
		return commessa;
	}

	public void setCommessa(Commessa commessa) {
		this.commessa = commessa;
	}
	
	

}
