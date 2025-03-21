package com.example.newsreview.domain.post.sevice;

import com.example.newsreview.domain.base.dto.AuthorDto;
import com.example.newsreview.domain.post.dto.PostRequestDto;
import com.example.newsreview.domain.post.dto.PostResponseDto;
import com.example.newsreview.domain.post.entity.Post;
import com.example.newsreview.domain.post.repository.PostLikeRepository;
import com.example.newsreview.domain.post.repository.PostRepository;
import com.example.newsreview.domain.profile.entity.Profile;
import com.example.newsreview.domain.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final PostLikeRepository postLikeRepository;

    @Transactional
    public PostResponseDto save(Long userId, PostRequestDto dto) {
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );
        Post post = new Post(profile, dto.getContent());
        Post savedPost = postRepository.save(post);
        AuthorDto author = new AuthorDto(profile.getId(), profile.getUserName(), profile.getProfileImgUrl());

        return new PostResponseDto(savedPost.getId(), savedPost.getContent(), author,
                savedPost.getLikeCount(), savedPost.getCommentCount(), savedPost.getViewCount(),
                savedPost.getCreatedAt(), savedPost.getUpdated());

    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();

        List<PostResponseDto> dtos = new ArrayList<>();

        for (Post post : posts) {
            //post의 작성자(author) 객체 생성해주기...
            AuthorDto author = new AuthorDto(post.getProfile().getId(),
                    post.getProfile().getUserName(), post.getProfile().getProfileImgUrl());

            dtos.add(new PostResponseDto(post.getId(), post.getContent(), author,
                    post.getLikeCount(), post.getCommentCount(), post.getViewCount(),
                    post.getCreatedAt(), post.getUpdated()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글을 조회하지 못했습니다.")
        );

        AuthorDto author = new AuthorDto(post.getProfile().getId(),
                post.getProfile().getUserName(), post.getProfile().getProfileImgUrl());

        return new PostResponseDto(post.getId(), post.getContent(), author,
                post.getLikeCount(), post.getCommentCount(), post.getViewCount(),
                post.getCreatedAt(), post.getUpdated());
    }

    @Transactional
    public PostResponseDto update(Long userId, Long postId, PostRequestDto dto) {
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글을 조회하지 못하였습니다.")
        );

        if (!post.getProfile().getId().equals(profile.getId())) {
            throw new IllegalStateException("해당 게시물 수정에 접근 권한이 없습니다.");
        }

        post.update(dto.getContent());//게시물 내용 수정


        AuthorDto author = new AuthorDto(post.getProfile().getId(),
                post.getProfile().getUserName(), post.getProfile().getProfileImgUrl());

        return new PostResponseDto(post.getId(), post.getContent(), author,
                post.getLikeCount(), post.getCommentCount(), post.getViewCount(),
                post.getCreatedAt(), post.getUpdated());
    }

    @Transactional
    public void deleteById(Long userId, Long postId) {
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 id를 가진 회원은 존재하지 않습니다.")
        );

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글을 조회하지 못하였습니다.")
        );

        if (!post.getProfile().getId().equals(profile.getId())) {
            throw new IllegalStateException("해당 게시물 수정에 접근 권한이 없습니다.");
        }

        postRepository.deleteById(postId);
    }


}
