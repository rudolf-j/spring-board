package com.spring.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Board;
import com.spring.mapper.BoardMapper;
import com.spring.vo.PageVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public void insert(Board board) {
		boardMapper.insertBoard(board);
	}

	@Override
	public void update(Board board) {
		boardMapper.updateBoard(board);
	}

	@Override
	public void delete(int bno) {
		boardMapper.deleteBoard(bno);
	}

	@Override
	public List<Board> readAll(PageVO pageVO) {
		return boardMapper.selectBoardList(pageVO);
	}

	@Override
	public List<Board> read(PageVO pageVO) {
		return boardMapper.selectBoardByKeyword(pageVO);
	}
	
	@Override
	public Board readOne(int bno) {
		return boardMapper.selectOne(bno);
	}

	@Override
	public int getRowCount(PageVO pageVO) {
		return boardMapper.getRowCount(pageVO);
	}

}
