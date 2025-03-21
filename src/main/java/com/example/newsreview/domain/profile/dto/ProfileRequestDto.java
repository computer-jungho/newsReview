package com.example.newsreview.domain.profile.dto;

import lombok.Getter;

@Getter
public class ProfileRequestDto {
    private String userName;
    private String email;
    private String profileImgUrl;
    private String bio;
}
