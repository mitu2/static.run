package io.github.mitu2.static_run_springboot.controller;

import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.exception.RequestFailureException;
import io.github.mitu2.static_run_springboot.pojo.dto.ResultErrorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenmoand
 */
@RestController
public class PingController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("test-error")
    public void error(){
        throw new RequestFailureException(ResultErrorDTO.fromErrorStatus(SystemErrorStatusEnum.UNKNOWN));
    }

}
