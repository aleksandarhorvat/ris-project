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
	private String porudzbina_Korisnik_username;

	@Column(insertable=false, updatable=false)
	private int proizvod_idProizvod;

	public PorudzbinaHasProizvodPK() {
	}
	public String getPorudzbina_Korisnik_username() {
		return this.porudzbina_Korisnik_username;
	}
	public void setPorudzbina_Korisnik_username(String porudzbina_Korisnik_username) {
		this.porudzbina_Korisnik_username = porudzbina_Korisnik_username;
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
			this.porudzbina_Korisnik_username.equals(castOther.porudzbina_Korisnik_username)
			&& (this.proizvod_idProizvod == castOther.proizvod_idProizvod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.porudzbina_Korisnik_username.hashCode();
		hash = hash * prime + this.proizvod_idProizvod;
		
		return hash;
	}
}