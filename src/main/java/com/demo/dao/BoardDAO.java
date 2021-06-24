package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.domain.Board;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(Board board) throws Exception{
		String query = "INSERT INTO board (title,content,writer) VALUES(?,?,?)";
		jdbcTemplate.update(query,board.getTitle(),board.getContent(),board.getWriter());
	}
	

}
