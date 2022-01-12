package dev.paie.exec;

import dev.paie.entities.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@PropertySource("classpath:profil-remuneration.properties")
public class InsererProfil {
    private final Logger LOGGER = LoggerFactory.getLogger(InsererProfil.class);
    private final ProfilRemunerationRepository repository;

    @Value("${profil.remuneration-categorie}")
    private List<String> profil;

    public InsererProfil(ProfilRemunerationRepository profilRemunerationRepository) {
        this.repository = profilRemunerationRepository;
    }

    @PostConstruct
    public void insertionProfilRemuneration() {
        List<ProfilRemuneration> profils = repository.findAll();
        profil.stream()
                .filter(p -> !convert(profils).contains(p))
                .forEach(newProfil -> {
                    LOGGER.warn("save {}", newProfil);
                    repository.save(convert(newProfil));
                });
    }

    private List<String> convert(List<ProfilRemuneration> source) {
        return source.stream().map(ProfilRemuneration::getCode)
                .collect(Collectors.toList());
    }

    private ProfilRemuneration convert(String source) {
        return new ProfilRemuneration().setCode(source);
    }
}
