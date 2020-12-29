package co.com.gcode.controller;

import co.com.gcode.domain.Movement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("pfm")
@Slf4j
@RequiredArgsConstructor
public class PfmController {

    @GetMapping(path= "/list")
    public List<Movement> AllMovements(){

        return Arrays.asList(
                Movement.builder().description("Pago Servicios").ammount(150000).category("Servicios Publicos").build(),
                Movement.builder().description("Netflix").ammount(32000).category("Entretenimiento").build(),
                Movement.builder().description("Motilada").ammount(20000).category("Presentacion Personal").build());
    }
}
