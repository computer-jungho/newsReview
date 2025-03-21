package com.example.newsreview.domain.post.repository;

import com.example.newsreview.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
