package io.github.mitu2.static_run_springboot.repository;

import io.github.mitu2.static_run_springboot.pojo.po.UserPO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author chenmoand
 * @date 2023/7/9 20:19
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<UserPO, Long> {

    UserPO findByRegisterSourceAndRegisterSourceId(String registerSource, String registerSourceId);

}
