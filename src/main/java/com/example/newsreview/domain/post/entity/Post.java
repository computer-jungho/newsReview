package com.example.newsreview.domain.post.entity;

import com.example.newsreview.domain.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ColumnDefault("0")
    @Column
    private Integer viewCount;

    @ColumnDefault("0")
    @Column
    private Integer commentCount;

    @ColumnDefault("0")
    @Column
    private Integer likeCount;

    private  LocalDateTime createdAt;
    private  LocalDateTime updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public Post(Profile profile, String content) {
        this.profile = profile;
        this.content = content;
        this.viewCount = 0;
        this.commentCount = 0;
        this.likeCount = 0;
    }

    public void update(String content) {
        this.content = content;
    }
}
