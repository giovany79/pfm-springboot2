package co.com.gcode.exception;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ExceptionDetails {
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;
}
