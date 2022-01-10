package dev.service;

import dev.entite.Plat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPlatService {

    List<Plat> listerPlats();

    void ajouterPlat(String nomPlat, Integer prixPlat);
}
