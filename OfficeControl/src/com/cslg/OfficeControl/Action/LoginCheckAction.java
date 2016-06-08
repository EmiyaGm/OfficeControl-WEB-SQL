package com.cslg.OfficeControl.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Service.UserService;
import com.cslg.OfficeControl.Service.UserServiceImpl;
import com.cslg.OfficeControl.Util.MD5;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginCheckAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService = new UserServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		if(user == null){
			user = new User();
		}
		return user;
	}
	
	public String execute() throws Exception {
		user.setPassword(MD5.md5(user.getPassword()));
		user = userService.login(user);
		if(user != null){
			request.getSession().setAttribute("user", user);
			return SUCCESS;
		}else {
			request.setAttribute("errMessage","用户名或密码错误");
			return ERROR;
		}
    }
}
