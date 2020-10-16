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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建ZhangWuDao对象
		ZhangWuDao zwd = new ZhangWuDao();
		//获取从editZhangWu.jsp表单传过来的数据
		String newflname = request.getParameter("newflname");
		String moneySTR = request.getParameter("newmoney");
		String newzhanghu = request.getParameter("newzhanghu");
		String newcreatetime = request.getParameter("newcreatetime");
		String newdescription = request.getParameter("newdescription");
		String zwidSTR = request.getParameter("zwid");
		//将表单输入的数据改变类型
		Double newmoney = Double.valueOf(moneySTR);
		int zwid = Integer.parseInt(zwidSTR);
		//调用ZhangWuDao的editZhangWu方法，返回editupdate受影响的行数
		int editupdate = zwd.editZhangWu(newflname, newmoney, newzhanghu, newcreatetime, newdescription, zwid);
		//设定session的ID值，判断进行什么操作  如果id=3,进行编辑的提示信息
		request.getSession().setAttribute("id",3);
		//存入session中
		request.getSession().setAttribute("editupdate",editupdate);
		//进行跳转
		ServletContext application = this.getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/jsp/alter.jsp");
		rd.forward(request,response);
	}

}
