package io.github.mitu2.static_run_springboot.configuration.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

/**
 * @author chenmoand
 * @date 2023/7/9 11:54
 */
public class SimpleOauth2User implements OAuth2User {

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

}
