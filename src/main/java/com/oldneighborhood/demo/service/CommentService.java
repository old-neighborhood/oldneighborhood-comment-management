package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Comment;

public interface CommentService {

	List<Comment> check(String m_ID);
	
	void save(Comment comment);

}
