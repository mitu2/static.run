package io.github.mitu2.static_run_springboot.configuration.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * @author chenmoand
 * @date 2023/7/9 11:54
 */
@RequiredArgsConstructor
public class SimpleOauth2User implements OAuth2User, Serializable {

    @Serial
    private static final long serialVersionUID = -8412480589691561497L;

    private final Collection<? extends GrantedAuthority> authorities;
    private final Map<String, Object> attributes;
    private final String name;
    @Getter
    private final Long id;

    public SimpleOauth2User(OAuth2User user, Long pkId) {
        this.attributes = user.getAttributes();
        this.authorities = user.getAuthorities();
        this.name = user.getName();
        this.id = pkId;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return name;
    }

}
