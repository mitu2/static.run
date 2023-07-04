package io.github.mitu2.static_run_springboot.pojo.dto;

import io.github.mitu2.static_run_springboot.constant.ErrorStatusInterface;
import lombok.*;

import java.time.LocalDateTime;


@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfoDTO {

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
