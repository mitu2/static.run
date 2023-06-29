package io.github.mitu2.static_run_springboot.pojo.po;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * @author chenmoand
 */
@Table(name = "sys_info")
@Entity
@With
@AllArgsConstructor
@NoArgsConstructor
public class SysInfoPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String value;

}
