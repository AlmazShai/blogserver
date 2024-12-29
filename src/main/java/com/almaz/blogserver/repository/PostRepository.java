package com.almaz.blogserver.repository;

import com.almaz.blogserver.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :term, '%')) OR " +
            "LOWER(p.content) LIKE LOWER(CONCAT('%', :term, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :term, '%'))")
    List<Post> searchByTerm(@Param("term") String term);
}
