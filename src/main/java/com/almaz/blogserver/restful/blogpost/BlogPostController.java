package com.almaz.blogserver.restful.blogpost;

import com.almaz.blogserver.api.PostsApi;
import com.almaz.blogserver.model.PostModel;
import com.almaz.blogserver.model.PostResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogPostController implements PostsApi{


    @Override
    public ResponseEntity<Void> createNewPost(PostModel postModel) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PostResponseModel>> getAllPosts() {
        ArrayList<PostResponseModel> response = new ArrayList<PostResponseModel>();
        response.add(new PostResponseModel());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<PostResponseModel> getPost(Long id) {
        PostResponseModel response = new PostResponseModel();
        response.setId(id);
        response.setContent("test content");
        response.setTitle("Title");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> updatePost(Long id, PostModel postModel) {
        return null;
    }
}
