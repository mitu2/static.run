package io.github.mitu2.static_run_springboot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.pojo.vo.SysConfigVO;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

/**
 * @author chenmoand
 * @date 2023/6/29 20:52
 */
@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationListenerConfiguration {

    private final SysInfoService sysInfoService;

    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener() {
        return e -> {
            SysConfigVO sysConfig = sysInfoService.findSysConfig();

            long startUps = Optional.ofNullable(sysConfig.getStartUps())
                    .orElse(0L);

            // 启动次数 + 1
            sysConfig.setStartUps(startUps + 1);

            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(e.getTimestamp()), ZoneId.systemDefault());
            // 安装时间
            if (sysConfig.getInstallDate() == null) {
                sysConfig.setInstallDate(date);
            }

            // 启动时间
            sysConfig.setStartDate(date);
            sysInfoService.insertByObject(sysConfig);
        };
    }

    @Bean
    public ApplicationListener<ContextClosedEvent> contextClosedEventApplicationListener() {
        return e -> {
            SysConfigVO sysConfig = sysInfoService.findSysConfig();
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(e.getTimestamp()), ZoneId.systemDefault());
            // 关闭时间
            sysConfig.setLastStopDate(date);
            sysInfoService.insertByObject(sysConfig);
        };
    }

}
