package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Board;
import com.demo.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController2 {

	@Autowired
	private BoardService service;
	
	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception{
		log.info("registerForm");
	}
	
	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception{
		log.info("register");
		service.register(board);
		model.addAttribute("msg", "등록완료");
		
		return "board/success";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception{
		log.info("list");
		model.addAttribute("list",service.list());
		
	}
	
	@GetMapping("/read")
	public void read(int boardNo,Model model) throws Exception{
		log.info("read");
		model.addAttribute(service.read(boardNo));
	}
	
	
	@PostMapping("/remove")
	public String remove(int boardNo,Model model) throws Exception{
		log.info("remove");
		service.remove(boardNo);
		model.addAttribute("msg", "삭제완료");
		
		return "board/success";
	}
	
	@GetMapping("/modify")
	public void modifyForm(int boardNo,Model model) throws Exception{
		log.info("modifyForm");
		model.addAttribute(service.read(boardNo));
	}
	
	@GetMapping("/modify")
	public String modify(Board board,Model model) throws Exception{
		log.info("modify");
		service.modify(board);
		model.addAttribute("msg", "수정완료");
		
		return "board/success";
	}
}
