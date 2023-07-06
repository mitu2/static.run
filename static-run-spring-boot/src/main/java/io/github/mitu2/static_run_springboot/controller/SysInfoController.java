package io.github.mitu2.static_run_springboot.controller;

import io.github.mitu2.static_run_springboot.pojo.dto.SysConfigDTO;
import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(path = "sys-info")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysInfoController {

    private final SysInfoService sysInfoService;
    @GetMapping(path = "")
    public Page<SysInfoPO> findAll(@PageableDefault Pageable pageable) {
        return sysInfoService.findAll(pageable);
    }


    @GetMapping(path = "getSysConfig")
    public SysConfigDTO getSysConfig() {
        SysConfigDTO target = new SysConfigDTO();
        BeanUtils.copyProperties(sysInfoService.findSysConfig(), target);
        return target;
    }


}
