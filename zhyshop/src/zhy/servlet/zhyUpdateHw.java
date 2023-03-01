package zhy.servlet;

import zhy.dao.zhySpDao;
import zhy.entity.zhySp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyUpdateHw extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyUpdateHw() {
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
		String id = request.getParameter("id");
		zhySp sp = new zhySp();
		zhySpDao sd = new zhySpDao();
		sp = sd.QueryByid(id);
		request.getSession().setAttribute("spd", sp);
		response.sendRedirect("zhyupdatehw.jsp");
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
		String id = request.getParameter("id");
		String nc = request.getParameter("nc");
		String dw = request.getParameter("dw");
		String txm =request.getParameter("txm");
		double jj = Double.parseDouble(request.getParameter("jj"));
		double mj = Double.parseDouble(request.getParameter("mj"));
		double pzk = Double.parseDouble(request.getParameter("pzk"));
		double bzk = Double.parseDouble(request.getParameter("bzk"));
		double hzk = Double.parseDouble(request.getParameter("hzk"));
		String bz = request.getParameter("bz");
		int kc = Integer.parseInt(request.getParameter("kc"));
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
		s.setKc(kc);
		int res =0;
		res = sd.updatesp(s,id);
		if(res>0){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改成功');location.href='zhyHw';</script>");
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改失败');history.go(-1);");
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
