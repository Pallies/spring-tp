package dev.paie.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class RemunerationEmploye extends BaseEntity {

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

    public RemunerationEmploye setMatricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public RemunerationEmploye setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
        return this;
    }

    public ProfilRemuneration getProfilRemuneration() {
        return profilRemuneration;
    }

    public RemunerationEmploye setProfilRemuneration(ProfilRemuneration profilRemuneration) {
        this.profilRemuneration = profilRemuneration;
        return this;
    }

    public Grade getGrade() {
        return grade;
    }

    public RemunerationEmploye setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("matricule = ").append(matricule);
        sb.append(", entreprise = ").append(entreprise);
        sb.append(", profilRemuneration = ").append(profilRemuneration);
        sb.append(", grade = ").append(grade).append("\n");
        return sb.toString();
    }
}
