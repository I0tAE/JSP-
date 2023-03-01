package zhy.service;

import java.sql.*;

public class MySqlConn {
	private String Driver = "com.mysql.jdbc.Driver";
	private String mysql = "jdbc:mysql://localhost:3306/zhydb?useUnicode=true&characterEncoding=gbk&mysqlEncoding=utf8";
	private String admin = "root";
	private String pw = "123456";
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	public void getConnection(){
		try{
			Class.forName(Driver);
			conn = DriverManager.getConnection(mysql, admin, pw);
		}catch(Exception e){
			System.out.println("connection fail");
			e.printStackTrace();
		}
	}
	public ResultSet doQuery(String sql, Object[] param){
		this.getConnection();
		try{
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<param.length; i++){
				pstmt.setObject(i+1, param[i]);
			}
			rs = pstmt.executeQuery();
		}catch(Exception e){
			System.out.println("doQuery fail");
			e.printStackTrace();
		}
		return this.rs;
	}
	public int doUpate(String sql, Object[] param){
	   	int res = 0;
    	this.getConnection();
    	try{
    		pstmt = conn.prepareStatement(sql);
    		for(int i=0; i<param.length; i++)
    			pstmt.setObject(i+1, param[i]);
    		res = pstmt.executeUpdate();
    	}catch(Exception e){
    		System.out.println("doquery fail!");
    		e.printStackTrace();
    	}
    	return res;
	}
	public void close(){
		try{
		if(conn!=null)
			conn.close();
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
