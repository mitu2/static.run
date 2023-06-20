package io.github.mitu2.static_run_springboot.repository;

import io.github.mitu2.static_run_springboot.pojo.po.SystemConfigInfoPO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author chenmoand
 */
@Repository
public interface SystemConfigInfoRepository extends JpaRepositoryImplementation<SystemConfigInfoPO, Integer> {
}
