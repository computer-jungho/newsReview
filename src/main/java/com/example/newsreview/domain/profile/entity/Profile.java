package com.example.newsreview.domain.profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Entity
@NoArgsConstructor
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String passWord;
    private String ProfileImgUrl;
    private String bio;

    public Profile(String userName, String email, String profileImgUrl, String bio) {
        this.userName = userName;
        this.email = email;
        this.ProfileImgUrl = profileImgUrl;
        this.bio = bio;
    }

    public void update(String userName, String email, String profileImgUrl, String bio) {
        this.userName = userName;
        this.email = email;
        ProfileImgUrl = profileImgUrl;
        this.bio = bio;
    }

    public void passWordUpdate(String passWord) {
        if (this.passWord == passWord) { //현 비밀번호와 변경 비밀번호가 같을 경우
            throw new IllegalStateException("현재 비밀번호와 같아서 변경 불가합니다.");
        } else {
            this.passWord = passWord;
        }
    }
}
