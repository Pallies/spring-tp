package fr.diginamic.hotel.repository;

import fr.diginamic.hotel.entite.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre,Integer> {
}
