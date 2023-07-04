package io.github.mitu2.static_run_springboot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import io.github.mitu2.static_run_springboot.pojo.vo.SysConfigVO;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import io.github.mitu2.static_run_springboot.service.SysInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chenmoand
 * @date 2023/6/29 21:04
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysInfoServiceImpl implements SysInfoService {

    private final SysInfoRepository sysInfoRepository;
    private final ObjectMapper jsonMapper;

    @Override
    public Page<SysInfoPO> findAll(Pageable pageable) {
        return sysInfoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void insert(String name, String value, Class<?> targetClass) {
        Assert.notNull(name, "name must not be null");
        sysInfoRepository.save(new SysInfoPO(name, value, targetClass == null ? "" : targetClass.getName()));
    }


    @Override
    @Transactional
    public <T extends Serializable> void insertByObject(T obj) {
        Assert.notNull(obj, "obj must not be null");
        Map<String, String> map = jsonMapper.convertValue(obj, new TypeReference<>() {
        });

        map.forEach((name, value) -> {
            SysInfoPO source = sysInfoRepository.findByName(name);
            if (source == null) {
                insert(name, value, obj.getClass());
                return;
            }
            source.setValue(value);
            sysInfoRepository.save(source);
        });
    }

    @Override
    public SysConfigVO findSysConfig() {
        return Optional
                .ofNullable(findByTargetClass(SysConfigVO.class))
                .orElse(new SysConfigVO());
    }

    public <T extends Serializable> T findByTargetClass(Class<T> clz) {
        Assert.notNull(clz, "clz must not be null");
        String name = clz.getName();
        Map<String, String> map = Optional.ofNullable(sysInfoRepository.findByTargetClass(name))
                .orElse(Collections.emptyList())
                .stream()
                .filter(it -> it.getValue() != null)
                .collect(Collectors.toMap(SysInfoPO::getName, SysInfoPO::getValue, (pre, next) -> pre, HashMap::new));

        return jsonMapper.convertValue(map, clz);
    }

}
