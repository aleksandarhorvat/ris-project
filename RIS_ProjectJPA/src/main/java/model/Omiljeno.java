package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the omiljeno database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljeno.findAll", query="SELECT o FROM Omiljeno o")
public class Omiljeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OmiljenoPK id;

	//bi-directional many-to-one association to Kategorijekorisnika
	@ManyToOne
	private Kategorijekorisnika kategorijekorisnika;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	private Proizvod proizvod;

	public Omiljeno() {
	}

	public OmiljenoPK getId() {
		return this.id;
	}

	public void setId(OmiljenoPK id) {
		this.id = id;
	}

	public Kategorijekorisnika getKategorijekorisnika() {
		return this.kategorijekorisnika;
	}

	public void setKategorijekorisnika(Kategorijekorisnika kategorijekorisnika) {
		this.kategorijekorisnika = kategorijekorisnika;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}