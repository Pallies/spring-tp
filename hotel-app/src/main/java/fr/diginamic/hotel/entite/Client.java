package fr.diginamic.hotel.entite;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Validated
public class Client extends BaseEntite {

    @Column(unique = true, nullable = false)
    private String numero;

    @Size(min = 2)
    private String nom;
    @Size(min = 2)
    private String prenoms;

    public Client() {
    }

    public Client(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }
}
