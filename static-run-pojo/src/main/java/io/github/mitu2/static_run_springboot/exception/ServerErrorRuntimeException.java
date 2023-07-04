package io.github.mitu2.static_run_springboot.exception;

import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Objects;

@ToString
public class ServerErrorRuntimeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2602279291434847764L;

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final ErrorInfoDTO resultError;

    public ServerErrorRuntimeException(ErrorInfoDTO resultError) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, resultError);
    }

    public ServerErrorRuntimeException(HttpStatus httpStatus, ErrorInfoDTO resultError) {
        this.httpStatus = Objects.requireNonNull(httpStatus);
        this.resultError = Objects.requireNonNull(resultError);
    }

}
