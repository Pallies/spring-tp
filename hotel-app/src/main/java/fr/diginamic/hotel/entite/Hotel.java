package fr.diginamic.hotel.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hotel extends BaseEntite {

    @Column(unique = true, nullable = false)
    private String nom;

    private Integer nombreEtoiles;

    public Hotel() {
    }

    public Hotel(String nom, Integer nombreEtoiles) {
        this.nom = nom;
        this.nombreEtoiles = nombreEtoiles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNombreEtoiles() {
        return nombreEtoiles;
    }

    public void setNombreEtoiles(Integer nombreEtoiles) {
        this.nombreEtoiles = nombreEtoiles;
    }
}
