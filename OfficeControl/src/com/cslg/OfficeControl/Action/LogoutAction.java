package com.cslg.OfficeControl.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);//防止创建Session 
		if(session != null && session.getAttribute("user")!=null){
				session.removeAttribute("user");
        } 
		return SUCCESS;
	}

}
