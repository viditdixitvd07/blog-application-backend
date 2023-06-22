package com.vidit.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.blogapi.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
