package dev.mission.exec;

import dev.mission.entities.Mission;
import dev.mission.repository.MissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
@Profile("insert")
public class InsererMission implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(InsererMission.class);
    private final MissionRepository repository;
    // numéro de la Mission généré automatiquement
    private AtomicInteger num;
    //        La date du jour LocalDate.now() pour l'exemple = 2020.01.01
    private final LocalDate  toDay =LocalDate.of(2020,01,01);
    public InsererMission(MissionRepository missionRepository) {
        repository = missionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        launchCreateMission();
        ListerProchainesMissions().forEach(m->{
            LOGGER.info("avec la sélection Date {}",m.toString());
        });;
        ListerProchainesMissionsParTJM(100.5).forEach(m->{
            LOGGER.info("avec la sélection Date et Taux {}",m.toString());
        });;
    }
    public List<Mission> ListerProchainesMissions() {
        return repository.findAllByDateDebutAfter(toDay);
    }
    private List<Mission> ListerProchainesMissionsParTJM(double taux){
        return repository.findAllByDateDebutAfterAndTauxJournalierAfter(toDay,new BigDecimal(taux));
    }
    private void launchCreateMission() {
        // cherche l'id mission le plus grand de la BDD
        Optional<Mission> mission = this.repository.findAll()
                .stream()
                .max(Comparator.comparing(Mission::getId));

        int initValue = mission.isPresent() ? mission.get().getId() : 0;
        num = new AtomicInteger(initValue);
        // crée d'autres mission
        for (int i = 0; i < 4; i++) {
            Mission newMission = this.createMission(num.incrementAndGet());
            this.repository.save(newMission);
            LOGGER.info(" Mission {} save ", newMission.getId());
        }
    }


    private Mission createMission(Integer id) {
        Mission mission = new Mission();
        double taux = 100 + (100 * new Random().nextDouble()) / 100;
        mission.setLibelle("Mission " + id);
        mission.setTauxJournalier(new BigDecimal(taux));
        LocalDate start = LocalDate.of(rankInt(2019, 2022), rankInt(1, 12), rankInt(1, 28));
        LocalDate end = start.plusDays(rankInt(1, 3)).plusYears(1);
        mission.setDateDebut(start);
        mission.setDateFin(end);
        return mission;
    }

    private int rankInt(int min, int max) {
        return Long.bitCount(Math.round(Math.random() * (max - min))) + min;
    }


}
