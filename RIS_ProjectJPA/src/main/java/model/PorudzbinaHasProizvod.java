package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the porudzbina_has_proizvod database table.
 * 
 */
@Entity
@Table(name="porudzbina_has_proizvod")
@NamedQuery(name="PorudzbinaHasProizvod.findAll", query="SELECT p FROM PorudzbinaHasProizvod p")
public class PorudzbinaHasProizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PorudzbinaHasProizvodPK id;

	private int kolicina;

	//bi-directional many-to-one association to Porudzbina
	@ManyToOne
	private Porudzbina porudzbina;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	private Proizvod proizvod;

	public PorudzbinaHasProizvod() {
	}

	public PorudzbinaHasProizvodPK getId() {
		return this.id;
	}

	public void setId(PorudzbinaHasProizvodPK id) {
		this.id = id;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}