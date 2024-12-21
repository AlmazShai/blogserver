package com.almaz.blogserver.restful.blogpost;

import com.almaz.blogserver.api.PostsApi;
import com.almaz.blogserver.model.PostModel;
import com.almaz.blogserver.model.PostResponseModel;
import com.almaz.blogserver.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController implements PostsApi{

    @Autowired
    private BlogService service;

    @Override
    public ResponseEntity<PostResponseModel> createNewPost(PostModel postModel) {

        try {
            return ResponseEntity.ok(service.createPost(postModel));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        try {
            service.deletePost(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<PostResponseModel>> getAllPosts(String term) {
        try {
            List<PostResponseModel> posts = service.getPosts(term);
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<PostResponseModel> getPost(Long id) {
        try {
            PostResponseModel post = service.getPost(id);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updatePost(Long id, PostModel postModel) {
        try {
            service.updatePost(id, postModel);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
