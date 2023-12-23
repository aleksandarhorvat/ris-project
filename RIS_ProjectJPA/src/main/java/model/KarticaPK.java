package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the Kartica database table.
 * 
 */
@Embeddable
public class KarticaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int brojKartice;

	@Temporal(TemporalType.DATE)
	private java.util.Date datumIsticanja;

	@Column(name="CVV")
	private int cvv;

	@Column(name="Korisnik_idKorisnik", insertable=false, updatable=false)
	private int korisnik_idKorisnik;

	public KarticaPK() {
	}
	public int getBrojKartice() {
		return this.brojKartice;
	}
	public void setBrojKartice(int brojKartice) {
		this.brojKartice = brojKartice;
	}
	public java.util.Date getDatumIsticanja() {
		return this.datumIsticanja;
	}
	public void setDatumIsticanja(java.util.Date datumIsticanja) {
		this.datumIsticanja = datumIsticanja;
	}
	public int getCvv() {
		return this.cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getKorisnik_idKorisnik() {
		return this.korisnik_idKorisnik;
	}
	public void setKorisnik_idKorisnik(int korisnik_idKorisnik) {
		this.korisnik_idKorisnik = korisnik_idKorisnik;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KarticaPK)) {
			return false;
		}
		KarticaPK castOther = (KarticaPK)other;
		return 
			(this.brojKartice == castOther.brojKartice)
			&& this.datumIsticanja.equals(castOther.datumIsticanja)
			&& (this.cvv == castOther.cvv)
			&& (this.korisnik_idKorisnik == castOther.korisnik_idKorisnik);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.brojKartice;
		hash = hash * prime + this.datumIsticanja.hashCode();
		hash = hash * prime + this.cvv;
		hash = hash * prime + this.korisnik_idKorisnik;
		
		return hash;
	}
}