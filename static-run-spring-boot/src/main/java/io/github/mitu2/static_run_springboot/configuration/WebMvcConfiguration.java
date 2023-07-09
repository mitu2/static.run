package io.github.mitu2.static_run_springboot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.controller.SysInfoController;
import io.github.mitu2.static_run_springboot.exception.ServerErrorRuntimeException;
import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.AccessDeniedException;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*.static.run:*")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*");
    }


}
