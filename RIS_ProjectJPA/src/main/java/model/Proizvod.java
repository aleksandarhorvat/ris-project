package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the proizvod database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProizvod;

	private int cena;

	private String ime;

	private String opis;

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="proizvod")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="proizvod")
	private List<Omiljeno> omiljenos;

	//bi-directional many-to-one association to PorudzbinaHasProizvod
	@OneToMany(mappedBy="proizvod")
	private List<PorudzbinaHasProizvod> porudzbinaHasProizvods;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	//bi-directional many-to-one association to Popust
	@ManyToOne
	private Popust popust;

	//bi-directional many-to-one association to Proizvodjac
	@ManyToOne
	private Proizvodjac proizvodjac;

	public Proizvod() {
	}

	public int getIdProizvod() {
		return this.idProizvod;
	}

	public void setIdProizvod(int idProizvod) {
		this.idProizvod = idProizvod;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setProizvod(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setProizvod(null);

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
		omiljeno.setProizvod(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setProizvod(null);

		return omiljeno;
	}

	public List<PorudzbinaHasProizvod> getPorudzbinaHasProizvods() {
		return this.porudzbinaHasProizvods;
	}

	public void setPorudzbinaHasProizvods(List<PorudzbinaHasProizvod> porudzbinaHasProizvods) {
		this.porudzbinaHasProizvods = porudzbinaHasProizvods;
	}

	public PorudzbinaHasProizvod addPorudzbinaHasProizvod(PorudzbinaHasProizvod porudzbinaHasProizvod) {
		getPorudzbinaHasProizvods().add(porudzbinaHasProizvod);
		porudzbinaHasProizvod.setProizvod(this);

		return porudzbinaHasProizvod;
	}

	public PorudzbinaHasProizvod removePorudzbinaHasProizvod(PorudzbinaHasProizvod porudzbinaHasProizvod) {
		getPorudzbinaHasProizvods().remove(porudzbinaHasProizvod);
		porudzbinaHasProizvod.setProizvod(null);

		return porudzbinaHasProizvod;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Popust getPopust() {
		return this.popust;
	}

	public void setPopust(Popust popust) {
		this.popust = popust;
	}

	public Proizvodjac getProizvodjac() {
		return this.proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

}