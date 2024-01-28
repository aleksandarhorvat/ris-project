package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the porudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Porudzbina.findAll", query="SELECT p FROM Porudzbina p")
public class Porudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String korisnik_username;

	@Temporal(TemporalType.DATE)
	private Date datumIsporuke;

	@Temporal(TemporalType.DATE)
	private Date datumNarucivanja;

	private String status;

	//bi-directional one-to-one association to Korisnik
	@OneToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to PorudzbinaHasProizvod
	@OneToMany(mappedBy="porudzbina", fetch = FetchType.EAGER)
	private List<PorudzbinaHasProizvod> porudzbinaHasProizvods;

	public Porudzbina() {
	}

	public String getKorisnik_username() {
		return this.korisnik_username;
	}

	public void setKorisnik_username(String korisnik_username) {
		this.korisnik_username = korisnik_username;
	}

	public Date getDatumIsporuke() {
		return this.datumIsporuke;
	}

	public void setDatumIsporuke(Date datumIsporuke) {
		this.datumIsporuke = datumIsporuke;
	}

	public Date getDatumNarucivanja() {
		return this.datumNarucivanja;
	}

	public void setDatumNarucivanja(Date datumNarucivanja) {
		this.datumNarucivanja = datumNarucivanja;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<PorudzbinaHasProizvod> getPorudzbinaHasProizvods() {
		return this.porudzbinaHasProizvods;
	}

	public void setPorudzbinaHasProizvods(List<PorudzbinaHasProizvod> porudzbinaHasProizvods) {
		this.porudzbinaHasProizvods = porudzbinaHasProizvods;
	}

	public PorudzbinaHasProizvod addPorudzbinaHasProizvod(PorudzbinaHasProizvod porudzbinaHasProizvod) {
		getPorudzbinaHasProizvods().add(porudzbinaHasProizvod);
		porudzbinaHasProizvod.setPorudzbina(this);

		return porudzbinaHasProizvod;
	}

	public PorudzbinaHasProizvod removePorudzbinaHasProizvod(PorudzbinaHasProizvod porudzbinaHasProizvod) {
		getPorudzbinaHasProizvods().remove(porudzbinaHasProizvod);
		porudzbinaHasProizvod.setPorudzbina(null);

		return porudzbinaHasProizvod;
	}

}