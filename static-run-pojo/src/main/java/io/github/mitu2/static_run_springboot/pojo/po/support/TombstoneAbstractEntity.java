package io.github.mitu2.static_run_springboot.pojo.po.support;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

/**
 * 支持逻辑删除的实体类
 *
 * @author chenmoand
 * @date 2023/7/25 20:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class TombstoneAbstractEntity<PK extends Serializable> extends AbstractEntity<PK> {

    @Column(nullable = false)
    @ColumnDefault("0")
    @Comment("是否被删除(0:否,1:是)")
    private boolean isDelete;

}
