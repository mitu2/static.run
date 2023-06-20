package io.github.mitu2.static_run_springboot.exception;

import io.github.mitu2.static_run_springboot.pojo.dto.ResultErrorDTO;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@ToString
public class RequestFailureException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final ResultErrorDTO resultError;

    public RequestFailureException(ResultErrorDTO resultError) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, resultError);
    }

    public RequestFailureException(HttpStatus httpStatus, ResultErrorDTO resultError) {
        this.httpStatus = Objects.requireNonNull(httpStatus);
        this.resultError = Objects.requireNonNull(resultError);
    }

}
