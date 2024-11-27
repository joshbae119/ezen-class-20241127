package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		
		
		vo.setTitle("안녕");
		vo.setWriter("박지영");
		vo.setContent("제발좀 공부좀 해주세요!!!!!");
	
		
		boardService.insertBoard(vo);
		//boardService.updateBoard(vo);
		//boardService.deleteBoard(vo);
		
	
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for(BoardVO board : boardList) {
			System.out.println("검색 결과 : " + board.toString());
		}
	
		container.close();
	}

}
