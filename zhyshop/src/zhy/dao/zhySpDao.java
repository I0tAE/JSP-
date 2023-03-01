package zhy.dao;

import zhy.entity.zhySp;
import zhy.entity.zhyVip;
import zhy.service.MySqlConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class zhySpDao {
	ResultSet rs = null;
	MySqlConn db = new MySqlConn();
	int res = 0;
	public ArrayList<zhySp> Query(String sql,Object[] param){
		ArrayList<zhySp> sps= new ArrayList<zhySp>();
		rs = db.doQuery(sql,param);
		try {
			while(rs.next()){
				zhySp sp = new zhySp();
				sp.setId(rs.getInt("zhyid"));
				sp.setNc(rs.getString("zhync"));
				sp.setDw(rs.getString("zhydw"));
				sp.setTxm(rs.getString("zhytxm"));
				sp.setJj(rs.getDouble("zhyjinjia"));
				sp.setMj(rs.getDouble("zhymj"));
				sp.setPzk(rs.getDouble("zhypzk"));
				sp.setBzk(rs.getDouble("zhybzk"));
				sp.setHzk(rs.getDouble("zhyhzk"));
				sp.setRkt(rs.getString("zhyrkt"));
				sp.setKc(rs.getInt("zhykc"));
				sp.setBz(rs.getString("zhybz"));
				sps.add(sp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sps;
	}
	public int count(){
		rs = db.doQuery("select count(*) from zhysp", new Object[]{});
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
	public int addsp(zhySp sp){
		res = db.doUpate("insert into zhysp(zhync,zhydw,zhytxm,zhyjinjia,zhymj,zhypzk,zhybzk,zhyhzk,zhyrkt,zhybz) value(?,?,?,?,?,?,?,?,now(),?)", 
				new Object[]{sp.getNc(),sp.getDw(),sp.getTxm(),sp.getJj(),sp.getMj(),sp.getPzk(),sp.getBzk(),sp.getHzk(),sp.getBz()});
		return res;
	}
	public zhySp QueryByid(String id){
		zhySp sp = new zhySp();
		rs = db.doQuery("select *from zhysp where zhyid=?", new Object[]{id});
		try {
			if(rs.next()){
			sp.setId(rs.getInt("zhyid"));
			sp.setNc(rs.getString("zhync"));
			sp.setDw(rs.getString("zhydw"));
			sp.setTxm(rs.getString("zhytxm"));
			sp.setJj(rs.getDouble("zhyjinjia"));
			sp.setMj(rs.getDouble("zhymj"));
			sp.setPzk(rs.getDouble("zhypzk"));
			sp.setBzk(rs.getDouble("zhybzk"));
			sp.setHzk(rs.getDouble("zhyhzk"));
			sp.setKc(rs.getInt("zhykc"));
		    sp.setRkt(rs.getString("zhyrkt"));
		    sp.setBz(rs.getString("zhybz"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}
	public int updatesp(zhySp s, String id){
		res = db.doUpate("update zhysp set zhync=?, zhydw=?,zhytxm=?,zhyjinjia=?,zhymj=?,zhypzk=?,zhybzk=?,zhyhzk=?,zhybz=?,zhykc=? where zhyid=?", 
				new Object[]{s.getNc(),s.getDw(),s.getTxm(),s.getJj(),s.getMj(),s.getPzk(),s.getBzk(),s.getHzk(),s.getBz(),s.getKc(),id});
		return res;
	}
	public int deletesp(String id){
		res = db.doUpate("delete from zhysp where zhyid=?", new Object[]{id});
		return res;
	}
	public int tjkc(int sum, String id){
		res = db.doUpate("update zhysp set zhykc=? where zhyid=?", 
				new Object[]{sum,id});
		return res;
	}
	public int QueryBytxm0(String txm,int sl){
		rs = db.doQuery("select *from zhysprk where zhytxm=? and zhyrole=0", new Object[]{txm});
		try {
			if(rs.next()){
				zhySp sp3 =new zhySp();
				sp3.setId(rs.getInt("zhyid"));
				if(sl==0)
					sp3.setKc(rs.getInt("zhysl")+1);
				else
					sp3.setKc(sl);
				db.doUpate("update zhysprk set zhysl=? where zhyid=? and zhyrole=0", new Object[]{sp3.getKc(),sp3.getId()});
				res=1;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public zhySp QueryBytxm(String sql,Object[] param){
		rs = db.doQuery(sql,param);
		zhySp sp1 = new zhySp();
		try {
			if(rs.next()){
			sp1.setId(rs.getInt("zhyid"));
			sp1.setNc(rs.getString("zhync"));
			sp1.setDw(rs.getString("zhydw"));
			sp1.setTxm(rs.getString("zhytxm"));
			sp1.setJj(rs.getDouble("zhyjinjia"));
			sp1.setMj(rs.getDouble("zhymj"));
			sp1.setPzk(rs.getDouble("zhypzk"));
			sp1.setBzk(rs.getDouble("zhybzk"));
			sp1.setHzk(rs.getDouble("zhyhzk"));
			sp1.setKc(rs.getInt("zhykc"));
		    sp1.setRkt(rs.getString("zhyrkt"));
		    sp1.setBz(rs.getString("zhybz"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp1;
	}
	public int addsprk(zhySp sp){
		res = db.doUpate("insert into zhysprk(zhyid,zhymc,zhydw,zhytxm,zhyjj,zhymj,zhyzk,zhyrole,zhydtime) value(?,?,?,?,?,?,?,0,now())", 
				new Object[]{sp.getId(),sp.getNc(),sp.getDw(),sp.getTxm(),sp.getJj(),sp.getMj(),sp.getPzk()});
		return res;
	}
	public ArrayList<zhySp> Query2(String sql,Object[] param){
		ArrayList<zhySp> spss= new ArrayList<zhySp>();
		rs = db.doQuery(sql,param);
		try {
			while(rs.next()){
				zhySp sp = new zhySp();
				sp.setId(rs.getInt("zhyid"));
				sp.setNc(rs.getString("zhymc"));
				sp.setDw(rs.getString("zhydw"));
				sp.setTxm(rs.getString("zhytxm"));
				sp.setJj(rs.getDouble("zhyjj"));
				sp.setMj(rs.getDouble("zhymj"));
				sp.setPzk(rs.getDouble("zhyzk"));
				sp.setKc(rs.getInt("zhysl"));
				spss.add(sp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spss;
	}
	public int addsl(zhySp sp){
		res = db.doUpate("update zhysprk set zhysl=? where zhyid=? and zhyrole=0", 
				new Object[]{sp.getKc(),sp.getId()});
		return res;
	}
	public int deletesp1(String id){
		res = db.doUpate("delete from zhysprk where zhyid=? and zhyrole=0", new Object[]{id});
		return res;
	}
	public int deletelsbyid(String id,String role){
		res = db.doUpate("delete from zhysprk where zhyid=? and zhyrole=?", new Object[]{id,role});
		return res;
	}
	public int deletels(String role){
		res = db.doUpate("delete from zhysprk where zhyrole=?", new Object[]{role});
		return res;
	}
	public int delete(){
		res = db.doUpate("delete from zhysprk where zhyrole=0", new Object[]{});
		return res;
	}
	public int rk(ArrayList<zhySp> spss){
		for (zhySp sp : spss) {
			db.doUpate("update zhysp set zhykc=zhykc+? where zhyid=?", new Object[]{sp.getKc(),sp.getId()});
			db.doUpate("insert into zhyrkqk(zhyid,zhyspid,zhymc,zhydw,zhytxm,zhyjj,zhymj,zhyzk,zhysl,zhydtime) value(DATE_FORMAT(NOW(),'%Y%m%d%k%i%s'),?,?,?,?,?,?,?,?,now())", 
					new Object[]{sp.getId(),sp.getNc(),sp.getDw(),sp.getTxm(),sp.getJj(),sp.getMj(),sp.getPzk(),sp.getKc()});
		}
		res = db.doUpate("delete from zhysprk", new Object[]{});
		return res;
	}
	public String zk2(zhySp sp,String phone){
		double zk1=0;
		String jb="普通会员";
		ResultSet rs1=null;
		rs = db.doQuery("select * from zhyvip where zhyphone=?", new Object[]{phone});
		try {
			if(rs.next()){
				jb=rs.getString("zhyjb");
				if(jb.equals("普通会员")){
					rs1 = db.doQuery("select *from zhysp where zhyid=?", new Object[]{sp.getId()});
					if(rs1.next())
				zk1 = rs1.getDouble("zhypzk");
				sp.setPzk(zk1);
				}
				else if(jb.equals("黄金会员")){
					rs1 = db.doQuery("select *from zhysp where zhyid=?", new Object[]{sp.getId()});
					if(rs1.next())
				zk1 = rs1.getDouble("zhybzk");
					sp.setPzk(zk1);
				}
				else if(jb.equals("钻石会员")){
					rs1 = db.doQuery("select *from zhysp where zhyid=?", new Object[]{sp.getId()});
					if(rs1.next())
						zk1 = rs1.getDouble("zhyhzk");
					sp.setPzk(zk1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jb;
	}
}
