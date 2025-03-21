package com.example.newsreview.domain.post.dto;

import com.example.newsreview.domain.base.dto.AuthorDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private final Long id;
    private final String content;
    private final AuthorDto author;
    private final Integer likeCount;
    private final Integer commentCount;
    private final Integer viewCount;
    private boolean isLiked;
    private final LocalDateTime createdAt;
    private final LocalDateTime updated;

    public PostResponseDto(Long id, String content, AuthorDto author,
                           Integer likeCount, Integer commentCount, Integer viewCount,
                           LocalDateTime createdAt, LocalDateTime updated) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.updated = updated;
    }
}
