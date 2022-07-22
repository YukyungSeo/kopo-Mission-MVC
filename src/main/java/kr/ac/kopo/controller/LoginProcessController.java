package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.vo.MemberVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id.equals("admin") && password.equals("admin")) {
			// 로그인 성공
			MemberVO memberVO = new MemberVO();
			memberVO.setId(id);
			memberVO.setPassword(password);
			memberVO.setName("관리자");
			memberVO.setType("S");
			
			// 세션 등록
			HttpSession session = request.getSession();
			session.setAttribute("user", memberVO);
			
			return "redirect:";
		}
		
		// 로그인 실패

		return "redirect:/login/login.do";
	}

}
