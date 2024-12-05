package com.almaz.blogserver.restful.blogpost;

import com.almaz.blogserver.restful.model.BlogPost;
import com.almaz.blogserver.restful.model.BlogPostWithMetadata;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogPostController {

    @PostMapping
    public BlogPostWithMetadata createPost() {
        return new BlogPostWithMetadata();
    }

    @GetMapping("/blogpost/{id}")
    public BlogPostWithMetadata getPost(@PathVariable Long id) {
        return new BlogPostWithMetadata();
    }
}
