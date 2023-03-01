package zhy.servlet;

import zhy.dao.zhyVipDao;
import zhy.entity.zhyVip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhyUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhyUpdate() {
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
		String id = request.getParameter("id");
		zhyVipDao vd = new zhyVipDao();
		zhyVip v= new zhyVip();
		v = vd.queryByid(id);
	System.out.println(v.getJb());
		request.getSession().setAttribute("v", v);
		response.sendRedirect("zhyupdate.jsp");
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
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String qb=null;
		String jf=null;
		String addr=null;
		String jb=null;
		String dtime=null;
		if(request.getParameter("qb")!="")
			qb = request.getParameter("qb");
		if(request.getParameter("jf")!="")
			jf=request.getParameter("jf");
		if(request.getParameter("addr")!="")
			addr=request.getParameter("addr");
		if(request.getParameter("dtime")!="")
			dtime=request.getParameter("dtime");
		if(request.getParameter("jb")!="")
			jb=request.getParameter("jb");
		zhyVip vip = new zhyVip();
		zhyVipDao vd = new zhyVipDao();
		vip.setId(id);
		vip.setVname(name);
		vip.setPhone(phone);
		vip.setQb(qb);
		vip.setJf(jf);
		vip.setAddr(addr);
		vip.setJb(jb);
		vip.setDtime(dtime);
		int res = 0;
		res = vd.update(vip,id);
		if(res>0){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改成功');location.href='zhyQuery';</script>");
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改失败');history.go(-1);</script>");
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
