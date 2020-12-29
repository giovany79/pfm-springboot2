package co.com.gcode.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Movement {

    public String description;
    public double ammount;
    public String category;
    public Date date;

}
