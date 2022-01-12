package dev.paie.repository;

import dev.paie.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
    public Optional<Grade> findByCode(String code);
}
