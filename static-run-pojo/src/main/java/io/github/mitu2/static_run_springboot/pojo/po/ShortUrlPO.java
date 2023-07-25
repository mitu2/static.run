package io.github.mitu2.static_run_springboot.pojo.po;

import io.github.mitu2.static_run_springboot.pojo.Version;
import io.github.mitu2.static_run_springboot.pojo.po.support.TombstoneAbstractEntity;
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
 * @date 2023/7/25 20:08
 */
@Table(name = "short_url")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShortUrlPO extends TombstoneAbstractEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = Version.SERIAL_VERSION;

    @Column(length = 25565)
    private String url;

    @Column
    private String router;

    @Column
    private String bindDomain;


}
