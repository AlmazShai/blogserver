package com.almaz.blogserver.service;

import com.almaz.blogserver.model.PostModel;
import com.almaz.blogserver.model.PostResponseModel;
import com.almaz.blogserver.repository.Post;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ModelConverter {

    static public Post convert(PostModel model) {
        return new Post(model.getTitle(), model.getContent(), model.getCategory(), model.getTags());
    }

    static public PostResponseModel convert(Post entity) {
        Instant instant = Instant.now();
        // Get system's default offset
        ZoneOffset systemOffset = ZoneId.systemDefault().getRules().getOffset(instant);

        return new PostResponseModel(entity.getId(), entity.getTitle(), entity.getContent(),
                                    entity.getCategory(), entity.getTags(),
                                    entity.getCreatedAt().atOffset(systemOffset),
                                    entity.getUpdatedAt().atOffset(systemOffset));
    }
}
