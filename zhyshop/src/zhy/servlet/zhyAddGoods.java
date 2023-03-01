package zhy.servlet;

import zhy.dao.zhySpDao;
import zhy.entity.zhySp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyAddGoods extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyAddGoods() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		request.setCharacterEncoding("utf-8");
		String nc = request.getParameter("nc");
		String dw = request.getParameter("dw");
		double jj = Double.parseDouble(request.getParameter("jj"));
		double mj = Double.parseDouble(request.getParameter("mj"));
		double pzk = Double.parseDouble(request.getParameter("pzk"));
		double bzk = Double.parseDouble(request.getParameter("bzk"));
		double hzk = Double.parseDouble(request.getParameter("hzk"));
		String bz = request.getParameter("bz");
		String txm =request.getParameter("txm");
		zhySp s = new zhySp();
		zhySpDao sd = new zhySpDao();
		s.setNc(nc);
		s.setDw(dw);
		s.setJj(jj);
		s.setMj(mj);
		s.setPzk(pzk);
		s.setBzk(bzk);
		s.setHzk(hzk);
		s.setBz(bz);
		s.setTxm(txm);
		int res =0;
		res = sd.addsp(s);
		if(res>0){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('添加成功');location.href='zhyaddgoods.jsp';</script>");
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('添加失败');history.go(-1);");
		}
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
