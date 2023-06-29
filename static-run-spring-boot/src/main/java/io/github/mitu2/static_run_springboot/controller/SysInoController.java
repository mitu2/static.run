package io.github.mitu2.static_run_springboot.controller;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("sys-info")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysInoController {

    private final SysInfoService sysInfoService;
    @GetMapping
    public Page<SysInfoPO> findAll(@PageableDefault Pageable pageable) {
        return sysInfoService.findAll(pageable);
    }


}
