package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Admin;
import domain.ZhangWu;
import tools.JDBCUtils;


public class ZhangWuDao {
	
	/*
	 * 功能: 查询所有账务
	 */
	
	public static ArrayList<ZhangWu> selectAll() {
		//初始化局部变量
		Connection connection = null;
		ArrayList<ZhangWu> zwlist = new ArrayList<ZhangWu>();
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "SELECT * FROM gjp_zhangwu";
			PreparedStatement stat = connection.prepareStatement(sql);
			ResultSet set = stat.executeQuery();
			//遍历结果集
			while(set.next()){
				ZhangWu zhangwu = new ZhangWu();
				zhangwu.setZwid(set.getInt("zwid"));
				zhangwu.setFlname(set.getString("flname"));
				zhangwu.setMoney(set.getDouble("money"));
				zhangwu.setZhangHu(set.getString("zhanghu"));
				zhangwu.setCreatetime(set.getString("createtime"));
				zhangwu.setDescription(set.getString("description"));
				//将查询到的信息封装为ZhangWu对象，添加到集合中
				zwlist.add(zhangwu);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return zwlist;
	}
	
	
	/*
	 * 功能：根据账务ID查询账务信息
	 * 
	 */
	
	//返回一个ZhangWu类型的对象
	public ZhangWu selectByzwid(int zwid) {
		ZhangWu zhangwu = null;
		Connection connection = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "SELECT * FROM gjp_zhangwu where zwid=?";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setInt(1, zwid);
			ResultSet set = stat.executeQuery();
			//遍历结果集
			while(set.next()){
				zhangwu = new ZhangWu();
				zhangwu.setZwid(set.getInt("zwid"));
				zhangwu.setFlname(set.getString("flname"));
				zhangwu.setMoney(set.getDouble("money"));
				zhangwu.setZhangHu(set.getString("zhanghu"));
				zhangwu.setCreatetime(set.getString("createtime"));
				zhangwu.setDescription(set.getString("description"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return zhangwu;
	}
	
	/*
	 * 功能：根据账务日期查询账务信息
	 */
	
	//返回一个ZhangWu类型的对象
	//传递2个日期字符串 开始日期 startdate 和 结束日期 enddate
	public static ArrayList<ZhangWu> selectBydate(String startdate,String enddate) {
		//初始化局部变量
		Connection connection = null;
		ArrayList<ZhangWu> zwlist = new ArrayList<ZhangWu>();
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "SELECT * FROM gjp_zhangwu where createtime between ? and ? ";
			PreparedStatement stat = connection.prepareStatement(sql);
			//设置占位符的值
			stat.setString(1, startdate);
			stat.setString(2, enddate);
			ResultSet set = stat.executeQuery();
			//遍历结果集
			while(set.next()){
				ZhangWu zhangwu = new ZhangWu();
				zhangwu.setZwid(set.getInt("zwid"));
				zhangwu.setFlname(set.getString("flname"));
				zhangwu.setMoney(set.getDouble("money"));
				zhangwu.setZhangHu(set.getString("zhanghu"));
				zhangwu.setCreatetime(set.getString("createtime"));
				zhangwu.setDescription(set.getString("description"));
				//将查询到的信息封装为ZhangWu对象，添加到集合中
				zwlist.add(zhangwu);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return zwlist;
	}
	
	/*
	 * 功能：添加账务
	 */
	
	public int addZhangWu(int zwid,String flname,double money,String zhanghu,String createtime,String description) {
		int update = 0;
		Connection connection = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "insert into gjp_zhangwu(zwid,flname,money,zhanghu,createtime,description) values(?,?,?,?,?,?)";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setInt(1, zwid);
			stat.setString(2,flname);
			stat.setDouble(3, money);
			stat.setString(4, zhanghu);
			stat.setString(5, createtime);
			stat.setString(6, description);
			//返回受影响的行数
			update = stat.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return update;
	}
	
	/*
	 * 功能：删除账务
	 */
	
	public int deleteZhangWu(int zwid) {
		int update = 0;
		Connection connection = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "delete from gjp_zhangwu where zwid = ?";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setInt(1,zwid);
			//返回受影响的行数
			update = stat.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return update;
	}
	/*
	 * 功能：编辑账务
	 */
	
	public int editZhangWu(String newflname,double newmoney,String newzhanghu,String newcreatetime,String newdescription,int zwid) {
		int update = 0;
		Connection connection = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid = ?";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setString(1,newflname);
			stat.setDouble(2,newmoney);
			stat.setString(3,newzhanghu);
			stat.setString(4,newcreatetime);
			stat.setString(5,newdescription);
			stat.setInt(6,zwid);
			//返回受影响的行数
			update = stat.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭连接
			JDBCUtils.close(null, null, connection);
		}
		return update;
	}
}