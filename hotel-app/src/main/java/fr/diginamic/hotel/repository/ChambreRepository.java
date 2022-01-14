package fr.diginamic.hotel.repository;

import fr.diginamic.hotel.entite.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

    public  List<Chambre> findAllByHotelNom( String hotel);

}
