package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorijekorisnika database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijekorisnika.findAll", query="SELECT k FROM Kategorijekorisnika k")
public class Kategorijekorisnika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorijeKorisnika;

	private String naziv;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="kategorijekorisnika", fetch = FetchType.EAGER)
	private List<Omiljeno> omiljenos;

	public Kategorijekorisnika() {
	}

	public int getIdKategorijeKorisnika() {
		return this.idKategorijeKorisnika;
	}

	public void setIdKategorijeKorisnika(int idKategorijeKorisnika) {
		this.idKategorijeKorisnika = idKategorijeKorisnika;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Omiljeno> getOmiljenos() {
		return this.omiljenos;
	}

	public void setOmiljenos(List<Omiljeno> omiljenos) {
		this.omiljenos = omiljenos;
	}

	public Omiljeno addOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().add(omiljeno);
		omiljeno.setKategorijekorisnika(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setKategorijekorisnika(null);

		return omiljeno;
	}

}