package co.com.gcode.controller;

import co.com.gcode.domain.Movement;
import co.com.gcode.service.MovementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pfm")
@Slf4j
@RequiredArgsConstructor
public class PfmController {

    private final MovementService movementservice;

    @GetMapping(path= "/movements")
    public ResponseEntity<Page<Movement>> allMovements(Pageable pageable){
        return  ResponseEntity.ok(movementservice.getAllMovements(pageable));
    }

    @GetMapping(path="/movement/{id}")
    public ResponseEntity<Movement> findById(@PathVariable int id){

        return ResponseEntity.ok(movementservice.findById(id));
    }


    @PostMapping(path="/movement")
    public ResponseEntity<Movement> save(@RequestBody @Valid Movement movement){
        return  ResponseEntity.ok(movementservice.save(movement));
    }

    @DeleteMapping(path="/movement/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id){
        movementservice.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path="/movement/{id}")
    public ResponseEntity<Void> uptade(@RequestBody Movement movement){
        movementservice.update(movement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="movement/find")
    public ResponseEntity<List<Movement>> findByName(@RequestParam(value="name")String name){
        return ResponseEntity.ok(movementservice.findByName(name));
    }
}
