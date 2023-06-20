package io.github.mitu2.static_run_springboot.pojo.dto;

import io.github.mitu2.static_run_springboot.constant.ErrorStatusInterface;
import io.github.mitu2.static_run_springboot.constant.SystemErrorStatusEnum;
import lombok.*;

import java.time.LocalDateTime;


@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultErrorDTO {

    private String errCode;
    private String errMessage;
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();
    private Object data;

    public static ResultErrorDTO fromErrorStatus(ErrorStatusInterface systemErrorStatusEnum) {
        return builder()
                .errCode(systemErrorStatusEnum.getCode())
                .errMessage(systemErrorStatusEnum.getDesc())
                .build();
    }

}
