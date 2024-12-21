package com.almaz.blogserver.service;

import com.almaz.blogserver.model.PostModel;
import com.almaz.blogserver.model.PostResponseModel;
import com.almaz.blogserver.repository.Post;
import com.almaz.blogserver.repository.PostRepository;

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

    public PostResponseModel createPost(PostModel post) {
        Post entity = ModelConverter.convert(post);
        postRepository.save(entity);
        return ModelConverter.convert(entity);
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

    public List<PostResponseModel> getPosts(String term) {
        ArrayList<PostResponseModel> response = new ArrayList<>();
        Iterable<Post> posts = term != null ? postRepository.searchByTerm((term)) : postRepository.findAll();
        for(Post post : posts) {
            response.add(ModelConverter.convert(post));
        }
        return response;
    }

    public void deletePost(Long id) {
        if(postRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException();
        }
        postRepository.deleteById(id);
    }
}
