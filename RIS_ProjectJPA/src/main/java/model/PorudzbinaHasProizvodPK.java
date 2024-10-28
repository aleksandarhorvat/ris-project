package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the porudzbina_has_proizvod database table.
 * 
 */
@Embeddable
public class PorudzbinaHasProizvodPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String porudzbina_korisnik_username;

	@Column(insertable=false, updatable=false)
	private int proizvod_idProizvod;

	public PorudzbinaHasProizvodPK() {
	}
	public String getPorudzbina_korisnik_username() {
		return this.porudzbina_korisnik_username;
	}
	public void setPorudzbina_korisnik_username(String porudzbina_korisnik_username) {
		this.porudzbina_korisnik_username = porudzbina_korisnik_username;
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
		if (!(other instanceof PorudzbinaHasProizvodPK)) {
			return false;
		}
		PorudzbinaHasProizvodPK castOther = (PorudzbinaHasProizvodPK)other;
		return 
			this.porudzbina_korisnik_username.equals(castOther.porudzbina_korisnik_username)
			&& (this.proizvod_idProizvod == castOther.proizvod_idProizvod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.porudzbina_korisnik_username.hashCode();
		hash = hash * prime + this.proizvod_idProizvod;
		
		return hash;
	}
}