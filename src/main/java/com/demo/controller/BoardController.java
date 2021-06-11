package com.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

	@GetMapping("/")
	public ResponseEntity<List<Board>> list(){
		log.info("list");
		
		List<Board> boardList = new ArrayList<>();
		
		Board board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("Çâ¼ö");
		board.setContent("³ÐÀº ¹ú~");
		board.setWriter("dulgi");
		board.setRegDate(LocalDateTime.now());
		
		boardList.add(board);
		
		board = new Board();
		
		board.setBoardNo(2);
		board.setTitle("Ã¹¸¶À½");
		board.setContent("³¯¸¶´Ù~");
		board.setWriter("dulgi");
		board.setRegDate(LocalDateTime.now());
		
		boardList.add(board);
		
		ResponseEntity<List<Board>> entity = new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> register(@RequestBody Board board){
		log.info("register");
		log.info("Title" + board.getTitle());
		log.info("Cotent" + board.getContent());
		log.info("Writer" + board.getWriter());
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo){
		log.info("read");
		
		Board board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("Çâ¼ö");
		board.setContent("³ÐÀº ¹ú~");
		board.setWriter("dulgi");
		board.setRegDate(LocalDateTime.now());
		
		ResponseEntity<Board> entity = new ResponseEntity<>(board,HttpStatus.OK);
		
		return entity;
	}
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo){
		log.info("remove");
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		
		return entity;
	}
	
	//consumes : content-Type
	@PutMapping(value="/{boardNo}",consumes="application/json")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		log.info("modify");
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		
		return entity;
	}
}
