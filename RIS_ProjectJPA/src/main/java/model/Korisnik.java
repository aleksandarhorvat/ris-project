package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;

	private String adresa;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Kartica
	@OneToMany(mappedBy="korisnik", fetch = FetchType.EAGER)
	private List<Kartica> karticas;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="korisnik", fetch = FetchType.EAGER)
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="korisnik", fetch = FetchType.EAGER)
	private List<Omiljeno> omiljenos;

	//bi-directional one-to-one association to Porudzbina
	@OneToOne(mappedBy="korisnik")
	private Porudzbina porudzbina;

	public Korisnik() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Kartica> getKarticas() {
		return this.karticas;
	}

	public void setKarticas(List<Kartica> karticas) {
		this.karticas = karticas;
	}

	public Kartica addKartica(Kartica kartica) {
		getKarticas().add(kartica);
		kartica.setKorisnik(this);

		return kartica;
	}

	public Kartica removeKartica(Kartica kartica) {
		getKarticas().remove(kartica);
		kartica.setKorisnik(null);

		return kartica;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setKorisnik(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setKorisnik(null);

		return ocena;
	}

	public List<Omiljeno> getOmiljenos() {
		return this.omiljenos;
	}

	public void setOmiljenos(List<Omiljeno> omiljenos) {
		this.omiljenos = omiljenos;
	}

	public Omiljeno addOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().add(omiljeno);
		omiljeno.setKorisnik(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setKorisnik(null);

		return omiljeno;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

}