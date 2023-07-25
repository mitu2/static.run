package io.github.mitu2.static_run_springboot.pojo.dto;

import io.github.mitu2.static_run_springboot.pojo.Version;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chenmoand
 * @date 2023/7/9 21:06
 */
@Data
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = Version.SERIAL_VERSION;

    private Long id;
    private String name;
    private String avatarUrl;
    private String homepage;
    private String blog;
    private String email;

}
