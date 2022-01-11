package dev.paie.entities;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Avantage extends BaseEntity {

    private String code;
    private String nom;
    private BigDecimal montant;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

}
