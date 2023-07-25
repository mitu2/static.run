package io.github.mitu2.static_run_springboot.pojo.po;

import io.github.mitu2.static_run_springboot.pojo.po.support.AbstractEntity;
import io.github.mitu2.static_run_springboot.pojo.po.support.TombstoneAbstractEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author chenmoand
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "leave_message")
@Data
public class LeaveMessagePO extends TombstoneAbstractEntity<Long> implements Serializable {


    @Serial
    private static final long serialVersionUID = io.github.mitu2.static_run_springboot.pojo.Version.SERIAL_VERSION;

    @Column
    private Long parentId;

    @Column(length = 3000)
    @Comment("消息内容")
    private String content;

    @Column
    @Version
    private Integer version;

    @CreatedBy
    @OneToOne(targetEntity = UserPO.class)
    @JoinColumn(name = "created_by", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserPO createdUser;

    @Transient
    @ToString.Exclude
    @OneToMany(mappedBy = "parentId", targetEntity = LeaveMessagePO.class)
    private transient List<LeaveMessagePO> child;


}
