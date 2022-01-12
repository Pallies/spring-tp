package dev.paie.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Entreprise extends BaseEntity  {

	private String siret;
	private String denomination;
	private String adresse;
	private String urssaf;
	@Column(name = "code_naf")
	private String codeNaf;

	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getUrssaf() {
		return urssaf;
	}
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}
	public String getCodeNaf() {
		return codeNaf;
	}
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Entreprise {");
		sb.append("siret='").append(siret).append('\'');
		sb.append(", denomination='").append(denomination).append('\'');
		sb.append(", adresse='").append(adresse).append('\'');
		sb.append(", urssaf='").append(urssaf).append('\'');
		sb.append(", codeNaf='").append(codeNaf).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
