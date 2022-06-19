package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contratto database table.
 * 
 */
@Entity
@Table(name="contratto")
@NamedQuery(name="Contratto.findAll", query="SELECT c FROM Contratto c")
public class Contratto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	@Column(name="costo_gg")
	private float costoGg;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine_contratto")
	private Date dataFineContratto;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio_contratto")
	private Date dataInizioContratto;

	private int livello;

	private String note;

	@Column(name="retribuzione_lorda")
	private float retribuzioneLorda;

	@Column(name="rimborso_spese_mensili")
	private float rimborsoSpeseMensili;

	//bi-directional many-to-one association to Dipendente
	@ManyToOne
	private Dipendente dipendente;

	//bi-directional many-to-one association to TipologiaContratto
	@ManyToOne
	@JoinColumn(name="tipologia_contratto")
	private TipologiaContratto tipologiaContrattoBean;

	public Contratto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public float getCostoGg() {
		return this.costoGg;
	}

	public void setCostoGg(float costoGg) {
		this.costoGg = costoGg;
	}

	public Date getDataFineContratto() {
		return this.dataFineContratto;
	}

	public void setDataFineContratto(Date dataFineContratto) {
		this.dataFineContratto = dataFineContratto;
	}

	public Date getDataInizioContratto() {
		return this.dataInizioContratto;
	}

	public void setDataInizioContratto(Date dataInizioContratto) {
		this.dataInizioContratto = dataInizioContratto;
	}

	public int getLivello() {
		return this.livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getRetribuzioneLorda() {
		return this.retribuzioneLorda;
	}

	public void setRetribuzioneLorda(float retribuzioneLorda) {
		this.retribuzioneLorda = retribuzioneLorda;
	}

	public float getRimborsoSpeseMensili() {
		return this.rimborsoSpeseMensili;
	}

	public void setRimborsoSpeseMensili(float rimborsoSpeseMensili) {
		this.rimborsoSpeseMensili = rimborsoSpeseMensili;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public TipologiaContratto getTipologiaContrattoBean() {
		return this.tipologiaContrattoBean;
	}

	public void setTipologiaContrattoBean(TipologiaContratto tipologiaContrattoBean) {
		this.tipologiaContrattoBean = tipologiaContrattoBean;
	}

}