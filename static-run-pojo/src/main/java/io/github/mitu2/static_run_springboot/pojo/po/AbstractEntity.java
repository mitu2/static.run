package io.github.mitu2.static_run_springboot.pojo.po;

import jakarta.persistence.*;
import lombok.Data;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
