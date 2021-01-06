package co.com.gcode.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
//@SuperBuilder
public class ValidateExceptionDetail  extends ExceptionDetails {

    private String fields;
    private String fieldsMessages;
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;

}
