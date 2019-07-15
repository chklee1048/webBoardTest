package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardDto;

public interface BoardDao {
	public void create(BoardDto boardDto) throws Exception;
	
	public BoardDto read(Integer bno) throws Exception;
	
	public void update(BoardDto boardDto) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardDto> listAll() throws Exception;
}
