package fr.diginamic.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "res_ch")
public class Reservation extends BaseEntities {

    @ManyToMany
    @JoinTable(name = "res_ch",
            joinColumns = @JoinColumn(name = "id_ch",referencedColumnName = "chambre_id"),
            inverseJoinColumns = @JoinColumn(name = "id_res",referencedColumnName = "hotel_id"))
    private List<Chambre> chambres;
}
