package com.cslg.OfficeControl.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.Service.ControllerService;
import com.cslg.OfficeControl.Service.ControllerServiceImpl;

/**
 * Servlet implementation class UpdateCtrl
 */
@WebServlet("/UpdateCtrl")
public class UpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerService ctlservice = new ControllerServiceImpl();
	private Controller controller = new Controller();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		String savePath = realPath + "\\code.xml";
		String name = request.getParameter("name");
		int kind = Integer.parseInt(request.getParameter("kind"));
		int status =Integer.parseInt( request.getParameter("status"));
		int temp= Integer.parseInt(request.getParameter("temp"));
		
		controller.setName(name);
		controller.setKind(kind);
		controller.setStatus(status);
		controller.setTemp(temp);
		
		Controller orig = ctlservice.findOneByName(name);
		ctlservice.updateByName(controller);
		ctlservice.addOrder(controller, orig,savePath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
