package com.immersion.riot.userinfo.api;

import com.immersion.riot.userinfo.app.UserInfoService;
import com.immersion.riot.userinfo.infra.client.UserInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserInfoApi {

    private final UserInfoService userInfoService;

    @GetMapping("user/{puuid}")
    public ResponseEntity<String> getUserInfo() {

        return ResponseEntity.ok("");
    }
}
