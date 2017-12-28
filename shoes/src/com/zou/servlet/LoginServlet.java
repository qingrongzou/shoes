package com.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zou.bean.User;
import com.zou.dao.UserDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("user_name");
		String upw = request.getParameter("user_password");
		String code = request.getParameter("user_code");
		String scode = request.getSession(true).getAttribute("scode").toString();
		PrintWriter out = response.getWriter();
		if (!scode.equals(code)) {
			out.println("<script>alert('���������֤�����!');window.location.href='login.jsp'</script>");
		} else {
			HttpSession session=request.getSession();
			session.setAttribute("NAME", uname);
			UserDao dao=new UserDao();
			User user=dao.selectDataById(uname);
			if (user==null) {
				out.println("<script>alert('�û���������!');window.location.href='login.jsp'</script>");
				} else {
					if (user.getUser_password().equals(upw)) {
						out.println("<script>alert('��ϲ�㣬��¼�ɹ�!');</script>");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					out.println("<script>alert('�������!');window.location.href='login.jsp'</script>");	
			}
		}
			}
		 
		
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
