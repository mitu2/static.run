package io.github.mitu2.static_run_springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.configuration.security.SimpleOauth2User;
import io.github.mitu2.static_run_springboot.pojo.dto.UserDTO;
import io.github.mitu2.static_run_springboot.pojo.po.UserPO;
import io.github.mitu2.static_run_springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenmoand
 * @date 2023/7/8 17:15
 */
@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final UserService userService;
    private final ObjectMapper jsonMapper;

    @GetMapping(path = "getLoginUserInfo")
    @PreAuthorize("isAuthenticated()")
    public UserDTO getLoginUserInfo() {
        SimpleOauth2User principal = (SimpleOauth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPO po = userService.findById(principal.getId());
        return jsonMapper.convertValue(po, UserDTO.class);
    }


}
