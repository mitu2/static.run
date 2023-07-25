package io.github.mitu2.static_run_springboot.service.impl;

import io.github.mitu2.static_run_springboot.pojo.po.ShortUrlPO;
import io.github.mitu2.static_run_springboot.pojo.vo.GenerateShortUrlInfoVO;
import io.github.mitu2.static_run_springboot.repository.ShortUrlRepository;
import io.github.mitu2.static_run_springboot.service.ShortUrlService;
import io.github.mitu2.static_run_springboot.util.KeyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenmoand
 * @date 2023/7/25 20:40
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public void generateShortUrl(GenerateShortUrlInfoVO vo) {
        ShortUrlPO po = new ShortUrlPO();
        po.setBindDomain(vo.getBindDomain());
        po.setUrl(vo.getUrl());
        String router = switch (vo.getMode()) {
            case DEFAULT -> KeyUtils.randomKey(1, 1) + "/" + KeyUtils.randomKey(1, 8);
            case CUSTOM -> vo.getCustomPath();
            case SPECIAL -> KeyUtils.randomKey(1, 1) + "/" + KeyUtils.unicodeRandomKey(1, 100);
        };
        po.setRouter(router);
        shortUrlRepository.save(po);
    }


    @Override
    public boolean existsByBindDomainAndRouter(String bindDomain, String router) {
        return shortUrlRepository.existsByBindDomainAndRouter(bindDomain, router);
    }


}
