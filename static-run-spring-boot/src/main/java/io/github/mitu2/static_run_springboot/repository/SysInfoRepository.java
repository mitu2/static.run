package io.github.mitu2.static_run_springboot.repository;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author chenmoand
 */
@Repository
public interface SysInfoRepository extends JpaRepositoryImplementation<SysInfoPO, Integer> {
}
