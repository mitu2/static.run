package io.github.mitu2.static_run_springboot.service.impl;

import io.github.mitu2.static_run_springboot.exception.NotFoundRuntimeException;
import io.github.mitu2.static_run_springboot.pojo.po.UserPO;
import io.github.mitu2.static_run_springboot.repository.UserRepository;
import io.github.mitu2.static_run_springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author chenmoand
 * @date 2023/7/9 21:05
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserPO findById(Long id) {
        Assert.notNull(id, "id must not be null");
        Assert.state(id >= 0L, "id must greater than or equal 0");
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundRuntimeException("get user by id " + id + " fail"));
    }


}
