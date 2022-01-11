package dev.mission.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
//@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private BigDecimal tauxJournalier;

    public Mission() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getTauxJournalier() {
        return tauxJournalier;
    }

    public void setTauxJournalier(BigDecimal tauxJournalier) {
        this.tauxJournalier = tauxJournalier;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mission{");
        sb.append("id=").append(id);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", tauxJournalier=").append(tauxJournalier);
        sb.append('}');
        return sb.toString();
    }
}
