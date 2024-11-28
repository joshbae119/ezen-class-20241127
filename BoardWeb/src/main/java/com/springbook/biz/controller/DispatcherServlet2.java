package com.springbook.biz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


/*** Servlet implementation class DispatcherServelet */
public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*** @see HttpServlet#HttpServlet()     */
    public DispatcherServlet2() {
        super();
    }

    /**@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user		=	userDAO.getUser(vo);

			if(user != null){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}

		}else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.jsp");
			
		}else if (path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");
			
			request.setCharacterEncoding("EUC-KR");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			request.setCharacterEncoding("EUC-KR");
			String title =   request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);

			response.sendRedirect("getBoardList.do");

			
			
		}else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 보기 처리");
			
			String seq =  request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
		    BoardVO board =   boardDAO.getBoard(vo);
		    
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");

			
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 보기 처리");
			
		    BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}else if(path.equals("/insertUser.do")) {
			System.out.println("회원가입");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String password1 = request.getParameter("password2");
			String name = request.getParameter("name");
			//String role = request.getParameter("role");
			String role = "USER";
			
		   if (!password.equals(password1)) {
		        request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
		        request.setAttribute("id", id);
		        request.setAttribute("name", name);
		        request.getRequestDispatcher("insertUser.jsp").forward(request, response);

		        return;
		    }

			UserVO vo = new UserVO();
			UserDAO userDAO = new UserDAO();

			vo.setId(id);
			vo.setPassword(password);
			vo.setName(name);
			vo.setRole(role);

			if(password.equals(password1)){
				response.sendRedirect("login.jsp");
			}else{
				response.sendRedirect("insertUser.jsp");
			}

			userDAO.insertUser(vo);


			
		}

	}

	/*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
