package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardDto;

import org.zerock.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDaoTest {
	
	@Inject
	private BoardDao dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	
	 @Test
	 public void testURI() throws Exception{
		 UriComponents uriComponents =
				 UriComponentsBuilder.newInstance()
				 .path("/{module}/{page}")
				 .queryParam("bno", 12)
				 .queryParam("perPageNum", 20)
				 .build()
				 .expand("board","read")
				 .encode();
		 
		 logger.info(uriComponents.toString());
	 }
}
