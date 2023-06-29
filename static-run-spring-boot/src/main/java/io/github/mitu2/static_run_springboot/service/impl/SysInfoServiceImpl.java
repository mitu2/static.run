package io.github.mitu2.static_run_springboot.service.impl;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author chenmoand
 * @date 2023/6/29 21:04
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysInfoServiceImpl implements SysInfoService {

    private final SysInfoRepository sysInfoRepository;

    @Override
    public Page<SysInfoPO> findAll(Pageable pageable) {
        return sysInfoRepository.findAll(pageable);
    }

}
