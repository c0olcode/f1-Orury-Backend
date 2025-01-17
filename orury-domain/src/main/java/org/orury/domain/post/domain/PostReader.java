package org.orury.domain.post.domain;

import org.orury.domain.post.domain.entity.Post;
import org.orury.domain.post.domain.entity.PostLikePK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostReader {
    List<Post> findByCategoryOrderByIdDesc(int category, Long cursor, Pageable pageable);

    List<Post> findByUserIdOrderByIdDesc(Long userId, Long cursor, Pageable pageable);

    Page<Post> findByLikeCountGreaterDescAndCreatedAtDesc(Pageable pageable);

    List<Post> findBySearchWordOrderByIdDesc(String searchWord, Long cursor);

    List<Post> findBySearchWordOrderByLikeCountDesc(String searchWord, Long cursor, int lastLikeCount);

    Optional<Post> findById(Long id);

    boolean isPostLiked(Long userId, Long postId);

    boolean existsByPostLikePK(PostLikePK postLikePK);

    List<Post> findAll();
}
