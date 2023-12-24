package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the Ocena database table.
 * 
 */
@Embeddable
public class OcenaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Korisnik_username", insertable=false, updatable=false)
	private String korisnik_username;

	@Column(name="Proizvod_idProizvod", insertable=false, updatable=false)
	private int proizvod_idProizvod;

	public OcenaPK() {
	}
	public String getKorisnik_username() {
		return this.korisnik_username;
	}
	public void setKorisnik_username(String korisnik_username) {
		this.korisnik_username = korisnik_username;
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
		if (!(other instanceof OcenaPK)) {
			return false;
		}
		OcenaPK castOther = (OcenaPK)other;
		return 
			this.korisnik_username.equals(castOther.korisnik_username)
			&& (this.proizvod_idProizvod == castOther.proizvod_idProizvod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.korisnik_username.hashCode();
		hash = hash * prime + this.proizvod_idProizvod;
		
		return hash;
	}
}