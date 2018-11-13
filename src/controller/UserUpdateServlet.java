package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);



		UserDao userDao = new UserDao();
		User userList = userDao.findById(id);

		request.setAttribute("userList", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
		return;

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String username = request.getParameter("username");
		String birthDay = request.getParameter("birthDay");
		UserDao userDao = new UserDao();

		if (!password.equals(confirm) || username.equals("") || birthDay.equals("")) {
			System.out.println("error");

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			User userList = userDao.findById(id);
			request.setAttribute("userList", userList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}


		User userList = userDao.updateUser(id, loginId, username, birthDay, password);

		response.sendRedirect("UserListServlet");
	}
}
