package co.com.gcode.service;

import co.com.gcode.domain.Movement;
import co.com.gcode.repository.MovementRepository;
import co.com.gcode.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {


    private final MovementRepository movementRepository;
    private static Timestamp timestamp;
    private final Util util;


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

}
