package dev.paie.repository;

import dev.paie.entities.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotisationRepository extends JpaRepository<Cotisation,Integer> {

}
