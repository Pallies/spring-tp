package fr.diginamic.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chambre")//optionnel si le nom est
public class Chambre extends BaseEntities {

    @Column
    private String numero;

    @ManyToOne
    @JoinColumn(name = "hot_id")// optionnel mais le nom serait hotel_id
    private Hotel hotel;
    // Set objet unique
    // List objet trié
    @ManyToMany
    private List<Reservation> re;
    public Chambre() {
    }

    public Chambre(String numero, Hotel hotel) {
        this.numero = numero;
        this.hotel = hotel;
    }
}
