package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Board;
import com.spring.persistence.BoardDao;
import com.spring.vo.PageVO;

import lombok.extern.java.Log;

@Log
@Repository
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao BoardDao;

	@Override
	public List<Board> getBoardList(PageVO pageVO) {
		return BoardDao.readAll(pageVO);
	}

	@Override
	public List<Board> searchBoard(PageVO pageVO) {
		return BoardDao.read(pageVO);
	}

	@Override
	public Board getContent(int bno) {
		Board board = BoardDao.readOne(bno);
		board.setHit(board.getHit()+1);
		BoardDao.update(board);
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		BoardDao.insert(board);
	}

	@Override
	public void updateBoard(Board board) {
		BoardDao.update(board);
	}

	@Override
	public void deleteBoard(int bno) {
		BoardDao.delete(bno);
	}

}
