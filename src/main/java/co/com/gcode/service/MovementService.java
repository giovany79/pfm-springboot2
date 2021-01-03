package co.com.gcode.service;

import co.com.gcode.domain.Movement;
import co.com.gcode.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovementService {


    private final MovementRepository movementRepository;


    public List<Movement> getAllMovements(){
        return movementRepository.findAll();
    }

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }

    public void delete(int id){
        movementRepository.delete(findById(id));
    }

    public Movement findById(int id){
        return movementRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movement Not Found"));
    }

    public void update(Movement movement){
        movementRepository.save(movement);

    }

    public List<Movement> findByName(String name){
        return movementRepository.findByName(name);
    }

}
