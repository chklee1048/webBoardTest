package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardDto;
import org.zerock.domain.Criteria;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "org.zerock.mapper.BoardMapper";
	
	@Override
	public void create(BoardDto boardDto) throws Exception {
		sqlSession.insert(namespace+".create", boardDto);
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		return sqlSession.selectOne(namespace+".read", bno);
	}
	
	@Override
	public void update(BoardDto boardDto) throws Exception {
		sqlSession.update(namespace+".update", boardDto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return sqlSession.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardDto> listPage(int page) throws Exception {
		
		if (page <= 0) {
			page = 1;
		} 
		
		page = (page - 1) * 10;
		
		
		return sqlSession.selectList(namespace+".listPage",page);
	}

	@Override
	public List<BoardDto> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(namespace+".listCriteria", criteria);
	}

}
