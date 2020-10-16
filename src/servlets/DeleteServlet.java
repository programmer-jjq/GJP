package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ZhangWuDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建ZhangWuDao对象
		ZhangWuDao zwd = new ZhangWuDao();
		//获取deleteZhangWu.jsp中表单输入的数据
		String zwidSTR= request.getParameter("zwid");
		//将用户输入的moneySTR转换为double类型
		int zwid = Integer.parseInt(zwidSTR);
		//调用ZhangWuDao的deleteZhangWu方法，返回delupdate受影响的行数
		int delupdate = zwd.deleteZhangWu(zwid);
		//设定session的ID值，判断进行什么操作  如果id=2,进行删除的提示信息
		request.getSession().setAttribute("id",2);
		//存入session中
		request.getSession().setAttribute("delupdate",delupdate);
		//进行跳转
		ServletContext application = this.getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/jsp/alter.jsp");
		rd.forward(request,response);
	}

}
