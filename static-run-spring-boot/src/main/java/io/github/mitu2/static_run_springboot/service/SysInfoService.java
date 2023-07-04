package io.github.mitu2.static_run_springboot.service;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.pojo.vo.SysConfigVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author chenmoand
 * @date 2023/6/29 21:04
 */
public interface SysInfoService {
    Page<SysInfoPO> findAll(Pageable pageable);

    void insert(String name, String value, Class<?> targetClass);

    <T extends Serializable> void insertByObject(T obj);

    SysConfigVO findSysConfig();

}
