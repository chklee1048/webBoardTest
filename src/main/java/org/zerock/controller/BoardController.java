package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
//		return "/board/success"; �������� �ٸ� ������ �̵������μ� ���踦 ���´�.
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		
		logger.info("list alllllllll.............");
		model.addAttribute("list", boardService.listAll());
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		
		model.addAttribute(boardService.read(bno));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		
		
		logger.info("remove POST call..............");
		boardService.remove(bno);
		
		rttr.addFlashAttribute("result","success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		
		logger.info("modify GET call .............");
		
		model.addAttribute(boardService.read(bno));
		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardDto boardDto, RedirectAttributes rttr) throws Exception{
		
		logger.info("modify post call............");

		boardService.modify(boardDto);
		
		rttr.addFlashAttribute("result","success");
		
		return "redirect:/board/listAll";
	}
	
	
	
	
	
	
	
	
	
	
}
