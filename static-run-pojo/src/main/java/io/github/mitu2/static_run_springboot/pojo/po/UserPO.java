package io.github.mitu2.static_run_springboot.pojo.po;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chenmoand
 */
@Entity
@Table(name = "user")
@Comment("用户表")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPO extends AbstractEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -8780281342432446014L;


    @Column
    @Comment("用户名")
    private String name;

    @Column
    @Comment("头像")
    private String avatarUrl;

    @Column
    @Comment("博客地址")
    private String blog;

    @Column
    @Comment("邮箱地址")
    private String email;

    @Column
    @Comment("通过Oauth2注册的关联ID")
    private String registerSourceId;

    @Column(length = 80)
    @Comment("通过Oauth2注册的关联类型")
    private String registerSource;


}
