package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the tipologia_contratto database table.
 * 
 */
@Entity
@Table(name="tipologia_contratto")
@NamedQuery(name="TipologiaContratto.findAll", query="SELECT t FROM TipologiaContratto t")
public class TipologiaContratto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	private String tipologia;

	//bi-directional many-to-one association to Contratto
	@JsonIgnore
	@OneToMany(mappedBy="tipologiaContrattoBean")
	private List<Contratto> contratti = new ArrayList<>();

	public TipologiaContratto() {
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

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public List<Contratto> getContratti() {
		return this.contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public Contratto addContratto(Contratto contratto) {
		getContratti().add(contratto);
		contratto.setTipologiaContrattoBean(this);

		return contratto;
	}

	public Contratto removeContratto(Contratto contratto) {
		getContratti().remove(contratto);
		contratto.setTipologiaContrattoBean(null);

		return contratto;
	}

}