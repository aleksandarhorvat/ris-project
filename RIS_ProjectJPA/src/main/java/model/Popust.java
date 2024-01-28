package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the popust database table.
 * 
 */
@Entity
@NamedQuery(name="Popust.findAll", query="SELECT p FROM Popust p")
public class Popust implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPopust;

	@Temporal(TemporalType.DATE)
	private Date datumIsticanja;

	private BigDecimal procenat;

	//bi-directional many-to-one association to Proizvod
	@OneToMany(mappedBy="popust", fetch = FetchType.EAGER)
	private List<Proizvod> proizvods;

	public Popust() {
	}

	public int getIdPopust() {
		return this.idPopust;
	}

	public void setIdPopust(int idPopust) {
		this.idPopust = idPopust;
	}

	public Date getDatumIsticanja() {
		return this.datumIsticanja;
	}

	public void setDatumIsticanja(Date datumIsticanja) {
		this.datumIsticanja = datumIsticanja;
	}

	public BigDecimal getProcenat() {
		return this.procenat;
	}

	public void setProcenat(BigDecimal procenat) {
		this.procenat = procenat;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setPopust(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setPopust(null);

		return proizvod;
	}

}