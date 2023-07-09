package io.github.mitu2.static_run_springboot.pojo.dto;

import lombok.Data;

/**
 * @author chenmoand
 * @date 2023/7/9 21:06
 */
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String avatarUrl;
    private String homepage;
    private String blog;
    private String email;

}
