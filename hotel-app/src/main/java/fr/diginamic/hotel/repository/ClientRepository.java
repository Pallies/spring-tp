package fr.diginamic.hotel.repository;

import fr.diginamic.hotel.entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    public Optional<Client> findClientByNumero(String numero);

    @Query("select c from Client c order by c.nom")
    public List<Client> findAllOrderByName();
}