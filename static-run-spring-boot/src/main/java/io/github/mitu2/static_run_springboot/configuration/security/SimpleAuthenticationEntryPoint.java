package io.github.mitu2.static_run_springboot.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author chenmoand
 * @date 2023/7/9 11:50
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper jsonMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpStatus.FORBIDDEN.value());
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try (ServletOutputStream os = response.getOutputStream()) {
            jsonMapper.writeValue(os, ErrorInfoDTO.fromErrorStatus(SystemErrorStatusEnum.NEED_LOGIN));
        }

    }

}
