package com.example.newsreview.domain.profile.sevice;

import com.example.newsreview.domain.profile.dto.ProfilePassWordUpdateRequestDto;
import com.example.newsreview.domain.profile.dto.ProfileRequestDto;
import com.example.newsreview.domain.profile.dto.ProfileResponseDto;
import com.example.newsreview.domain.profile.entity.Profile;
import com.example.newsreview.domain.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Transactional
    public ProfileResponseDto save(ProfileRequestDto dto) {
        Profile profile = new Profile(dto.getUserName(),
                dto.getEmail(),  dto.getProfileImgUrl(), dto.getBio());
        Profile savedProfile = profileRepository.save(profile);

        return new ProfileResponseDto(savedProfile.getId(), savedProfile.getUserName(),
                savedProfile.getEmail(), savedProfile.getProfileImgUrl(), savedProfile.getBio());
    }

    @Transactional(readOnly = true)
    public List<ProfileResponseDto> findAll() {
        List<Profile> profiles = profileRepository.findAll();

        List<ProfileResponseDto> dtos = new ArrayList<>();

        for (Profile profile : profiles) {
            dtos.add(new ProfileResponseDto(profile.getId(), profile.getUserName(),
                    profile.getEmail(), profile.getProfileImgUrl(), profile.getBio()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ProfileResponseDto findById(Long profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );
        return new ProfileResponseDto(profile.getId(), profile.getUserName(), profile.getEmail(),
                profile.getProfileImgUrl(), profile.getBio());
    }

    @Transactional
    public void update(Long id, ProfileRequestDto dto) {
        Profile profile = profileRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );
        profile.update(dto.getUserName(), dto.getEmail(), dto.getProfileImgUrl(), dto.getBio());
    }

    @Transactional
    public void passWordUpdate(Long profileId, ProfilePassWordUpdateRequestDto dto) { //비밀 번호 변경
        Profile profile = profileRepository.findById(profileId).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );
        if (!profile.getPassWord().equals(dto.getPassWord())) { //현재 비밀번호와 달라서 비밀번호 변경 불가
            throw new IllegalStateException("현 비밀번호 오류로 인해 비밀번호 변경이 불가합니다.");
        }
        profile.passWordUpdate(dto.getPassWord());
    }

    @Transactional
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }


}
