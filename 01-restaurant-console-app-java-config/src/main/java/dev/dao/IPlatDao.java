package dev.dao;

import dev.entite.Plat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlatDao {
    List<Plat> listerPlats();
    void ajouterPlat(String nomPlat, Integer prixPlat);
}
