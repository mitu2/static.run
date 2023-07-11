package io.github.mitu2.static_run_springboot.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chenmoand
 * @date 2023/7/6 20:32
 */
@Data
public class SysConfigDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3427320076202591337L;


    /**
     * 安装时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime installDate;
    /**
     * 启动时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    /**
     * 最后一次关闭时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastStopDate;
    /**
     * 启动次数
     */
    private Long startUps;

}
