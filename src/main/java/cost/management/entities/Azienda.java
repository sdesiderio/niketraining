package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the azienda database table.
 * 
 */
@Entity
@Table(name="azienda")
@NamedQuery(name="Azienda.findAll", query="SELECT a FROM Azienda a")
public class Azienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	private String nome;

	//bi-directional many-to-one association to Dipendente
	@OneToMany(mappedBy="azienda")
	private List<Dipendente> dipendenti;

	public Azienda() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
/*
	public List<Dipendente> getDipendenti() {
		return this.dipendenti;
	}

	public void setDipendente(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public Dipendente addDipendente(Dipendente dipendente) {
		getDipendenti().add(dipendente);
		dipendente.setAzienda(this);

		return dipendente;
	}

	public Dipendente removeDipendente(Dipendente dipendente) {
		getDipendenti().remove(dipendente);
		dipendente.setAzienda(null);

		return dipendente;
	}
*/
}