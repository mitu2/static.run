package io.github.mitu2.static_run_springboot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenmoand
 * @date 2023/6/29 20:52
 */
@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationListenerConfiguration {

    private final ObjectMapper jsonMapper;
    private final SysInfoService sysInfoService;

    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener() {
        return e -> {

        };
    }

}
