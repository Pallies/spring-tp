package fr.diginamic.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel extends BaseEntities{

    // @Column optionnel ne sert que si JPA gère la création des tables
    private String ville;
    private String nom;

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambre;

    public Hotel() {
    }

    public Hotel(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
