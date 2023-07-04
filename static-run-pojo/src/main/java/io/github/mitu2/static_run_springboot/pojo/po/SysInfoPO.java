package io.github.mitu2.static_run_springboot.pojo.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chenmoand
 */
@Table(name = "sys_info")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysInfoPO extends AbstractEntity<Integer> implements Serializable {

    @Serial
    private static final long serialVersionUID = -8920945003406453892L;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String value;

    @Column
    private String targetClass;


}
