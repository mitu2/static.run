package io.github.mitu2.static_run_springboot.constant;

/**
 * @author chenmoand
 * @date 2023/6/11 20:29
 */
public interface ErrorStatusInterface {

    String getCode();

    String getDesc();

    static ErrorStatusInterface zip(ErrorStatusInterface... interfaces) {
        StringBuilder code = new StringBuilder(), desc = new StringBuilder();
        for (ErrorStatusInterface statusInterface : interfaces) {
            code.append(statusInterface.getCode());
            desc.append(statusInterface.getDesc());
        }
        return new ErrorStatusInterface() {
            @Override
            public String getCode() {
                return code.toString();
            }

            @Override
            public String getDesc() {
                return desc.toString();
            }
        };
    }

}
