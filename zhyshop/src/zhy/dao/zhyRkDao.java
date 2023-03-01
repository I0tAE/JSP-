package zhy.dao;

import zhy.entity.zhyRkqk;
import zhy.service.MySqlConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class zhyRkDao {
ResultSet rs=null;
int res =0;
MySqlConn db= new MySqlConn();

public ArrayList<zhyRkqk> Query(String sql,Object[] param){
	rs = db.doQuery(sql, param);
	ArrayList<zhyRkqk> rks=new ArrayList<zhyRkqk>();
	try {
		while(rs.next()){
			zhyRkqk rk = new zhyRkqk();
			rk.setId(rs.getString("zhyid"));
			rk.setSpjj(rs.getDouble("sum(zhyjj)"));
			rk.setSpmj(rs.getDouble("sum(zhymj)"));
			rk.setSpsl(rs.getInt("sum(zhysl)"));
			rk.setSptime(rs.getString("zhydtime"));
			rks.add(rk);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rks;
}
public int count(String sql, Object[] param){
	rs = db.doQuery(sql, param);
	try {
		if(rs.next()){
			res = rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}
public ArrayList<zhyRkqk> Query2(String sql,Object[] param){
	rs = db.doQuery(sql, param);
	ArrayList<zhyRkqk> rks=new ArrayList<zhyRkqk>();
	try {
		while(rs.next()){
			zhyRkqk rk = new zhyRkqk();
			rk.setId(rs.getString("zhyid"));
			rk.setSpid(rs.getInt("zhyspid"));
			rk.setSpmc(rs.getString("zhymc"));
			rk.setSpjj(rs.getDouble("zhyjj"));
			rk.setSpmj(rs.getDouble("zhymj"));
			rk.setSpsl(rs.getInt("zhysl"));
			rk.setSptime(rs.getString("zhydtime"));
			rks.add(rk);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rks;
}
}
