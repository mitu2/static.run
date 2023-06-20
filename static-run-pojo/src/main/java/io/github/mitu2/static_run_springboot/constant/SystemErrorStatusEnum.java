package io.github.mitu2.static_run_springboot.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum SystemErrorStatusEnum implements ErrorStatusInterface {

    UNKNOWN("-1", "unknown status"),
    ;

    @Getter
    private final String code;
    @Getter
    private final String desc;

}
