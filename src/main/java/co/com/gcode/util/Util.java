package co.com.gcode.util;

import co.com.gcode.domain.Movement;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class Util {


    public String formatLocalDateTimeToDataBaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }


    public Movement foundMovementorThrowNotFoundException(int id, List<Movement> movements){
        return movements
                .stream()
                .filter(m -> m.getId() == id )
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movement not found"));
    }
}
