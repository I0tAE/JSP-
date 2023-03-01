package zhy.servlet;

import zhy.dao.zhyRkDao;
import zhy.entity.zhyRkqk;
import zhy.service.MySqlConn;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyrkxq extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyrkxq() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		zhyRkDao rd = new zhyRkDao();
		Date date=new Date(); 
		SimpleDateFormat t = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
		String time=t.format(date);
		String id=t2.format(date);
		if(request.getParameter("tj")!=null){
			id=request.getParameter("tj");
			time=id.substring(0, 4)+id.substring(5,7)+id.substring(8);
		}
		request.getSession().setAttribute("times", time);
		request.getSession().setAttribute("time", id);
		response.sendRedirect("zhyrkxq2");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
