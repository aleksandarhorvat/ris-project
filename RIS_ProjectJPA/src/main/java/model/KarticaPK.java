package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the kartica database table.
 * 
 */
@Embeddable
public class KarticaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String korisnik_username;

	private int brojKartice;

	private int cvv;

	@Temporal(TemporalType.DATE)
	private java.util.Date datumIsticanja;

	public KarticaPK() {
	}
	public String getKorisnik_username() {
		return this.korisnik_username;
	}
	public void setKorisnik_username(String korisnik_username) {
		this.korisnik_username = korisnik_username;
	}
	public int getBrojKartice() {
		return this.brojKartice;
	}
	public void setBrojKartice(int brojKartice) {
		this.brojKartice = brojKartice;
	}
	public int getCvv() {
		return this.cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public java.util.Date getDatumIsticanja() {
		return this.datumIsticanja;
	}
	public void setDatumIsticanja(java.util.Date datumIsticanja) {
		this.datumIsticanja = datumIsticanja;
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
			this.korisnik_username.equals(castOther.korisnik_username)
			&& (this.brojKartice == castOther.brojKartice)
			&& (this.cvv == castOther.cvv)
			&& this.datumIsticanja.equals(castOther.datumIsticanja);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.korisnik_username.hashCode();
		hash = hash * prime + this.brojKartice;
		hash = hash * prime + this.cvv;
		hash = hash * prime + this.datumIsticanja.hashCode();
		
		return hash;
	}
}