package dev.mission.repository;

import dev.mission.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Integer> {

}
