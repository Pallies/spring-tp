package dev.paie.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class BulletinSalaire extends BaseEntity{

	@OneToOne
	private RemunerationEmploye remunerationEmploye;

	@OneToOne
	private Periode periode;

	private BigDecimal primeExceptionnelle;
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public BulletinSalaire setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
		return this;
	}
	public Periode getPeriode() {
		return periode;
	}
	public BulletinSalaire setPeriode(Periode periode) {
		this.periode = periode;
		return this;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public BulletinSalaire setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BulletinSalaire ");
		sb.append("remunerationEmploye = ").append(remunerationEmploye);
		sb.append(", periode = ").append(periode);
		sb.append(", primeExceptionnelle = ").append(primeExceptionnelle);
		sb.append('\n');
		return sb.toString();
	}
}
