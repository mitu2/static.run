package io.github.mitu2.static_run_springboot.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

    private final JdbcOAuth2UserService jdbcOAuth2UserService;
    private final SimpleAuthenticationEntryPoint simpleAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .oauth2Login(oauth -> oauth
                        .redirectionEndpoint(config -> config.baseUri("/authorized/{registrationId}"))
                        .userInfoEndpoint(config -> config.userService(jdbcOAuth2UserService))
                        .defaultSuccessUrl("/?loginSuccess")
                )
                .exceptionHandling(config -> config.authenticationEntryPoint(simpleAuthenticationEntryPoint))
                .build();
    }


}
