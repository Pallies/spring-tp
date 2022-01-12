package dev.paie.exec;

import dev.paie.entities.Grade;
import dev.paie.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Configuration
@PropertySource("classpath:grade.properties")
public class InsererGrade {
    private final Logger LOGGER = LoggerFactory.getLogger(InsererGrade.class);
    private final GradeRepository repository;

    @Value("${grade.code}")
    private List<String> code;
    @Value("${grade.base-heure}")
    private List<BigDecimal> nbHeuresBase;
    @Value("${grade.base-taux}")
    private List<BigDecimal> tauxBase;

    public InsererGrade(GradeRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void insertionGrade() {
        int len = code.size();
        if (len == nbHeuresBase.size() && len == tauxBase.size()) {
            for (int i = 0; i < len; i++) {
                // vérifie si le grade est en base de données
                Optional<Grade> isGrade = repository.findByCode(code.get(i));
                if (isGrade.isEmpty()) {
                    //insertion du nouveau grade
                    Grade grade = new Grade()
                            .setCode(code.get(i))
                            .setNbHeuresBase(nbHeuresBase.get(i))
                            .setTauxBase(tauxBase.get(i));
                    LOGGER.warn(" save : {}", repository.save(grade));
                }
            }
        }
    }
}
