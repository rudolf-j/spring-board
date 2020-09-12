package com.spring.persistence;

import java.util.List;
import java.util.Map;

import com.spring.domain.Board;
import com.spring.vo.PageVO;

public interface BoardDao {
	void insert(Board board);
	void update(Board board);
	void delete(int bno);
	List<Board> readAll(PageVO pageVO);
	List<Board> read(PageVO pageVO);
	Board readOne(int bno);
	int getRowCount(PageVO pageVO);
}
