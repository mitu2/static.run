package io.github.mitu2.static_run_springboot.configuration.profile;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenmoand
 * @date 2023/6/29 19:56
 */
@EnableConfigurationProperties
@Configuration
@ConfigurationPropertiesScan(basePackages = "io.github.mitu2.static_run_springboot.configuration.profile")
public class ProfileConfiguration {
}
