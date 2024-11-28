package com.springbook.biz.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.biz.controller.board.DeleteBoardController;
import com.springbook.biz.controller.board.GetBoardController;
import com.springbook.biz.controller.board.GetBoardListController;
import com.springbook.biz.controller.board.InsertBoardController;
import com.springbook.biz.controller.board.UpdateBoardController;
import com.springbook.biz.controller.user.LoginController;
import com.springbook.biz.controller.user.LogoutController;

public class HandlerMapping {
	
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping = new HashMap<String, Controller>();
		mapping.put("/login.do", new LoginController());
		mapping.put("/getBoardList.do", new GetBoardListController());
		mapping.put("/getBoard.do", new GetBoardController());
		mapping.put("/insertBoard.do", new InsertBoardController());
		mapping.put("/updateBoard.do", new UpdateBoardController());
		mapping.put("/deleteBoard.do", new DeleteBoardController());
		mapping.put("/logout.do", new LogoutController());
		
		
	}
	
	public Controller getController(String path) {
		return mapping.get(path);
	}

}
