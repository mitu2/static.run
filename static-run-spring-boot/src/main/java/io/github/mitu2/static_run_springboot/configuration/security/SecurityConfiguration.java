package io.github.mitu2.static_run_springboot.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .oauth2Login(oauth -> oauth
                        .redirectionEndpoint(config -> config.baseUri("/authorized/{registrationId}"))
                        .userInfoEndpoint(config -> config.userService(new DefaultOAuth2UserService()))
                )
                .build();
    }


}
