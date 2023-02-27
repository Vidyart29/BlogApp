package com.blogApp.model;

import java.util.Collection;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private Long id;

	@Column(name = "title", nullable = false)
	@Length(min = 5, message = "*Your title must have at least 5 characters")
	@NotEmpty(message = "*Please provide title")
	private String title;

	@Column(name = "body", columnDefinition = "TEXT")
	private String body;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@NotNull
	private User user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	private Collection<Comment> comments;

	

	public Post(Long id,
			@Length(min = 5, message = "*Your title must have at least 5 characters") @NotEmpty(message = "*Please provide title") String title,
			String body, @NotNull User user, Collection<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.user = user;
		this.comments = comments;
	}

	public Post() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
}
