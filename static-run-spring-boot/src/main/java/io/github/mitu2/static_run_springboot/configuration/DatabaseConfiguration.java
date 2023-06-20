package io.github.mitu2.static_run_springboot.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenmoand
 */
@Configuration
@MapperScan("io.github.mitu2.static_run_springboot.mapper")
@EntityScan("io.github.mitu2.static_run_springboot.pojo.po")
@EnableJpaRepositories(basePackages = "io.github.mitu2.static_run_springboot.repository")
public class DatabaseConfiguration {


}
