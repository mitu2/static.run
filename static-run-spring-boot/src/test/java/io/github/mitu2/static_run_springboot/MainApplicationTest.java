package io.github.mitu2.static_run_springboot;

import io.github.mitu2.static_run_springboot.mapper.SysInfoMapper;
import io.github.mitu2.static_run_springboot.repository.SysInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

/**
 * @author chenmoand
 * @date 2023/6/12 20:10
 */
@SpringBootTest(properties = {
//        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class MainApplicationTest {

    @Test
    public void testCase() {

    }


}
