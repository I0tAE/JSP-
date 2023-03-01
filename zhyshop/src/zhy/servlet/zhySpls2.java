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

public class zhySpls2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhySpls2() {
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
		zhySpDao sd = new zhySpDao();
		ArrayList<zhySp> spss= new ArrayList<zhySp>();
		String role = (String) request.getSession().getAttribute("role");
		spss = sd.Query2("select * from zhysprk where zhyrole=?", new Object[]{role});
		String jb="∆’Õ®ª·‘±";
		int flag=0;
		String phone = "";
		if(request.getParameter("hyphone")!=null){
			phone = request.getParameter("hyphone");
			flag=1;}
		double sum=0;
		for(zhySp sp :spss){
			if(flag==1)
				jb = sd.zk2(sp,phone);
			sum+=sp.getKc()*sp.getMj()*sp.getPzk()/10;
		}
		request.getSession().setAttribute("spls", spss);
		request.getSession().setAttribute("phone", phone);
		request.getSession().setAttribute("jb", jb);
		request.getSession().setAttribute("sum", sum);
		response.sendRedirect("zhyspls.jsp");
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
