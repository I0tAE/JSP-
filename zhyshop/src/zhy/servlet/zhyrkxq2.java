package zhy.servlet;

import zhy.dao.zhyRkDao;
import zhy.entity.zhyRkqk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyrkxq2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyrkxq2() {
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
		int start=0;
		int pagecount=0;
		int pagesize=4;
		int column=0;
		int pagenow=0;
		String time=(String) request.getSession().getAttribute("times");
		column = rd.count("SELECT COUNT(*) FROM (SELECT zhyid,SUM(zhyjj),SUM(zhymj),SUM(zhysl),zhydtime FROM zhyrkqk WHERE zhyid LIKE '"+time+"%' GROUP BY zhyid) q", new Object[]{});
		
		if(column%pagesize==0){
			pagecount=column/pagesize;
		}else{
			pagecount=column/pagesize+1;
		}
		if(request.getParameter("page")!=null){
			pagenow = Integer.parseInt(request.getParameter("page"));
		}
		start=pagenow*pagesize;
		ArrayList<zhyRkqk> rks=new ArrayList<zhyRkqk>();
		rks = rd.Query("SELECT zhyid,SUM(zhyjj),SUM(zhymj),SUM(zhysl),zhydtime FROM zhyrkqk where zhyid like '"+time+"%' GROUP BY zhyid limit ?,?", new Object[]{start,pagesize});
		request.getSession().setAttribute("column", column);
		request.getSession().setAttribute("rks", rks);
		request.getSession().setAttribute("pagecount", pagecount);
		request.getSession().setAttribute("pagenow", pagenow);
		response.sendRedirect("zhyrkxq.jsp");
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
