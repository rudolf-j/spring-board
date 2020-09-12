package com.spring.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.domain.Board;
import com.spring.persistence.BoardDaoImpl;
import com.spring.service.BoardService;

import lombok.extern.java.Log;

@Log
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:dbconfig/mybatis-context.xml")
public class BoardTest {
	
	@Autowired
	BoardDaoImpl dao;
	
	@Autowired
	BoardService boardService;
	
	@Test
	void insert() {
		
		for(int i = 0; i < 30; i++) {
			Board board = new Board();
			board.setTitle("title"+i);
			board.setWriter("user"+i);
			board.setContent("content"+i);
			dao.insert(board);
		}
	}
	
	@Test
	void read() {
//		map.put("option", "title_writer");
//		map.put("keyword", "2");
//		List<Board> list = dao.read(map);
//		log.info("size.................................."+list.size());
//		for(Board board : list) {
//			log.info("board............................."+board);
//		}	
	}
	
	@Test
	void readAll() {
//		List<Board> list = dao.readAll();
//		for(Board board : list) {
//			log.info("board............................."+board);
//		}
	}
	
	@Test
	void readOne() {
		Board board = dao.readOne(90);
		log.info("board............................."+board);
	}
	
	@Test
	void update() {
		Board board = dao.readOne(90);
		board.setContent("¼öÁ¤......");
		dao.update(board);
	}
	
	@Test
	void search() {
//		List<Board> list = boardService.searchBoard("title", "title2", 2);
		List<Board> list = boardService.searchBoard("title", "", 1);
		for(Board board : list) {			
			log.info(""+board);
		}
	}

}
