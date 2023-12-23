package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the Omiljeno database table.
 * 
 */
@Embeddable
public class OmiljenoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Korisnik_idKorisnik", insertable=false, updatable=false)
	private int korisnik_idKorisnik;

	@Column(name="Proizvod_idProizvod", insertable=false, updatable=false)
	private int proizvod_idProizvod;

	public OmiljenoPK() {
	}
	public int getKorisnik_idKorisnik() {
		return this.korisnik_idKorisnik;
	}
	public void setKorisnik_idKorisnik(int korisnik_idKorisnik) {
		this.korisnik_idKorisnik = korisnik_idKorisnik;
	}
	public int getProizvod_idProizvod() {
		return this.proizvod_idProizvod;
	}
	public void setProizvod_idProizvod(int proizvod_idProizvod) {
		this.proizvod_idProizvod = proizvod_idProizvod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OmiljenoPK)) {
			return false;
		}
		OmiljenoPK castOther = (OmiljenoPK)other;
		return 
			(this.korisnik_idKorisnik == castOther.korisnik_idKorisnik)
			&& (this.proizvod_idProizvod == castOther.proizvod_idProizvod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.korisnik_idKorisnik;
		hash = hash * prime + this.proizvod_idProizvod;
		
		return hash;
	}
}