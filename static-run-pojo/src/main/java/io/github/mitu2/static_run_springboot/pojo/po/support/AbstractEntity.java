package io.github.mitu2.static_run_springboot.pojo.po.support;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenmoand
 * @date 2023/7/2 21:08
 */
@MappedSuperclass
@Data
public abstract class AbstractEntity<PK extends Serializable> implements Persistable<PK> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;

    @Column(nullable = false)
    @Comment("创建时间")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column
    @Comment("最后更新时间")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
