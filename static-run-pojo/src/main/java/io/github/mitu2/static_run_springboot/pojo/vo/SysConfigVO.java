package io.github.mitu2.static_run_springboot.pojo.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chenmoand
 * @date 2023/6/29 21:12
 */
@Data
public class SysConfigVO implements Serializable {


    @Serial
    private static final long serialVersionUID = -5226152751330452972L;

    /**
     * 安装时间
     */
    private LocalDateTime installDate;
    /**
     * 启动时间
     */
    private LocalDateTime startDate;
    /**
     * 最后一次关闭时间
     */
    private LocalDateTime lastStopDate;
    /**
     * 启动次数
     */
    private Long startUps;



}
