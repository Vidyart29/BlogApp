package com.blogApp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.exception.PostNotFoundException;
import com.blogApp.model.Post;
import com.blogApp.repository.PostRepository;
import com.blogApp.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostService postService;
    private PostRepository postRepository;

    @RequestMapping("/get-all-posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    
    public Post getPostById(long id) {
		Optional<Post> postOptional = postRepository.findById(id);
		if (postOptional.isPresent()) {
			LOG.info(postOptional.get().toString());
			return postOptional.get();
		} else {
			String errorMessage = "Post with id " + id + " was not found.";
			LOG.warn(errorMessage);
			throw new PostNotFoundException(errorMessage);
		}
	}

    @PostMapping("")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
