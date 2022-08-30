package com.example.jwtspringsecurity.dto;

import lombok.*;

//토큰의 값을 헤더에서 get,set
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}