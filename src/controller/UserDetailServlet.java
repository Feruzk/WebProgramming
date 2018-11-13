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


@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDetailServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDetails.jsp");
		dispatcher.forward(request, response);
		return;



	}


}
