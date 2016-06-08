package com.cslg.OfficeControl.Action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Service.UserService;
import com.cslg.OfficeControl.Service.UserServiceImpl;
import com.cslg.OfficeControl.Util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User> {
	private User user;
	private String message;
	private List<User> users;
	private UserService userService = new UserServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	private int beginPage=1;	//默认从第一页开始
	private int everyPage = 3;	//每页显示10个
	
	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public User getModel() {
		if(user == null){
			user = new User();
		}
		return user;
	}
	
	public String save(){
		if(userService.saveUser(user)){
			message = "信息保存成功！";
		}else {
			message = "信息保存失败，请重试！";
		}
		return "saveResult";
	}
	
	public String showAll(){
		Page page = userService.getPage(beginPage, everyPage);
		ActionContext.getContext().getValueStack().set("page", page);
		return "showAll";
	}
	
	public String showSave(){
		user = userService.findById(user.getId());
		return "showSaveUser";
	}
	
	public String update(){
		if(userService.updateUser(user)){
			request.getSession().setAttribute("user", user);
			message = "信息修改成功！";
		}else {
			message = "信息修改失败，请重试！";
		}
		return "updateResult";
	}
	
	public String delete(){
		userService.deleteById(user.getId());
		return "delteSuccess";
	}
	
	public String add(){
		userService.addUser(user);
		return "addSuccess";
	}

}
