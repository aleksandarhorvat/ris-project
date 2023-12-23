package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the KategorijeKorisnika database table.
 * 
 */
@Entity
@NamedQuery(name="KategorijeKorisnika.findAll", query="SELECT k FROM KategorijeKorisnika k")
public class KategorijeKorisnika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorijeKorisnika;

	private String naziv;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="kategorijeKorisnika")
	private List<Omiljeno> omiljenos;

	public KategorijeKorisnika() {
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
		omiljeno.setKategorijeKorisnika(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setKategorijeKorisnika(null);

		return omiljeno;
	}

}