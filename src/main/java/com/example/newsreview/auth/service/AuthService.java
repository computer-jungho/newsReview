package com.example.newsreview.auth.service;

import com.example.newsreview.auth.dto.AuthLoginRequestDto;
import com.example.newsreview.auth.dto.AuthLoginResponseDto;
import com.example.newsreview.auth.dto.AuthSignupRequestDto;
import com.example.newsreview.domain.profile.entity.Profile;
import com.example.newsreview.domain.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ProfileRepository profileRepository;


    public void save(AuthSignupRequestDto dto) {
        Profile profile = new Profile();
        profileRepository.save(profile);
    }

    public AuthLoginResponseDto login(AuthLoginRequestDto dto) {
        Profile profile = profileRepository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 아이디(이메일) 입니다.")
        );
        return new AuthLoginResponseDto(profile.getId());
    }
}
