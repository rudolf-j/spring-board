package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.Board;
import com.spring.persistence.BoardDao;
import com.spring.service.BoardService;
import com.spring.vo.PageVO;

import lombok.extern.java.Log;

@Log
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping("/")
	public String getBoardList(PageVO page, Model model) {
		page.setRowCount(boardDao.getRowCount(page));
		List<Board> list = boardService.getBoardList(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "index";
	}
	
	@RequestMapping("/search")
	public String searchBoard(PageVO page, Model model) {
		page.setRowCount(boardDao.getRowCount(page));
		List<Board> list = boardService.searchBoard(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "index";
	}
	
	

}
