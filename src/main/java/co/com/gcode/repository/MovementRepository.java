package co.com.gcode.repository;

import co.com.gcode.domain.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

    List<Movement> findByName(String name);
}
