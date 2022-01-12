package dev.paie.entities;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfilRemuneration extends BaseEntity{

	private String code;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil_remuneration_cotisations",
			joinColumns = @JoinColumn(name = "cotisations_id"),
			inverseJoinColumns = @JoinColumn(name = "profil_remuneration_id"))
	private List<Cotisation> cotisations;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "profil_remuneration_avantages",
//			joinColumns = @JoinColumn(name = "avantages_id"),
//			inverseJoinColumns = @JoinColumn(name = "profil_remuneration_id"))
	@Transient
	private List<Avantage> avantages;

	public String getCode() {
		return code;
	}

	public ProfilRemuneration setCode(String code) {
		this.code = code;
		return this;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ProfilRemuneration{");
		sb.append("code='").append(code).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
