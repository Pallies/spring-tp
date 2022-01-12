package dev.paie.exec.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Random;

public abstract class Affectation {


    protected <T> T affectationEntity(JpaRepository<T, Integer> repository) {
        List<T> list = repository.findAll();
        int len = list.size();
        int nbreAlea = new Random().nextInt(len - 1);
        return  list.get(nbreAlea);
    }
}
