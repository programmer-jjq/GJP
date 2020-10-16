package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ZhangWuDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建ZhangWuDao对象
		ZhangWuDao zwd = new ZhangWuDao();
		//获取addZhangWu.jsp中表单输入的数据
		String zwidSTR = request.getParameter("zwid");
		//将用户输入的zwidSTR转换为int类型
		int zwid = Integer.parseInt(zwidSTR);
		String flname= request.getParameter("flname");
		String moneySTR = request.getParameter("money");
		//将用户输入的moneySTR转换为double类型
		Double money = Double.valueOf(moneySTR);
		String zhanghu = request.getParameter("zhanghu");
		String createtime = request.getParameter("createtime");
		String description = request.getParameter("description");
		
		//调用ZhangWuDao的addZhangWu方法，返回update受影响的行数
		int update = zwd.addZhangWu(zwid,flname, money, zhanghu, createtime, description);
		//设定session的ID值，判断进行什么操作  如果id=1,进行添加的提示信息
		request.getSession().setAttribute("id",1);
		//存入session中
		request.getSession().setAttribute("update",update);
		//进行跳转
		ServletContext application = this.getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/jsp/alter.jsp");
		rd.forward(request,response);
	}

}
