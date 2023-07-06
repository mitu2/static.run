package io.github.mitu2.static_run_springboot.configuration;

import io.github.mitu2.static_run_springboot.mapper.SysInfoMapper;
import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chenmoand
 */
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@MapperScan(basePackageClasses = SysInfoMapper.class)
@EntityScan(basePackageClasses = SysInfoPO.class)
@EnableJpaRepositories(basePackageClasses = SysInfoRepository.class)
public class DatabaseConfiguration {


}
