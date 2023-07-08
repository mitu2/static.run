package io.github.mitu2.static_run_springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenmoand
 * @date 2023/7/8 17:15
 */
@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping(path = "getLoginUserInfo")
    @PreAuthorize("isAuthenticated()")
    public Object getLoginUserInfo() {
        return null;
    }


}
