package com.almaz.blogserver.service;

import com.almaz.blogserver.model.PostModel;
import com.almaz.blogserver.model.PostResponseModel;
import com.almaz.blogserver.repository.Post;
import com.almaz.blogserver.repository.PostRepository;
import com.almaz.blogserver.service.ModelConverter;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    PostRepository postRepository;

    public void createPost(PostModel post) {
        postRepository.save(ModelConverter.convert(post));
    }

    public void updatePost(Long id, PostModel postModel) {
        Optional<Post> entity = postRepository.findById(id);
        if (entity.isPresent()) {
            Post post = entity.get();

            post.setTitle(postModel.getTitle());
            post.setContent(postModel.getContent());
            post.setCategory(postModel.getCategory());
            post.setTags(postModel.getTags());

            postRepository.save(post);
        } else {
           throw new EntityNotFoundException("Post with ID " + id + " not found.");
        }
    }

    public PostResponseModel getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return ModelConverter.convert(post.get());
        } else {
            throw new EntityNotFoundException("Post with ID " + id + " not found.");
        }
    }

    public List<PostResponseModel> getPosts() {
        ArrayList<PostResponseModel> response = new ArrayList<>();
        Iterable<Post> posts = postRepository.findAll();
        for(Post post : posts) {
            response.add(ModelConverter.convert(post));
        }
        return response;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
