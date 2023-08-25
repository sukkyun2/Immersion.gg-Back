package com.immersion.riot.userinfo.app;

import com.immersion.riot.userinfo.infra.client.UserInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IconImageUrlBuilderService {
    @Value("${riot.versions}")
    private String VERSION;

    @Value("${riot.api.url.cdn}")
    private String CDN_URL;

    public String getProfileImageUrl(int profileIconId) {
        return CDN_URL + VERSION + "/img/profileicon/" + profileIconId + ".png";
    }
}
