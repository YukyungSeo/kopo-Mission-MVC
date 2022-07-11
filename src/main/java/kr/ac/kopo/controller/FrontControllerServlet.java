package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FrontControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String context = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		System.out.println("uri : " + uri);

		try {
			
			HandlerMapping mappings = new HandlerMapping();
			Controller control = mappings.getController(uri);
			
			if(control != null) {
				String callPage = control.handleRequest(request, response);
				if(callPage.startsWith("redirect:")) {
					callPage = callPage.substring("redirect:".length());
					response.sendRedirect(request.getContextPath() + callPage);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
