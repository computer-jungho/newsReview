package com.example.newsreview.domain.post.repository;

import com.example.newsreview.domain.post.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

}
