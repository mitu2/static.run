package io.github.mitu2.static_run_springboot.repository;

import io.github.mitu2.static_run_springboot.pojo.po.SysInfoPO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenmoand
 */
@Repository
public interface SysInfoRepository extends JpaRepositoryImplementation<SysInfoPO, Integer> {

    List<SysInfoPO> findByTargetClass(@Param("targetClass") String targetClass);

    SysInfoPO findByName(@Param("name") String name);

}
