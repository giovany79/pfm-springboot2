package co.com.gcode.client;

import co.com.gcode.domain.Movement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class SpringClient {

    public static void main(String[] arg){
        ResponseEntity<Movement> movementResponseEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/pfm/movement/8", Movement.class);
        log.info("Response Entity{}", movementResponseEntity);
    }
}
