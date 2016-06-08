package com.cslg.OfficeControl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cslg.OfficeControl.DAO.UserDAO;
import com.cslg.OfficeControl.DAO.UserDAOImpl;
import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Util.MD5;

@WebServlet("/loginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAOImpl();   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User u;
		try {
			u = userDAO.findUserByUserName(userName);
			if(u==null)  {
				out.println("error");
				return;
			}
			if(u.getPassword().equals(MD5.md5(password))){
				out.println(u.getId());
			}else {
				out.println("error");
			}
		}
		 catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			out.close();
		}
	}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
