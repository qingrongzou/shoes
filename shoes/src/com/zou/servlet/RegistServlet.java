package com.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zou.dao.UserDao;
import com.zou.utils.Conver2MD5;
import com.zou.bean.User;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String pwdmd5 = Conver2MD5.getMD5(password);
		UserDao dao=new UserDao();
		User user=new User(username, pwdmd5);
		boolean flag = dao.inserData(user);
		if (!flag) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('用户名已存在!');window.location.href='regist.jsp';</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('注册成功，请重新登录!');window.location.href='login.jsp';</script>");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
