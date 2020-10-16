package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import domain.Admin;
import tools.JDBCUtils;

public class AdminDao {
	
	//返回一个Admin类型的对象
	public Admin login(String username) throws SQLException {
		Admin admin = null;
		Connection connection = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			String sql = "select * from admin where username = ?";
			PreparedStatement stat = connection.prepareStatement(sql);
			//根据表单输入的用户名到数据库查询
			stat.setString(1, username);
			ResultSet set = stat.executeQuery();
			//遍历结果集
			while(set.next()){
				//查询用户名存在，创建一个admin对象
				admin = new Admin();
				//将查询到的值赋给该对象
				admin.setId(set.getInt(1));
				admin.setUsername(set.getString(2));
				admin.setPassword(set.getString(3));
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(null, null, connection);
		}
		return admin;
	}
}
