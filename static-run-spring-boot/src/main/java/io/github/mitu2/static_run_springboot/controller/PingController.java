package io.github.mitu2.static_run_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenmoand
 */
@Controller
public class PingController {

    @GetMapping(path = "ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

    @GetMapping(path = {"", "/", "index"})
    public String index() {
        return "index";
    }

}
