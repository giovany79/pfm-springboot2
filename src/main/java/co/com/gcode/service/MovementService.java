package co.com.gcode.service;

import co.com.gcode.domain.Movement;
import co.com.gcode.exception.ResourceNotFoundException;
import co.com.gcode.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovementService {


    private final MovementRepository movementRepository;


    public Page<Movement> getAllMovements(Pageable pageable){

        return movementRepository.findAll(pageable);
    }

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }

    public void delete(int id){
        movementRepository.delete(findById(id));
    }

    public Movement findById(int id){
        return movementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movement Not Found"));
    }

    public void update(Movement movement){
        movementRepository.save(movement);

    }

    public List<Movement> findByName(String name){

        return movementRepository.findByName(name);
    }

}
