package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Kartica database table.
 * 
 */
@Entity
@NamedQuery(name="Kartica.findAll", query="SELECT k FROM Kartica k")
public class Kartica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KarticaPK id;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik korisnik;

	public Kartica() {
	}

	public KarticaPK getId() {
		return this.id;
	}

	public void setId(KarticaPK id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}