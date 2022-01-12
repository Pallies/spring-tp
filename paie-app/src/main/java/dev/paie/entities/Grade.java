package dev.paie.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Grade extends BaseEntity {
	

	private String code;
	@Column(name = "nb_heures_base")
	private BigDecimal nbHeuresBase;
	@Column(name = "taux_base")
	private BigDecimal tauxBase;

	public String getCode() {
		return code;
	}
	public Grade setCode(String code) {
		this.code = code;
		return this;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public Grade setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
		return this;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public Grade setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
		return this;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(" Grade{");
		sb.append("code='").append(code).append('\'');
		sb.append(", nbHeuresBase=").append(nbHeuresBase);
		sb.append(", tauxBase=").append(tauxBase);
		sb.append('}');
		return sb.toString();
	}
}
