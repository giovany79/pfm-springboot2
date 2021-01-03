package co.com.gcode.controller;

import co.com.gcode.domain.Movement;
import co.com.gcode.service.MovementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("pfm")
@Slf4j
@RequiredArgsConstructor
public class PfmController {

    private final MovementService movementRepository;

    @GetMapping(path= "/movements")
    public ResponseEntity<List<Movement>> allMovements(){
        return  ResponseEntity.ok(movementRepository.getAllMovements());
    }

    @GetMapping(path="/movement/{id}")
    public ResponseEntity<Movement> findById(@PathVariable int id){

        return ResponseEntity.ok(movementRepository.findById(id));
    }


    @PostMapping(path="/movement")
    public ResponseEntity<Movement> save(@RequestBody Movement movement){
        return  ResponseEntity.ok(movementRepository.save(movement));
    }

    @DeleteMapping(path="/movement/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        movementRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path="/movement/{id}")
    public ResponseEntity<Void> uptade(@RequestBody Movement movement){
        movementRepository.update(movement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
