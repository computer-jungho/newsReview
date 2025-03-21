package com.example.newsreview.domain.post.controller;

import com.example.newsreview.common.consts.Const;
import com.example.newsreview.domain.post.dto.PostRequestDto;
import com.example.newsreview.domain.post.dto.PostResponseDto;
import com.example.newsreview.domain.post.sevice.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts/form")
    public PostResponseDto save (@SessionAttribute(name = Const.LOGIN_USER) Long userId, @RequestBody PostRequestDto dto) {
        return postService.save(userId, dto);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getAll () {
        return postService.findAll();
    }

    @GetMapping("/posts/{postId}")
    public PostResponseDto getOne (@PathVariable Long postId) {
        return postService.findById(postId);
    }

    @PutMapping("/posts/{postId}")
    public PostResponseDto update (@SessionAttribute(name = Const.LOGIN_USER) Long userId,
                                   @PathVariable Long postId,
                                   @RequestBody PostRequestDto dto) {
        return postService.update(userId, postId, dto);
    }

    @DeleteMapping("/posts/{postId}")
    public void delete (@SessionAttribute(name = Const.LOGIN_USER) Long userId,
                        @PathVariable Long postId) {
        postService.deleteById(userId, postId);
    }
}
