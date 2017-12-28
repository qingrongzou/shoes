package com.zou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zou.bean.Shoe;
import com.zou.dao.ShoeDao;
import com.zou.utils.DataUtils;

/**
 * Servlet implementation class SelectAllShoeServlet
 */
@WebServlet("/SelectAllShoeServlet")
public class SelectAllShoeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllShoeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoeDao dao=new ShoeDao();
		DataUtils<Shoe> dataUtils=new DataUtils<>();
		ArrayList<Shoe> list=dao.selectAllData();
		String spage=request.getParameter("page");
		String snum=request.getParameter("num");
		int page=dataUtils.Conver2Int(spage, 1);
		int num=dataUtils.Conver2Int(snum, 5);
		
		StringBuffer bar=dataUtils.createBar(list,num,page ,this.getClass().getSimpleName());
		list=dataUtils.pagingData(list, num, page);
		request.setAttribute("LIST", list);
		request.setAttribute("BAR", bar);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
