package dev.paie.exec;

import dev.paie.repository.CotisationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class ListerCotisations implements CommandLineRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(ListerCotisations.class);
    private final CotisationRepository repository;

    public ListerCotisations(CotisationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.findAll().forEach(cotisation -> {
            LOGGER.info(cotisation.toString());
        });
    }
}
