package io.github.mitu2.static_run_springboot.controller;

import io.github.mitu2.static_run_springboot.pojo.po.SystemConfigInfoPO;
import io.github.mitu2.static_run_springboot.repository.SystemConfigInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenmoand
 */
@RestController
@RequestMapping("system-config")
public class SystemConfigController {

    @Autowired
    private SystemConfigInfoRepository systemConfigInfoRepository;

    @GetMapping
    public Page<SystemConfigInfoPO> findAll(@PageableDefault Pageable pageable) {
        return systemConfigInfoRepository.findAll(pageable);
    }


}
