package zhy.servlet;

import zhy.service.ExcelBook;
import zhy.service.MySqlConn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class zhyOutGoodsToExcel extends HttpServlet {
	private ServletConfig config;
	public final void init(ServletConfig config){
		this.config=config;
	}

	public void setConfig(ServletConfig config) {
		this.config = config;
	}
	/**
	 * Constructor of the object.
	 */
	public zhyOutGoodsToExcel() {
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

		String path="D:/商品信息.xls";
		ExcelBook eb = new ExcelBook();
		MySqlConn db = new MySqlConn();
		ResultSet rs = null;
		rs = db.doQuery("select * from zhysp", new Object[]{});
		eb.excelOut(path, rs, new Object[]{"商品编号","商品名称","商品单位","商品条形码","商品进价","商品售价","普通会员折扣","白金会员折扣","黄金会员折扣","商品库存","商品入库时间","商品备注"});
		SmartUpload up = new SmartUpload();
		try {
			up.initialize(config, request, response);
			up.downloadFile(path);
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
