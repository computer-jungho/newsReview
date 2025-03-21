package com.example.newsreview.domain.profile.controller;

import com.example.newsreview.common.consts.Const;
import com.example.newsreview.domain.profile.dto.ProfilePassWordUpdateRequestDto;
import com.example.newsreview.domain.profile.dto.ProfileRequestDto;
import com.example.newsreview.domain.profile.dto.ProfileResponseDto;
import com.example.newsreview.domain.profile.sevice.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/profiles/form")
    public ProfileResponseDto save (@RequestBody ProfileRequestDto dto) {
        return profileService.save(dto);
    }

    @GetMapping("/profiles")
    public List<ProfileResponseDto> getAll () {
        return profileService.findAll();
    }

    @GetMapping("/profiles/{profileId}")
    public ProfileResponseDto getOne (@PathVariable Long profileId) {
        return profileService.findById(profileId);
    }


    @PutMapping("/profiles/{profileId}") //프로필 변경
    public void update (@PathVariable Long profileId, @RequestBody ProfileRequestDto dto) {
        profileService.update(profileId, dto);
    }

    @PutMapping("/profiles/{profileId}/passWord") //비밀번호 변경
    public void passWordUpdate (@PathVariable Long profileId, @RequestBody ProfilePassWordUpdateRequestDto dto) {
        profileService.passWordUpdate(profileId, dto);
    }

    @DeleteMapping("/profiles/{profileId}")
    public void delete (@PathVariable Long profileId) {
        profileService.deleteById(profileId);
    }
}
