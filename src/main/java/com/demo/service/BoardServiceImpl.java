package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.BoardDAO;

public abstract class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	

}
