package io.github.mitu2.static_run_springboot.pojo.vo;

import io.github.mitu2.static_run_springboot.constant.Patterns;
import io.github.mitu2.static_run_springboot.constant.ShortUrlMode;
import io.github.mitu2.static_run_springboot.pojo.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chenmoand
 * @date 2023/7/18 20:33
 */
@Data
public class GenerateShortUrlInfoVO implements Serializable {

    @Serial
    private static final long serialVersionUID = Version.SERIAL_VERSION;

    @Pattern(regexp = Patterns.URL_REGEXP)
    private String url;

    @NotNull
    private String bindDomain;

    private String customPath;

    @NotNull
    private ShortUrlMode mode;

}
