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

import com.cslg.OfficeControl.DAO.GatherDAO;
import com.cslg.OfficeControl.DAO.GatherDAOImpl;
import com.cslg.OfficeControl.PO.Gather;

/**
 * Servlet implementation class GatherInfo
 */
@WebServlet("/GatherInfo")
public class GatherInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GatherDAO gatherDAO = new GatherDAOImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GatherInfo() {
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
			List<Gather> gather = gatherDAO.findGatherByUserId(userId);
			out.println("[");
			if(gather!=null){
			for(int j=0;j<gather.size();j++){
				Gather gatherx = gather.get(j);
				PropertyDescriptor[] pd = PropertyUtils.getPropertyDescriptors(gatherx);
				out.println("{");
				for(int i=0;i<pd.length;i++){
		    		if(i<pd.length-1){
		    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(gatherx)+"\",");
			    	}
		    		else{
		    			out.println("\""+pd[i].getName()+"\":\""+pd[i].getReadMethod().invoke(gatherx)+"\"");
		    		}
		    	}
				if(j<gather.size()-1){
					out.println("},");
				}
				else{
					out.println("}");
				}
	    	}
			}
			out.println("]");
		} catch (Exception e) {
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
