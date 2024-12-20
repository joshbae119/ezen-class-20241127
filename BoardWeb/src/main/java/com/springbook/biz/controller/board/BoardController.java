package com.springbook.biz.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
	      System.out.println("글 삭제 처리");
	      
	      boardDAO.deleteBoard(vo);
	      return "redirect:getBoardList.do";

		
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 보기 처리");
		
	    mav.addObject("board", boardDAO.getBoard(vo));
	    mav.setViewName("getBoard.jsp");
		return mav;
		
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 보기 처리");
		
	    List<BoardVO> boardList = boardDAO.getBoardList(vo);
	    mav.addObject("boardList", boardList);
	    mav.setViewName("getBoardList.jsp");
	    return mav;
		
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
		
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
		
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav){
	      System.out.println("글 수정 처리");
	      
	      boardDAO.updateBoard(vo);
	      return "redirect:getBoardList.do";
		
	}




}
