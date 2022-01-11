package dev.paie.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfilRemuneration extends BaseEntity{

	private String code;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisations",
			joinColumns = @JoinColumn(name = "cotisations_id"),
			inverseJoinColumns = @JoinColumn(name = "profil_remuneration_id"))
	private List<Cotisation> cotisations;

	@Transient
	private List<Avantage> avantages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}


}
