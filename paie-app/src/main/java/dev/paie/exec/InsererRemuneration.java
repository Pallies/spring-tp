package dev.paie.exec;


import dev.paie.entities.Entreprise;
import dev.paie.entities.Grade;
import dev.paie.entities.ProfilRemuneration;
import dev.paie.entities.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Configuration
@PropertySource("classpath:profil-remuneration.properties")
public class InsererRemuneration {

    private final Logger LOGGER = LoggerFactory.getLogger(InsererRemuneration.class);
    @Value("${profil.creation-lettre}")
    private List<String> alphabet;


    private final RemunerationEmployeRepository employeRepository;
    private final ProfilRemunerationRepository profilRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final GradeRepository gradeRepository;



    @Autowired
    public InsererRemuneration(
            RemunerationEmployeRepository employeRepository,
            ProfilRemunerationRepository profilRepository,
            EntrepriseRepository entrepriseRepository,
            GradeRepository gradeRepository
    ) {
        this.employeRepository = employeRepository;
        this.profilRepository = profilRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.gradeRepository = gradeRepository;

    }

    @PostConstruct
    public void insertionRemuneration() {
        String matricule = creationMatricule(profilRepository);
        Entreprise entreprise = affectationEntity(entrepriseRepository);
        Grade grade = affectationEntity(gradeRepository);
        ProfilRemuneration profilRemuneration = affectationEntity(profilRepository);//ok


        RemunerationEmploye employe = new RemunerationEmploye()
                .setMatricule(matricule)
                .setEntreprise(entreprise)
                .setProfilRemuneration(profilRemuneration)
                .setGrade(grade);
        RemunerationEmploye em = employeRepository.save(employe);

        LOGGER.warn("Création de la rémunération d'un employé  {}", employe);
    }

    private String creationMatricule(ProfilRemunerationRepository repositoryProfil) {
        Random random = new Random();
        List<ProfilRemuneration> profil = repositoryProfil.findAll();
        int len = profil.size() - 1;
        String initial = Arrays.stream(profil.get(random.nextInt(len) + 1)
                        .getCode()
                        .split(" "))
                .map(s -> s.substring(0, 1))
                .reduce(String::concat)
                .orElse("X");
        return new StringBuilder()
                .append(initial)
                .append(alphabet.get(random.nextInt(25)))
                .append(alphabet.get(random.nextInt(25)))
                .append(alphabet.get(random.nextInt(25)))
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .toString().toUpperCase();
    }

    private <T> T affectationEntity(JpaRepository<T, Integer> repository) {
        List<T> list = repository.findAll();
        int len = list.size();
        int nbreAlea = new Random().nextInt(len - 1);
        return  list.get(nbreAlea);
    }

}
