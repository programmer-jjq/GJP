package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import domain.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到从login.jsp表单传来的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//创建AdminDao对象
		AdminDao admindao = new AdminDao();
		//根据username值进行数据库查询并返回admin对象
		Admin admin;
		try {
			//调用 login()方法
			admin = admindao.login(username);
			//定义变量，存储提示信息
			String msg = null;
			//获取session对象
			HttpSession session = request.getSession();
			//获取 ServletContext对象
			ServletContext context = getServletContext();
			
			if(admin==null) {
				//没有查询到用户，返回信息
				msg = "不存在该用户，请返回重试！";
				//将错误信息存入session中
				session.setAttribute("msg", msg);
				//服务器跳转
				RequestDispatcher rd = context.getRequestDispatcher("/jsp/login_error.jsp");
				rd.forward(request,response);
			}else{
			//查询到用户名存在，返回对象	
				//将表单的password和查询到的对象的password比对
				if(!password.equals(admin.getPassword())){
					msg = "密码错误，请返回重试！";
					//将错误信息存入session中
					session.setAttribute("msg", msg);
					//服务器跳转
					RequestDispatcher rd = context.getRequestDispatcher("/jsp/login_error.jsp");
					rd.forward(request,response);
				}else{
					//用户名存在，并且password比对成功，登录成功
					//将该admin对象存入session中
					
					//这里不需要使用 请求转发，直接使用请求重定向即可
					request.getSession().setAttribute("admin",admin);
					response.sendRedirect("/GJP/jsp/main.jsp");
					
					//？？？	
					//RequestDispatcher rd = context.getRequestDispatcher("/jsp/main.jsp");
					//rd.forward(request,response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
