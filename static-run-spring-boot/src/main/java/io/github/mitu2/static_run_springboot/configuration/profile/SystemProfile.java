package io.github.mitu2.static_run_springboot.configuration.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenmoand
 * @date 2023/6/29 19:54
 */
@Data
@ConfigurationProperties(prefix = "system")
public class SystemProfile {

    /**
     * 配置文件存放路径
     */
    private String workDir;



}
