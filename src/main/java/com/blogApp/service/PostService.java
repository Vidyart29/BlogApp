package com.blogApp.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.model.Post;
import com.blogApp.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }
	
	public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
	
	public Post createPost(Post post) {
		post.setCreatedAt(new Date(0));
	    return postRepository.save(post);
	}
	

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setAuthor(post.getAuthor());
            existingPost.setUpdatedAt(new Date(id));
            existingPost.setCategory(post.getCategory());
            return postRepository.save(existingPost);
        }
        return null;
    }

    public boolean deletePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            postRepository.delete(post);
            return true;
        }
        return false;
    }
	
}
