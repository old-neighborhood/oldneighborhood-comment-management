package com.oldneighborhood.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.Comment;

public interface CommentDao extends JpaRepository<Comment, String>{
	
	@Query(value="select c_ID, u_ID, m_ID,c_image, c_content, "
			+ "c_star, c_date"
			+ " from comment where m_ID=? order by c_date desc " , nativeQuery=true)
	List<Comment> findByMid(String m_ID);

}
