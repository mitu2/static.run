package io.github.mitu2.static_run_springboot.service;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenmoand
 * @date 2023/6/29 21:04
 */
public interface SysInfoService {
    Page<SysInfoPO> findAll(Pageable pageable);

}
