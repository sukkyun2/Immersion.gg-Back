package com.immersion.riot.userinfo.api;

import com.immersion.riot.userinfo.app.UserInfoResponse;
import com.immersion.riot.userinfo.app.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserInfoApi {

    private final UserInfoService userInfoService;

    @GetMapping("users/{summonerName}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable String summonerName) {

        UserInfoResponse userInfoResponse = userInfoService.getSummonerInfo(summonerName);

        return ResponseEntity.ok(userInfoResponse);
    }

    @GetMapping("users/{summonerName}/solorank")
    public ResponseEntity<String> getSoloRank(@PathVariable String summonerName) {

        return ResponseEntity.ok("");
    }

    @GetMapping("users/{summonerName}/flexrank")
    public ResponseEntity<String> getFlexRank(@PathVariable String summonerName) {

        return ResponseEntity.ok("");
    }
}
