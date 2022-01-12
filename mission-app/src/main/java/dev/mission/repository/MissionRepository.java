package dev.mission.repository;

import dev.mission.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Integer> {

    public List<Mission> findAllByDateDebutGreaterThanEqual(LocalDate date);
    public List<Mission> findAllByDateDebutAfterAndTauxJournalierAfter(LocalDate date, BigDecimal taux);

}
