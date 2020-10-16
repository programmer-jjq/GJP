package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.ZhangWuDao;
import domain.ZhangWu;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到selectZhangWu.jsp表单传来的  choice的value值
		String choice = request.getParameter("choice");
		//创建ZhangWuDao对象
		ZhangWuDao zwd = new ZhangWuDao();
		//获取 ServletContext 上下文对象
		ServletContext context = this.getServletContext();
		
		//根据selectZhangWu表单选择的choice的value值进行不同的功能
		if(choice.equals("all")){
			
			//调用ZhangWuDao的selectAll方法，返回所有账务的列表
			ArrayList<ZhangWu> list = zwd.selectAll();
			//放入session中，取名为zwlist
			HttpSession session = request.getSession();
			session.setAttribute("zwlist", list);	
			//(请求转发)服务器内跳转
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/selectAll.jsp");
			rd.forward(request, response);
			
		}else if(choice.equals("id")){
			
			//获取表单输入的根据id查询的id值
			String zwidSTR = request.getParameter("id");
			//将用户输入的zwidSTR转换成int类型
			int zwid = Integer.parseInt(zwidSTR);
			//调用ZhangWuDao的selectByzwid方法，返回查询的账务信息
			ZhangWu zw = zwd.selectByzwid(zwid);
			//放入session中，取名为zhangwu
			request.getSession().setAttribute("zhangwu", zw);
			//服务器内跳转
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/selectByzwid.jsp");
			rd.forward(request,response);
			
		}else if(choice.equals("date")){
			
			//获取表单根据date查询的开始和结束的date值
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			//调用ZhangWuDao的selectBydate方法，返回查询的账务信息
			ArrayList<ZhangWu> zwlist = zwd.selectBydate(startdate, enddate);
			//放入session中，取名为zwlist
			HttpSession session = request.getSession();
			session.setAttribute("zwlist", zwlist);
			session.setAttribute("startdate", startdate);
			session.setAttribute("enddate", enddate);

			//服务器内跳转
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/selectBydate.jsp");
			rd.forward(request, response);

		}
	}
	
}




