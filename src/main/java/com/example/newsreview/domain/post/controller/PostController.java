package com.example.newsreview.domain.post.controller;

import com.example.newsreview.common.consts.Const;
import com.example.newsreview.domain.post.dto.PostRequestDto;
import com.example.newsreview.domain.post.dto.PostResponseDto;
import com.example.newsreview.domain.post.sevice.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
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

    //페이징 생성일자 기준으로 10개씩 보여주기
    @GetMapping("/posts/pages")
    public void paging (Model model,
                        @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)Pageable pageable)
    {
        model.addAttribute("postList", postService.getPageList(pageable));
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
