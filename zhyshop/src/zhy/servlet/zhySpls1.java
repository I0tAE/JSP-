package zhy.servlet;

import zhy.dao.zhySpDao;
import zhy.entity.zhySp;
import zhy.service.MySqlConn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zhySpls1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public zhySpls1() {
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
		String txm = (String) request.getSession().getAttribute("txm");
		String role = (String) request.getSession().getAttribute("role");
		MySqlConn db = new MySqlConn();
		int sl=0;
		zhySpDao sd = new zhySpDao();
		zhySp sp2 =new zhySp();
		ResultSet rs =null;
		ResultSet rs1 =null;
		double zk = 10;
		int res = 0;
		if(request.getParameter("txm")!=null)
			txm = request.getParameter("txm");
		if(request.getParameter("sl")!=null)
			sl = Integer.parseInt(request.getParameter("sl"));
		rs = db.doQuery("select *from zhysp where zhytxm=?", new Object[]{txm});
		try {
			if(rs.next()){
				rs1 = db.doQuery("select *from zhysprk where zhytxm=? and zhyrole=?", new Object[]{txm,role});
				if(rs1.next()){
					if(sl!=0){
						db.doUpate("update zhysprk set zhysl=? where zhytxm=? and zhyrole=?", new Object[]{sl,txm,role});
					}else{
						db.doUpate("update zhysprk set zhysl=zhysl+1 where zhytxm=? and zhyrole=?", new Object[]{txm,role});
					}
				}else{
					sp2 = sd.QueryBytxm("select *from zhysp where zhytxm=?", new Object[]{txm});
					db.doUpate("insert into zhysprk(zhyid,zhymc,zhydw,zhytxm,zhyjj,zhymj,zhyzk,zhyrole,zhydtime) value(?,?,?,?,?,?,?,?,now())", 
							new Object[]{sp2.getId(),sp2.getNc(),sp2.getDw(),sp2.getTxm(),sp2.getJj(),sp2.getMj(),sp2.getPzk(),role});;
				}
			}
			else{
				res=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==1){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('没有该商品');history.go(-1);</script>");
		}
/*		rs = db.doQuery("select *from zhysprk where zhytxm=? and zhyrole=?", new Object[]{txm,role});
			try {
				if(rs.next()){
					zhySp sp3 =new zhySp();
					sp3.setId(rs.getInt("zhyid"));
					if(sl==0)
						sp3.setKc(rs.getInt("zhysl")+1);
					else
						sp3.setKc(sl);
					db.doUpate("update zhysprk set zhysl=? where zhyid=? and zhyrole=?", new Object[]{sp3.getKc(),sp3.getId(),role});
					res=1;
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(res!=1){
				sp2 = sd.QueryBytxm("select *from zhysp where zhytxm=?", new Object[]{txm});
				if(sp2.getId()!=0){
					res  = db.doUpate("insert into zhysprk(zhyid,zhymc,zhydw,zhytxm,zhyjj,zhymj,zhyzk,zhyrole,zhydtime) value(?,?,?,?,?,?,?,?,now())", 
							new Object[]{sp2.getId(),sp2.getNc(),sp2.getDw(),sp2.getTxm(),sp2.getJj(),sp2.getMj(),sp2.getPzk(),role});;
				}
				else{
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().println("<script>alert('没有该商品');history.go(-1);</script>");
				}
				}*/
			response.sendRedirect("zhySpls2");
		
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
