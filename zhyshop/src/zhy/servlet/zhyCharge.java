package zhy.servlet;

import zhy.dao.zhyVipDao;
import zhy.entity.zhyVip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyCharge extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyCharge() {
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
		zhyVip v = new zhyVip();
		zhyVipDao vd = new zhyVipDao();
		v = vd.queryByid(id);
		request.getSession().setAttribute("vip", v);
		response.sendRedirect("zhycharge.jsp");
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
		double money =0;
		int score = 0;
		Double qb = Double.parseDouble(request.getParameter("qb"));
		int jf=Integer.parseInt(request.getParameter("jf"));
		if(request.getParameter("money")!="")
			money = Double.parseDouble(request.getParameter("money"));
		if(request.getParameter("score")!="")
			score= Integer.parseInt(request.getParameter("score"));
		zhyVipDao vd = new zhyVipDao();
		int res=0;
		money+=qb;
		score+=jf;
		res = vd.charge(money, score, id);
		
		if(res>0){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('充值成功');location.href='zhyQuery';</script>");
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('充值失败');history.go(-1);</script>");
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
