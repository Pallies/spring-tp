package dev.paie.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cotisation extends BaseEntity{

	private String code;

	private String libelle;
	@Column(name = "taux_salarial")
	private BigDecimal tauxSalarial;
	@Column(name = "taux_patronal")
	private BigDecimal tauxPatronal;

	private Boolean imposable = false;

	@ManyToMany(mappedBy = "cotisations")
	public List<ProfilRemuneration> profilRemunerations;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Boolean getImposable() {
		return imposable;
	}
	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Cotisation ");
		sb.append("code = ").append(code);
		sb.append(", libelle = ").append(libelle);
		sb.append(", tauxSalarial = ").append(tauxSalarial);
		sb.append(", tauxPatronal = ").append(tauxPatronal);
		return sb.toString();
	}
}
