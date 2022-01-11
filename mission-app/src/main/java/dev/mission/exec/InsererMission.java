package dev.mission.exec;

import dev.mission.entities.Mission;
import dev.mission.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;


@Controller
@Profile("insert")
public class InsererMission implements CommandLineRunner {

    private final MissionRepository repository;
@Autowired
    public InsererMission(MissionRepository missionRepository) {
        repository=missionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Mission mission = new Mission();
        mission.setLibelle("Mission 1");
        mission.setTauxJournalier(new BigDecimal("100.90"));
        mission.setDateDebut(LocalDate.of(2019, 1, 1));
        mission.setDateFin(LocalDate.of(2019, 3, 4));

        this.repository.save(mission);
    }
}
