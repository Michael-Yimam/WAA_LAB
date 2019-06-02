package mum.edu.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.data.DataFacade;
import mum.edu.data.DataFacadeFactory;
import mum.edu.data.TestDataImpl;
/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
 		requestDispatcher.forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String expectedPassword = data.findPassword(name);
		
		if(expectedPassword == null || !expectedPassword.equals(password)) {
		
 			response.sendRedirect("login.do");			

 //			throw new RuntimeException("Username or Password is invalid");
		} else {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/LoginSuccessful.jsp");
	 		requestDispatcher.forward(request, response);
		
		}
	}

}
