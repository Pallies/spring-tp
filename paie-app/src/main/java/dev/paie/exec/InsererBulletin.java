package dev.paie.exec;

import dev.paie.entities.BulletinSalaire;
import dev.paie.entities.Periode;
import dev.paie.entities.RemunerationEmploye;
import dev.paie.exec.utils.Affectation;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;

@Configuration
public class InsererBulletin extends Affectation {

    private final Logger LOGGER = LoggerFactory.getLogger(InsererBulletin.class);
    private final RemunerationEmployeRepository employeRepository;
    private final PeriodeRepository periodeRepository;
    private final BulletinSalaireRepository bulletinRepository;

    public InsererBulletin(
            PeriodeRepository periodeRepository,
            RemunerationEmployeRepository employeRepository,
            BulletinSalaireRepository bulletinRepository
    ) {
        this.employeRepository = employeRepository;
        this.periodeRepository = periodeRepository;
        this.bulletinRepository = bulletinRepository;
    }

    @PostConstruct
    public void insertionBulletin() {
        RemunerationEmploye remunerationEmploye = affectationEntity(employeRepository);
        Periode periode = affectationEntity(periodeRepository);
        BigDecimal primeExtra = BigDecimal.valueOf(new Random().nextInt(1000) + 1000);

        BulletinSalaire bulletin = new BulletinSalaire().setPeriode(periode)
                .setRemunerationEmploye(remunerationEmploye)
                .setPrimeExceptionnelle(primeExtra);
        bulletinRepository.save(bulletin);
        LOGGER.warn("\nCréation de la rémunération d'un bulletin,\n,  {}", bulletin);
    }
}
