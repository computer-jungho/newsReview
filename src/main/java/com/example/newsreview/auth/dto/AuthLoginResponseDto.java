package com.example.newsreview.auth.dto;

import lombok.Getter;

@Getter
public class AuthLoginResponseDto {
    private final Long profileId;

    public AuthLoginResponseDto(Long profileId) {
        this.profileId = profileId;
    }
}
