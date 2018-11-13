package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String username = request.getParameter("username");
		String birthDay = request.getParameter("birthDay");



		if (!password.equals(confirm)  || loginId.equals("") || password.equals("") || confirm.equals("") || username.equals("") || birthDay.equals("")) {
			System.out.println("error");

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		UserDao userDao = new UserDao();
		try {
			User user = userDao.insertUser(loginId, username, birthDay, password );
		} catch(SQLException e) {
			System.out.println("**************************************************");

			request.setAttribute("errMsg", "入力された内容は重複しています。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("SignupServlet");
		request.setAttribute("errMsg", "was no problem");
	}

}
