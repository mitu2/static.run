package io.github.mitu2.static_run_springboot.configuration;

import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.controller.SysInfoController;
import io.github.mitu2.static_run_springboot.exception.ServerErrorRuntimeException;
import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @author chenmoand
 * @date 2023/7/9 11:53
 */
@RestControllerAdvice(basePackageClasses = SysInfoController.class)
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(ServerErrorRuntimeException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfoDTO doThrowableHandler(HttpServletResponse response, Throwable e) {
        if (e instanceof ServerErrorRuntimeException err) {
            response.setStatus(err.getHttpStatus().value());
            return err.getResultError();
        }
        if (e instanceof AccessDeniedException || e instanceof AuthenticationException) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return ErrorInfoDTO.fromErrorStatus(SystemErrorStatusEnum.NEED_LOGIN);
        }
        log.debug("unknown exception: " + e.getMessage(), e);
        return ErrorInfoDTO.fromErrorStatus(SystemErrorStatusEnum.UNKNOWN);
    }


}
