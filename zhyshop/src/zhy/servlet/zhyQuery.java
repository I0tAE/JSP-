package zhy.servlet;

import zhy.dao.zhyVipDao;
import zhy.entity.zhyVip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyQuery extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyQuery() {
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
		zhyVipDao vd = new zhyVipDao();
		ArrayList<zhyVip> vips = new ArrayList<zhyVip>();
		int start=0;
		int rowCounln=0;
		int pagesize=4;
		int pagenow=0;
		int pagecount=0;
		rowCounln = vd.count("select count(*) from zhyvip", new Object[]{});
		if(rowCounln%pagesize==0){
			pagecount = rowCounln/pagesize;
		}else{
			pagecount = rowCounln/pagesize+1;
		}
		if(request.getParameter("page")!=null){
			pagenow=Integer.parseInt(request.getParameter("page"));
		}
		start=pagenow*pagesize;
		String tj = "";
		if(request.getParameter("tj")!=null)
			tj = new String(request.getParameter("tj").getBytes("ISO-8859-1"),"UTF-8");
		vips = vd.Query("select * from zhyvip where zhyid like '%"+tj+"%' or zhyvname like'%" + tj +"%' or zhyphone like'%" + tj +"%' limit ?,?" , new Object[]{start,pagesize});
		request.getSession().setAttribute("vips", vips);
		request.getSession().setAttribute("pagenow", pagenow);
		request.getSession().setAttribute("pagecount", pagecount);
		request.getSession().setAttribute("tj",tj);
		response.sendRedirect("zhyhyzl.jsp");
		
		
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
