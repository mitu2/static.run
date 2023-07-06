package io.github.mitu2.static_run_springboot.configuration;

import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.controller.SysInfoController;
import io.github.mitu2.static_run_springboot.exception.ServerErrorRuntimeException;
import io.github.mitu2.static_run_springboot.pojo.dto.ErrorInfoDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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



    @RestControllerAdvice(basePackageClasses = SysInfoController.class)
    static class ExceptionControllerAdvice {

        @ExceptionHandler(Throwable.class)
        @ResponseBody
        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
        public ErrorInfoDTO doThrowableHandler(HttpServletResponse response, Throwable e) {
            if (e instanceof ServerErrorRuntimeException err) {
                response.setStatus(err.getHttpStatus().value());
                return err.getResultError();
            }
            return ErrorInfoDTO.fromErrorStatus(SystemErrorStatusEnum.UNKNOWN);
        }

    }


}
