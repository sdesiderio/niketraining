package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dipendente database table.
 * 
 */
@Entity
@Table(name="dipendente")
@NamedQuery(name="Dipendente.findAll", query="SELECT d FROM Dipendente d")
public class Dipendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codice_fiscale")
	private String codiceFiscale;
	
	@Column(name="active")
	private byte active;

	private String cellulare;

	long age;
	
	private String cognome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;

	private String domicilio;

	@Column(name="em_aziendale")
	private String emAziendale;

	private String email;

	@Column(name="luogo_nascita")
	private String luogoNascita;

	private String nome;

	private String residenza;
	
	

	//bi-directional many-to-one association to Contratto
	@JsonManagedReference
	@OneToMany(mappedBy="dipendente")
	private List<Contratto> contratti = new ArrayList<>();

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	private Azienda azienda;

	//bi-directional many-to-one association to DipendenteCommessa
	@OneToMany(mappedBy="dipendente")
	@JsonManagedReference(value="dipendente-commessa2")
	private List<DipendenteCommessa> dipendenteCommesse;

	public Dipendente() {
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCellulare() {
		return this.cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmAziendale() {
		return this.emAziendale;
	}

	public void setEmAziendale(String emAziendale) {
		this.emAziendale = emAziendale;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResidenza() {
		return this.residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public List<Contratto> getContratti() {
		return this.contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public Contratto addContratto(Contratto contratto) {
		getContratti().add(contratto);
		contratto.setDipendente(this);

		return contratto;
	}

	public Contratto removeContratto(Contratto contratto) {
		getContratti().remove(contratto);
		contratto.setDipendente(null);

		return contratto;
	}

	public Azienda getAzienda() {
		return this.azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}
	public void setAge(long years) {
		this.age = years;
	}
	public long getAge() {
		return this.age;
	}
	public List<DipendenteCommessa> getDipendenteCommesse() {
		return this.dipendenteCommesse;
	}

	public void setDipendenteCommesse(List<DipendenteCommessa> dipendenteCommesse) {
		this.dipendenteCommesse = dipendenteCommesse;
	}

	public DipendenteCommessa addDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommesse().add(dipendenteCommessa);
		dipendenteCommessa.setDipendente(this);

		return dipendenteCommessa;
	}

	public DipendenteCommessa removeDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommesse().remove(dipendenteCommessa);
		dipendenteCommessa.setDipendente(null);

		return dipendenteCommessa;
	}

}