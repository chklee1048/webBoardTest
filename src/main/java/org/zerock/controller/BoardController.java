package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardDto;

import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(BoardDto boardDto, Model model) throws Exception{
		
		logger.info("registerGET..............");
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String resisterPOST(BoardDto boardDto, Model model) throws Exception{
	public String resisterPOST(BoardDto boardDto, RedirectAttributes rttr) throws Exception{	
		logger.info("resisterPOST........................");
		logger.info(boardDto.toString());
		
		boardService.regist(boardDto);
		
//		model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		
//		return "/board/success"; 페이지를 다른 곳으로 이동함으로서 도배를 막는다.
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		
		
		logger.info("list alllllllll.............");
		model.addAttribute("list", boardService.listAll());
	}
	
}
