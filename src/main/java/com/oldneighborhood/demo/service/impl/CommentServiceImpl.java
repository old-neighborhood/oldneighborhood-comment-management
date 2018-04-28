package com.oldneighborhood.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldneighborhood.demo.dao.CommentDao;
import com.oldneighborhood.demo.entity.Comment;
import com.oldneighborhood.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> check(String m_ID) {
		// TODO Auto-generated method stub
		return commentDao.findByMid(m_ID);
	}

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.save(comment);
	}

}
