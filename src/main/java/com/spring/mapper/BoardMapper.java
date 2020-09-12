package com.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Board;
import com.spring.vo.PageVO;

@Mapper
public interface BoardMapper {
	List<Board> selectBoardList(PageVO pageVO);
	List<Board> selectBoardByKeyword(PageVO pageVO);
	Board selectOne(int bno);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(int bno);
	int getRowCount(PageVO pageVO);
}
