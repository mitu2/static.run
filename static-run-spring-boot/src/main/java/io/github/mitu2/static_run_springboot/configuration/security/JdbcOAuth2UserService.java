package io.github.mitu2.static_run_springboot.configuration.security;

import io.github.mitu2.static_run_springboot.pojo.po.UserPO;
import io.github.mitu2.static_run_springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author chenmoand
 * @date 2023/7/9 11:48
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class JdbcOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String clientId = userRequest.getClientRegistration().getClientName();
        String id = String.valueOf(oAuth2User.getAttributes().get("id"));
        if ("null".equals(id)) {
            throw new OAuth2AuthenticationException("client (" + clientId + ") id not found");
        }
        UserPO po = userRepository.findByRegisterSourceAndRegisterSourceId(clientId, id);
        if (po == null) {
            return new SimpleOauth2User(oAuth2User, addUserAndReturnId(oAuth2User, clientId, id));
        }
        return new SimpleOauth2User(oAuth2User, po.getId());
    }

    private Long addUserAndReturnId(OAuth2User oAuth2User, String registerSource, String registerSourceId) {
        UserPO po = new UserPO();
        po.setRegisterSource(registerSource);
        po.setRegisterSourceId(registerSourceId);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        switch (registerSource) {
            case "gitee" -> {
                po.setEmail(getAttr(attributes, "email"));
                po.setBlog(getAttr(attributes, "blog"));
                po.setAvatarUrl(getAttr(attributes, "avatar_url"));
                po.setName(getAttr(attributes, "name"));
                po.setHomepage(getAttr(attributes, "html_url"));
            }
            case "github" -> {
            }
            default -> throw new IllegalArgumentException("registerSource " + registerSource + " illegality");
        }
        return userRepository.save(po).getId();
    }

    private String getAttr(Map<String, Object> attributes, String attrName) {
        Object o = attributes.get(attrName);
        if (o == null) {
            return null;
        }
        return String.valueOf(o);
    }

}
