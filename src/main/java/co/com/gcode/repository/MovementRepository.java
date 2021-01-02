package co.com.gcode.repository;

import co.com.gcode.domain.Movement;
import co.com.gcode.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class MovementRepository {

    private static List<Movement> movements;
    private static Timestamp timestamp;
    private final Util util;

    static{
        timestamp = new Timestamp(System.currentTimeMillis());
        movements = new ArrayList<>(List.of(Movement.builder().id(1).description("Pago Servicios").ammount(150000).category("Servicios Publicos").timestamp(timestamp).build(),
                Movement.builder().id(2).description("Netflix").ammount(32000).category("Entretenimiento").timestamp(timestamp).build(),
                Movement.builder().id(3).description("Motilada").ammount(20000).category("Presentacion Personal").timestamp(timestamp).build()));
    }
    public List<Movement> getAllMovements(){
        return movements;
    }

    public Movement save(Movement movement){
        movement.setId(ThreadLocalRandom.current().nextInt());
        movements.add(movement);
        return movement;
    }

    public void delete(int id){
        movements.remove(util.foundMovementorThrowNotFoundException(id, movements));
    }

    public Movement findById(int id){
        return util.foundMovementorThrowNotFoundException(id, movements);
    }

    public void update(Movement movement){
        movements.remove(util.foundMovementorThrowNotFoundException(movement.getId(), movements));
        movements.add(movement);

    }

}
