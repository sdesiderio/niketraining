package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commessa database table.
 * 
 */
@Entity
@Table(name="commessa")
@NamedQuery(name="Commessa.findAll", query="SELECT c FROM Commessa c")
public class Commessa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codice;

	private byte active;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine_commessa")
	private Date dataFineCommessa;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio_commessa")
	private Date dataInizioCommessa;

	@Column(name="descrizione_commessa")
	private String descrizioneCommessa;

	
	private float importo;

	@Column(name="tipologia_commessa")
	private String tipologiaCommessa;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JsonBackReference(value="commesse-cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to DipendenteCommessa
	@OneToMany(mappedBy="commessa")
	@JsonManagedReference(value="dipendente-commessa1")
	private List<DipendenteCommessa> dipendenteCommesse;

	public Commessa() {
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getDataFineCommessa() {
		return this.dataFineCommessa;
	}

	public void setDataFineCommessa(Date dataFineCommessa) {
		this.dataFineCommessa = dataFineCommessa;
	}

	public Date getDataInizioCommessa() {
		return this.dataInizioCommessa;
	}

	public void setDataInizioCommessa(Date dataInizioCommessa) {
		this.dataInizioCommessa = dataInizioCommessa;
	}

	public String getDescrizioneCommessa() {
		return this.descrizioneCommessa;
	}

	public void setDescrizioneCommessa(String descrizioneCommessa) {
		this.descrizioneCommessa = descrizioneCommessa;
	}

	public float getImporto() {
		return this.importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public String getTipologiaCommessa() {
		return this.tipologiaCommessa;
	}

	public void setTipologiaCommessa(String tipologiaCommessa) {
		this.tipologiaCommessa = tipologiaCommessa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DipendenteCommessa> getDipendenteCommesse() {
		return this.dipendenteCommesse;
	}

	public void setDipendenteCommesse(List<DipendenteCommessa> dipendenteCommesse) {
		this.dipendenteCommesse = dipendenteCommesse;
	}

	public DipendenteCommessa addDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommesse().add(dipendenteCommessa);
		dipendenteCommessa.setCommessa(this);

		return dipendenteCommessa;
	}

	public DipendenteCommessa removeDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommesse().remove(dipendenteCommessa);
		dipendenteCommessa.setCommessa(null);

		return dipendenteCommessa;
	}

}