package io.github.mitu2.static_run_springboot.service;

import io.github.mitu2.static_run_springboot.pojo.po.UserPO;

/**
 * @author chenmoand
 * @date 2023/7/9 21:05
 */
public interface UserService {
    UserPO findById(Long id);
}
