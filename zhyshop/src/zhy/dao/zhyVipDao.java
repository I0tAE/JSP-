package zhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zhy.entity.zhyVip;
import zhy.service.MySqlConn;

public class zhyVipDao {
ResultSet rs = null;
MySqlConn db = new MySqlConn();
int res = 0;
public ArrayList<zhyVip> Query(String sql, Object[] param){
	ArrayList<zhyVip> vips = new ArrayList<zhyVip>();
	try {
		rs = db.doQuery(sql, param);
		while(rs.next()){
			zhyVip vip = new zhyVip();
			vip.setId(rs.getString("zhyid"));
			vip.setVname(rs.getString("zhyvname"));
			vip.setPhone(rs.getString("zhyphone"));
			vip.setQb(rs.getString("zhyqb"));
			vip.setJf(rs.getString("zhyjf"));
			vip.setAddr(rs.getString("zhyaddr"));
			vip.setJb(rs.getString("zhyjb"));
			vip.setDtime(rs.getString("zhydtime"));
			vips.add(vip);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vips;
	
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
public int add(zhyVip v){
	res = db.doUpate("insert into zhyvip(zhyvname,zhyphone,zhyaddr,zhyjb,zhydtime) value(?,?,?,?,now())", 
			new Object[]{v.getVname(),v.getPhone(),v.getAddr(),v.getJb()});
	return res;
}
public int delete(String id){
	res = db.doUpate("delete from zhyvip where zhyid=?", new Object[]{id});
	return res;
}
public zhyVip queryByid(String id){
	zhyVip v = new zhyVip();
	rs = db.doQuery("select * from zhyVip where zhyid=?", new Object[]{id});
	try {
		if(rs.next()){
			v.setId(rs.getString("zhyid"));
			v.setVname(rs.getString("zhyvname"));
			v.setPhone(rs.getString("zhyphone"));
			v.setQb(rs.getString("zhyqb"));
			v.setJf(rs.getString("zhyjf"));
			v.setAddr(rs.getString("zhyaddr"));
			v.setJb(rs.getString("zhyjb"));
			v.setDtime(rs.getString("zhydtime"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return v;
}
public int update(zhyVip v, String id){
	res = db.doUpate("update zhyVip set zhyvname=?, zhyphone=?,zhyqb=?,zhyjf=?,zhyaddr=?,zhyjb=?,zhydtime=? where zhyid=?", 
			new Object[]{v.getVname(),v.getPhone(),v.getQb(),v.getJf(),v.getAddr(),v.getJb(),v.getDtime(),id});
	
	return res;
}
public int charge(double money, int score, String id){
	res = db.doUpate("update zhyVip set zhyqb=?,zhyjf=? where zhyid=?", 
			new Object[]{money,score,id});
	return res;
}
}
