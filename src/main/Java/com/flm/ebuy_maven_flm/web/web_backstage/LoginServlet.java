package com.flm.ebuy_maven_flm.web.web_backstage;

import com.flm.ebuy_maven_flm.dao.AdminDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/admin/login")
public class LoginServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String path=request.getContextPath();
		String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		HttpSession session=request.getSession();
		
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名:"+username+"密码："+password);
		if (new AdminDao().login(username, password)) {
			session.setAttribute("username", username);
			
			response.sendRedirect(basePath+"jsp/admin/main.html");

		} else {
		//	System.out.println("密码或用户名错误！");
		
			response.sendRedirect(basePath+"jsp/admin/login.jsp");
		}
		
		
	}

	
}