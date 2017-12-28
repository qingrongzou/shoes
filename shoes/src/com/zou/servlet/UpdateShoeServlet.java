package com.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zou.bean.Shoe;
import com.zou.dao.ShoeDao;

import bean.News;
import inf.DataDAO;
import inf.NewsDAOImf;

/**
 * Servlet implementation class UpdateShoeServlet
 */
@WebServlet("/UpdateShoeServlet")
public class UpdateShoeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateid=request.getParameter("update_id");
		int sid=Integer.parseInt(updateid);
		Double ssDouble=(Double)request.getParameter("shoe_size");
		String stString=request.getParameter("shoe_type");
		String spString=request.getParameter("shoe_price");
		ShoeDao dao=new ShoeDao();	
		Shoe data=new Shoe(sid, ssString, stString, spString);
		boolean flag=dao.updateData(data);
		if (flag) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('修改成功!');window.location.href='SelectPersonalServlet'</script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('修改失败，请重新输入要修改的新闻ID!');window.location.href='update.jsp'</script>");
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
