package com.example.newsreview.domain.profile.dto;

import lombok.Getter;

@Getter
public class ProfilePassWordUpdateRequestDto {
    private String userName;
    private String email;
    private String passWord;
    private String ProfileImgUrl;
    private String bio;
}
