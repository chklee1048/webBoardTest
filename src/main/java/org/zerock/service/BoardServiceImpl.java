package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardDto;

import org.zerock.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDao boardDao;
	
	@Override
	public void regist(BoardDto boardDto) throws Exception {
		boardDao.create(boardDto);
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		return boardDao.read(bno);
	}

	@Override
	public void modify(BoardDto boardDto) throws Exception {
		boardDao.update(boardDto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return boardDao.listAll();
	}

}
