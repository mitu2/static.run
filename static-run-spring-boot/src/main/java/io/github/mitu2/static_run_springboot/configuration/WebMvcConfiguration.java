package io.github.mitu2.static_run_springboot.configuration;

import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import io.github.mitu2.static_run_springboot.exception.RequestFailureException;
import io.github.mitu2.static_run_springboot.pojo.dto.ResultErrorDTO;
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

    @Bean
    @Profile("dev")
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 修改为添加而不是设置，* 最好改为实际的需要，我这是非生产配置，所以粗暴了一点
        configuration.addAllowedOriginPattern("*");
        // 修改为添加而不是设置
        configuration.addAllowedMethod("*");
        // 这里很重要，起码需要允许 Access-Control-Allow-Origin
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
        return urlBasedCorsConfigurationSource;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedOriginPatterns("*.static.run");
    }

    @RestControllerAdvice(basePackages = "io.github.mitu2.static_run_springboot.controller")
    public static class RequestErrorControllerAdvice {

        @ExceptionHandler(Throwable.class)
        @ResponseBody
        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
        public ResultErrorDTO doThrowableHandler(HttpServletResponse response, Throwable e) {
            if (e instanceof RequestFailureException) {
                RequestFailureException exception = (RequestFailureException) e;
                response.setStatus(exception.getHttpStatus().value());
                return exception.getResultError();
            }
            return ResultErrorDTO.fromErrorStatus(SystemErrorStatusEnum.UNKNOWN);
        }

    }


}
