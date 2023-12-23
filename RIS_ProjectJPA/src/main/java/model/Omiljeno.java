package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Omiljeno database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljeno.findAll", query="SELECT o FROM Omiljeno o")
public class Omiljeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OmiljenoPK id;

	//bi-directional many-to-one association to KategorijeKorisnika
	@ManyToOne
	@JoinColumn(name="KategorijeKorisnika_idKategorijeKorisnika")
	private KategorijeKorisnika kategorijeKorisnika;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	@JoinColumn(name="Proizvod_idProizvod")
	private Proizvod proizvod;

	public Omiljeno() {
	}

	public OmiljenoPK getId() {
		return this.id;
	}

	public void setId(OmiljenoPK id) {
		this.id = id;
	}

	public KategorijeKorisnika getKategorijeKorisnika() {
		return this.kategorijeKorisnika;
	}

	public void setKategorijeKorisnika(KategorijeKorisnika kategorijeKorisnika) {
		this.kategorijeKorisnika = kategorijeKorisnika;
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