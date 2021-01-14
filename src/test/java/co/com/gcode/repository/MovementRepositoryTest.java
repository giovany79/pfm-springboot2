package co.com.gcode.repository;

import co.com.gcode.domain.Movement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@DisplayName("Movement Repository Test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MovementRepositoryTest {

    @Autowired
    private MovementRepository movementRepository;

    @Test
    @DisplayName("Create a movement when successful")
    public void Save_Persistence_Movement_When_Successful(){
        Movement movement = createMovement();

        Movement savedMovement = this.movementRepository.save(movement);
        Assertions.assertThat(savedMovement.getId()).isNotNull();
        Assertions.assertThat(savedMovement.getName()).isNotNull();
        Assertions.assertThat(savedMovement.getName()).isEqualTo(movement.getName());
    }

    @Test
    @DisplayName("Update a movement when successful")
    public void Update_Persistence_Movement_When_Successful(){
        Movement movement = createMovement();

        Movement savedMovement = this.movementRepository.save(movement);

        savedMovement.setName("Matricula a Santi en el Colombo Americano");

        Movement updatedMovement = this.movementRepository.save(savedMovement);

        Assertions.assertThat(savedMovement.getId()).isNotNull();
        Assertions.assertThat(savedMovement.getName()).isNotNull();
        Assertions.assertThat(savedMovement.getName()).isEqualTo(updatedMovement.getName());
    }

    private Movement createMovement(){
        return Movement.builder().name("Pago Colombo").ammount(440000).category("Educacion").build();
    }
}