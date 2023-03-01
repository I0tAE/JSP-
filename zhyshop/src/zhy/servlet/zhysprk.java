package zhy.servlet;

import zhy.dao.zhySpDao;
import zhy.entity.zhySp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhysprk extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhysprk() {
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
		String txm = request.getParameter("txm");
		int sl=0;
		zhySpDao sd = new zhySpDao();
		zhySp sp2 =new zhySp();
		ResultSet rs =null;
		int res = 0;
		if(request.getParameter("sl")!=null)
			sl = Integer.parseInt(request.getParameter("sl"));
		res = sd.QueryBytxm0(txm,sl);
		if(res!=1){
			sp2 = sd.QueryBytxm("select *from zhysp where zhytxm=?", new Object[]{txm});
			if(sp2.getId()!=0){
				res = sd.addsprk(sp2);
			}
			else{
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println("<script>alert('无此条形码');history.go(-1);</script>");
			}
			}
		
		
		ArrayList<zhySp> spss= new ArrayList<zhySp>();
		spss = sd.Query2("select * from zhysprk where zhyrole=0", new Object[]{});
		request.getSession().setAttribute("spss", spss);
		response.sendRedirect("zhysprk.jsp");
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
