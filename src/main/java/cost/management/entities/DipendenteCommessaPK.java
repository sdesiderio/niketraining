package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dipendente_commessa database table.
 * 
 */
@Embeddable
public class DipendenteCommessaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="dipendente_codice_fiscale", insertable=false, updatable=false)
	private String dipendenteCodiceFiscale;

	@Column(name="commessa_codice", insertable=false, updatable=false)
	private String commessaCodice;

	public DipendenteCommessaPK() {
	}
	public String getDipendenteCodiceFiscale() {
		return this.dipendenteCodiceFiscale;
	}
	public void setDipendenteCodiceFiscale(String dipendenteCodiceFiscale) {
		this.dipendenteCodiceFiscale = dipendenteCodiceFiscale;
	}
	public String getCommessaCodice() {
		return this.commessaCodice;
	}
	public void setCommessaCodice(String commessaCodice) {
		this.commessaCodice = commessaCodice;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DipendenteCommessaPK)) {
			return false;
		}
		DipendenteCommessaPK castOther = (DipendenteCommessaPK)other;
		return 
			this.dipendenteCodiceFiscale.equals(castOther.dipendenteCodiceFiscale)
			&& this.commessaCodice.equals(castOther.commessaCodice);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dipendenteCodiceFiscale.hashCode();
		hash = hash * prime + this.commessaCodice.hashCode();
		
		return hash;
	}
}