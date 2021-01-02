package co.com.gcode.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Movement {

    private int id;
    private String description;
    private double ammount;
    private String category;
    private Timestamp timestamp;

}
