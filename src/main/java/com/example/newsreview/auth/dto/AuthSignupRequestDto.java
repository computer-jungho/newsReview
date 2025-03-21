package com.example.newsreview.auth.dto;

import lombok.Getter;

@Getter
public class AuthSignupRequestDto {
    private String userName;
    private String email;
    private String passWord;
    private String ProfileImgUrl;
    private String bio;
}
