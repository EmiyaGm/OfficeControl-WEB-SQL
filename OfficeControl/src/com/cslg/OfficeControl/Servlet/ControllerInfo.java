package com.cslg.OfficeControl.Servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;

import com.cslg.OfficeControl.DAO.ControllerDAO;
import com.cslg.OfficeControl.DAO.ControllerDAOImpl;
import com.cslg.OfficeControl.PO.Controller;

/**
 * Servlet implementation class ControllerInfo
 */
@WebServlet("/ControllerInfo")
public class ControllerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerDAO controllerDAO = new ControllerDAOImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
	    int userId = Integer.parseInt(request.getParameter("userId"));
		try {
			List<Controller> controller = controllerDAO.findControllerByUser(userId);
			out.println("[");
			if(controller!=null){
			for(int j=0;j<controller.size();j++){
				Controller controllerx = controller.get(j);
				PropertyDescriptor[] pd = PropertyUtils.getPropertyDescriptors(controllerx);
				out.println("{");
				for(int i=0;i<pd.length;i++){
		    		if(i<pd.length-1){
		    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(controllerx)+"\",");
			    	}
		    		else{
		    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(controllerx)+"\"");
		    		}
		    	}
				if(j<controller.size()-1){
					out.println("},");
				}
				else{
					out.println("}");
				}
	    	}
			}
			out.println("]");
		}catch (Exception e) {
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
