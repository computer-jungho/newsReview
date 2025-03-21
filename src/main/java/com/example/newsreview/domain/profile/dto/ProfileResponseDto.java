package com.example.newsreview.domain.profile.dto;

import lombok.Getter;

@Getter
public class ProfileResponseDto {
    private final Long id;
    private final String userName;
    private final String email;
    private final String ProfileImgUrl;
    private final String bio;

    public ProfileResponseDto(Long id, String userName, String email, String profileImgUrl, String bio) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        ProfileImgUrl = profileImgUrl;
        this.bio = bio;
    }
}
