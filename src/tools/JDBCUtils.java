package tools;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 此类是封装JDBC连接的工具类
 * 
 * 功能：
 * 1、获取连接
 * 2、释放资源
 *
 */
public class JDBCUtils {
	/**
	 * 功能：获取可用的连接对象
	 * @return 连接
	 * @throws Exception
	 */
	
	public static Connection getConnection(){
		
		try {
			String driver ="com.mysql.cj.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306/gjp?rewriteBatchedStatements=true";
			String url = "jdbc:mysql://localhost:3306/gjp?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
			String user = "root";
			String password = "123456";
			//1.注册驱动
			Class.forName(driver);
			//默认是使用 DriverManager驱动管理类 获取连接 ，效率低，不推荐使用
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 功能：释放资源
	 * @param set
	 * @param statement
	 * @param connection
	 * @throws Exception
	 */
	public static void close(ResultSet set,Statement statement,Connection connection){
		try {
			if (set!=null) {
				set.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
