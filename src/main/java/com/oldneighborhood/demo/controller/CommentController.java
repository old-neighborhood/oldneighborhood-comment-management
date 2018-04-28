package com.oldneighborhood.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oldneighborhood.demo.entity.Comment;
import com.oldneighborhood.demo.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(path= {"/getComment/{m_ID}"} , method = {RequestMethod.GET})
	public String checkComment(@PathVariable(name="m_ID") String m_ID, Map<String ,Object> map) {
		List<Comment> comments = commentService.check(m_ID);
		map.put("comments", comments) ;
		return "/comments";		
	}
	
	@RequestMapping(path= {"/comment"} , method = {RequestMethod.POST})
	public String order(@RequestBody Comment comment) {
		
		commentService.save(comment);
		return null;		
	}

}
