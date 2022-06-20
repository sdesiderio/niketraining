package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;



/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte active;
	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	
	
	//private String numeroCivico;
	@Column(name = "n_civico")
	private String nCivico;
	

	@Id
	@Column(name="partita_iva")
	@NotBlank(message = "partita iva obbligatoria")
	@Pattern(regexp = "\\d{11}")
	private String partitaIva;

	private String cap;

	private String citta;

	@Column(name="codice_fiscale")
	@NotBlank(message = "codice fiscale obbligatorio")
	@Pattern(regexp = "\\d{11}")
	private String codiceFiscale;

	@Column(name="codice_interscambio")
	@Pattern(regexp = "\\S{7}")
	private String codiceInterscambio;
	@Email
	private String pec;
	
	private String indirizzo;

	private String provincia;

	@Column(name="ragione_sociale")
	@Size(min = 1,max = 30,message = "ragione sociale obbligatoria")
	
	private String ragioneSociale;

	private String stato;

	//bi-directional many-to-one association to Commessa
	@OneToMany(mappedBy="cliente")
	@JsonBackReference(value="commesse-cliente")
	private List<Commessa> commesse;

	public Cliente() {
	}

	public String getPartitaIva() {
		return this.partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	
	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceInterscambio() {
		return this.codiceInterscambio;
	}

	public void setCodiceInterscambio(String codiceInterscambio) {
		this.codiceInterscambio = codiceInterscambio;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getNCivico() {
		return this.nCivico;
	}

	public void setNCivico(String numeroCivico) {
		this.nCivico = numeroCivico;
	}

	public String getPec() {
		return this.pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRagioneSociale() {
		return this.ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public List<Commessa> getCommesse() {
		return this.commesse;
	}

	public void setCommesse(List<Commessa> commesse) {
		this.commesse = commesse;
	}

	

}