package com.example.BookHub.Security.OAuth2.UserInfo;

import java.util.Map;

public class KaKaoOAuth2UserInfo extends OAuth2UserInfo{

    public KaKaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public String getName() {
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");
        if (account == null || profile == null) {
            return null;
        }
        return (String) profile.get("nickname");
    }

    @Override
    public String getEmail() {
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
        if(account == null) {
            return null;
        }
        return (String) account.get("email");
    }
}
