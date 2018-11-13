package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;


/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		UserDao dao = new UserDao();

		int delResult = dao.deleteUser(id);

		RequestDispatcher dispatcher;

		if (delResult == 1) {
			dispatcher = request.getRequestDispatcher("UserListServlet");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("errMsg", "ユーザー解除失敗しました。\nもう一度お試しください。");
			dispatcher = request.getRequestDispatcher("UserlistServlet");
			dispatcher.forward(request, response);
		}

	}

}
