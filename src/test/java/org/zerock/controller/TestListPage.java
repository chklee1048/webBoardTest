package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardDto;
import org.zerock.persistence.BoardDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class TestListPage {
	
	@Inject
	BoardDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(TestListPage.class);

	@Test
	public void testListPage() throws Exception{
		int page = 3;
		List<BoardDto> list = dao.listPage(page);
		
		for(BoardDto dto : list) {
			logger.info(dto.getBno()+"::::"+dto.getTitle());
		}
		
	}

}
