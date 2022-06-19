package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the dipendente_commessa database table.
 * 
 */
@Entity
@Table(name="dipendente_commessa")
@NamedQuery(name="DipendenteCommessa.findAll", query="SELECT d FROM DipendenteCommessa d")
public class DipendenteCommessa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DipendenteCommessaPK id;

	private byte active;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine_attivita")
	//@JsonFormat(pattern="dd/MM/yyyy",shape=JsonFormat.Shape.STRING)
	private Date dataFineAttivita;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio_attivita")
	//@JsonFormat(pattern="dd/MM/yyyy",shape=JsonFormat.Shape.STRING)
	private Date dataInizioAttivita;

	@Column(name="tariffa_gg")
	private float tariffaGg;

	//bi-directional many-to-one association to Dipendente
	@ManyToOne
	@JoinColumn(name= "dipendente_codice_fiscale" ,insertable=false, updatable=false)
	@JsonBackReference(value="dipendente-commessa2")
	private Dipendente dipendente;

	//bi-directional many-to-one association to Commessa
	@ManyToOne
	@JsonBackReference(value="dipendente-commessa1")
	@JoinColumn(name="commessa_codice", insertable=false, updatable=false)
	private Commessa commessa;

	public DipendenteCommessa() {
	}

	public DipendenteCommessaPK getId() {
		return this.id;
	}

	public void setId(DipendenteCommessaPK id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getDataFineAttivita() {
		return this.dataFineAttivita;
	}

	public void setDataFineAttivita(Date dataFineAttivita) {
		this.dataFineAttivita = dataFineAttivita;
	}

	public Date getDataInizioAttivita() {
		return this.dataInizioAttivita;
	}

	public void setDataInizioAttivita(Date dataInizioAttivita) {
		this.dataInizioAttivita = dataInizioAttivita;
	}

	public float getTariffaGg() {
		return this.tariffaGg;
	}

	public void setTariffaGg(float tariffaGg) {
		this.tariffaGg = tariffaGg;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Commessa getCommessa() {
		return this.commessa;
	}

	public void setCommessa(Commessa commessa) {
		this.commessa = commessa;
	}

}