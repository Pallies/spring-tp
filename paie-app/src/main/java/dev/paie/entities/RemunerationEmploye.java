package dev.paie.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class RemunerationEmploye extends BaseEntity{

	private String matricule;
	@OneToOne
	private Entreprise entreprise;
	@OneToOne
	private ProfilRemuneration profilRemuneration;
	@OneToOne
	private Grade grade;
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
	

}