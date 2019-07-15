package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardDto;

public interface BoardService {
	public void regist(BoardDto boardDto) throws Exception;
	
	public BoardDto read(Integer bno) throws Exception;
	
	public void modify(BoardDto boardDto) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardDto> listAll() throws Exception;
}
