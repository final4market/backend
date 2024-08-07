package com.market.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class OAuthController {
	
	@Value("${naver.client-id}")
    private String naverClientId;

    @Value("${naver.callback-url}")
    private String naverCallbackUrl;

    @Value("${naver.service-url}")
    private String naverServiceUrl;

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;
    
    @GetMapping("/api/auth/naver")
    public String naverLogin() {
        String authUrl = UriComponentsBuilder.fromHttpUrl("https://nid.naver.com/oauth2.0/authorize")
                .queryParam("response_type", "token")
                .queryParam("client_id", naverClientId)
                .queryParam("redirect_uri", naverCallbackUrl)
                .queryParam("state", "yours_truly_lucky_market")
                .toUriString();
        return "redirect:" + authUrl;
    }
    
    @GetMapping("/api/auth/naver/callback")
    public String naverCallback(String access_token) {
        return "redirect:https://lucky4market.vercel.app/naverAuthCallback?access_token=" + access_token;
    }

    @GetMapping("/api/auth/kakao")
    public String kakaoLogin() {
        String authUrl = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", kakaoClientId)
                .queryParam("redirect_uri", kakaoRedirectUri)
                .toUriString();
        return "redirect:" + authUrl;
    }

    @GetMapping("/api/auth/kakao/callback")
    public String kakaoCallback(@RequestParam String code) {
        RestTemplate restTemplate = new RestTemplate();

        String tokenUrl = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/token")
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", kakaoClientId)
                .queryParam("redirect_uri", kakaoRedirectUri)
                .queryParam("code", code)
                .toUriString();

        String response = restTemplate.postForObject(tokenUrl, null, String.class);

        // 토큰 추출
        String accessToken = extractAccessTokenFromResponse(response);

        // 코튼 정보 프론트로 전달
        return "redirect:https://lucky4market.vercel.app/kakaoAuthCallback?access_token=" + accessToken;
    }

    private String extractAccessTokenFromResponse(String response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            return rootNode.path("access_token").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}