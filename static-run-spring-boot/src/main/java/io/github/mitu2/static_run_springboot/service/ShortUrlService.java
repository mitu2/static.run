package io.github.mitu2.static_run_springboot.service;

import io.github.mitu2.static_run_springboot.pojo.vo.GenerateShortUrlInfoVO;

/**
 * @author chenmoand
 * @date 2023/7/25 20:40
 */
public interface ShortUrlService {

    void generateShortUrl(GenerateShortUrlInfoVO vo);

    boolean existsByBindDomainAndRouter(String bindDomain, String router);

}
