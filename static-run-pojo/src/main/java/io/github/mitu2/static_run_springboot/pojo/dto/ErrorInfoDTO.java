package io.github.mitu2.static_run_springboot.pojo.dto;

import io.github.mitu2.static_run_springboot.constant.ErrorStatusInterface;
import io.github.mitu2.static_run_springboot.pojo.Version;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = Version.SERIAL_VERSION;

    private String errCode;
    private String errMessage;
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();
    private Object data;

    public static ErrorInfoDTO fromErrorStatus(ErrorStatusInterface systemErrorStatusEnum) {
        return builder()
                .errCode(systemErrorStatusEnum.getCode())
                .errMessage(systemErrorStatusEnum.getDesc())
                .build();
    }

}
