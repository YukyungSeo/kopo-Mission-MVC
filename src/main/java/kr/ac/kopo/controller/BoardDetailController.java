package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String no = request.getParameter("no");
		BoardService service = new BoardService();
		BoardVO board = service.getBoard(Integer.parseInt(no));
		
		request.setAttribute("board", board);
		
		return "/jsp/board/detail.jsp";
	}

}
