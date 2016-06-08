package com.cslg.OfficeControl.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Service.ControllerService;
import com.cslg.OfficeControl.Service.ControllerServiceImpl;
import com.cslg.OfficeControl.Service.UserService;
import com.cslg.OfficeControl.Service.UserServiceImpl;
import com.cslg.OfficeControl.Util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class ControllerAction implements ModelDriven<Controller>{

	private Controller controller;
	private List<Controller> controllers;
	private ControllerService ctlservice = new ControllerServiceImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private int beginPage=1;	//默认从第�?页开�?
	private int everyPage = 3;	//每页显示10�?
	@Override
	public Controller getModel() {
		if(controller == null){
			controller = new Controller();
		}
		return controller;
	}
	
	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public List<Controller> getControllers() {
		return controllers;
	}

	public void setControllers(List<Controller> controllers) {
		this.controllers = controllers;
	}
	
	public String showAll(){ // NOPMD by john on 6/5/16 12:52 PM
		Page page = ctlservice.getPage(beginPage, everyPage);
		ActionContext.getContext().getValueStack().set("page", page);
		return "showAllSuccess";
	}
	
	public String showUser(){
		User user = (User) request.getSession().getAttribute("user");
		controllers = ctlservice.findAllByUerId(user.getId());
		return "showUserSuccess";
	}
	
	public String delete(){
		ctlservice.deleteController(controller.getId());
		return "deleteControllerSuccess";
	}
	
	public String showAdd(){
		UserService ctlservice = new UserServiceImpl();
		List<User> users = ctlservice.showAll();
		ActionContext.getContext().getValueStack().set("users", users); 
		return "showAddControllerSuccess";
	}
	
	public String add() {
		ctlservice.add(controller);
		return "addSuccess";
	}
	public String edit(){
		ctlservice.edit(controller);
		return "editControllerSuccess";
	}
	public String update(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/"); 
		String savePath = realPath + "\\code.xml";
		Controller orig = ctlservice.findOneById(controller.getId());
		ctlservice.update(controller);
		ctlservice.addOrder(controller, orig,savePath);
		return "updateControllerSuccess";
	}
}
