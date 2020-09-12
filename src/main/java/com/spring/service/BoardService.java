package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.domain.Board;
import com.spring.vo.PageVO;

public interface BoardService {
	
	public List<Board> getBoardList(PageVO pageVO);
	public List<Board> searchBoard(PageVO pageVO);
	public Board getContent(int bno);
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int bno);

}
