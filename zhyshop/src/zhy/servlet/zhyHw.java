package zhy.servlet;

import zhy.dao.zhySpDao;
import zhy.entity.zhySp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyHw extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyHw() {
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
		request.setCharacterEncoding("utf-8");
		zhySpDao sd = new zhySpDao();
		ArrayList<zhySp> sps= new ArrayList<zhySp>();
		int start=0;
		int pagesize = 4;
		int pagenow = 0;
		int pagecount = 0;
		int countpage = 0;
		countpage = sd.count();
		if(countpage%pagesize==0){
			pagecount = countpage/pagesize;
		}else{
			pagecount = countpage/pagesize+1;
		}
		if(request.getParameter("page")!=null){
			pagenow = Integer.parseInt(request.getParameter("page"));
		}
		start = pagesize*pagenow;
		String tj = "";
		if(request.getParameter("tj")!=null)
			tj = new String(request.getParameter("tj").getBytes("ISO-8859-1"),"UTF-8");
		sps = sd.Query("select *from zhysp where zhyid like '%"+tj+"%' or zhync like '%"+tj+"%' or zhypzk like '%"+tj+"%' or zhydw like '%"+tj+"%' or zhytxm like '%"+tj+"%' or zhyjinjia like '%"+tj+"%' or zhymj like '%"+tj+"%' " +
				"or zhybzk like '%"+tj+"%' or zhyhzk like '%"+tj+"%' or zhykc like '%"+tj+"%' or zhybz like '%"+tj+"%' limit ?,?", new Object[]{start,pagesize});
		request.getSession().setAttribute("pagenow", pagenow);
		request.getSession().setAttribute("pagecount", pagecount);
		request.getSession().setAttribute("countpage", countpage);
		request.getSession().setAttribute("sps", sps);
		response.sendRedirect("zhyhw.jsp");
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
