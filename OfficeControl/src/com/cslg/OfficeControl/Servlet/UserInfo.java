package com.cslg.OfficeControl.Servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;

import com.cslg.OfficeControl.DAO.UserDAO;
import com.cslg.OfficeControl.DAO.UserDAOImpl;
import com.cslg.OfficeControl.PO.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		try {
			User user = userDAO.findUserByUserName(userName);
	    	PropertyDescriptor[] pd = PropertyUtils.getPropertyDescriptors(user);
	    	out.println("{");
	    	for(int i=0;i<pd.length;i++){
	    		if(i<pd.length-1){
	    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(user)+"\",");
		    	}
	    		else{
	    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(user)+"\"");
	    		}
	    	}
	    	out.println("}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.close();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
