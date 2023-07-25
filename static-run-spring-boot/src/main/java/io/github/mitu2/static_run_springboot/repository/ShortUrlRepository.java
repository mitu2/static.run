package io.github.mitu2.static_run_springboot.repository;

import io.github.mitu2.static_run_springboot.pojo.po.ShortUrlPO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author chenmoand
 * @date 2023/7/25 20:37
 */
@Repository
public interface ShortUrlRepository extends JpaRepositoryImplementation<ShortUrlPO, Integer> {

    boolean existsByBindDomainAndRouter(String bindDomain, String router);

}
