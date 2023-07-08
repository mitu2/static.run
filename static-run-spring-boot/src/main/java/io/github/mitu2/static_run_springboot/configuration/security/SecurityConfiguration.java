package io.github.mitu2.static_run_springboot.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import jakarta.servlet.ServletOutputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author chenmoand
 * @date 2023/7/6 20:26
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SecurityConfiguration {

    private final ObjectMapper jsonMapper;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .oauth2Login(oauth -> oauth
                        .redirectionEndpoint(config -> config.baseUri("/authorized/{registrationId}"))
                        .userInfoEndpoint(config -> config.userService(new DefaultOAuth2UserService()))
                        .defaultSuccessUrl("/?loginSuccess")
                )
                .exceptionHandling(config -> config
                        .authenticationEntryPoint(((request, response, accessDeniedException) -> {
                            response.setStatus(HttpStatus.FORBIDDEN.value());
                            request.setCharacterEncoding("utf-8");
                            response.setContentType("application/json");
                            try (ServletOutputStream os = response.getOutputStream()) {
                                jsonMapper.writeValue(os, ErrorInfoDTO.fromErrorStatus(SystemErrorStatusEnum.NEED_LOGIN));
                            }
                        })))
                .build();
    }


}
