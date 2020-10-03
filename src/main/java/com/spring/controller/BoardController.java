package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/board/writeForm";
	}
	
	@RequestMapping("/writeBoard")
	public String writeBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:/";
	}
	
	@RequestMapping("/viewContent/{bno}")
	public String viewContent(@PathVariable("bno") int bno, Model model) {
		model.addAttribute("board", boardService.getContent(bno));
		return "/board/view";
	}
	
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") int bno) {
		boardService.deleteBoard(bno);
		return "redirect:/";
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(Board board, Model model) {
		model.addAttribute("board", board);
		return "/board/modify";
	}
	
	@RequestMapping("/modify")
	public String modify(Board board) {
		boardService.updateBoard(board);
		return "redirect:/";
	}
	

}
