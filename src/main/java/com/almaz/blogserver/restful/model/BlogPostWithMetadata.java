package com.almaz.blogserver.restful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Data
public class BlogPostWithMetadata {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String content;
    private String category;
    private String[] tag;
    private String createdAt;
    private String updatedAt;
}
