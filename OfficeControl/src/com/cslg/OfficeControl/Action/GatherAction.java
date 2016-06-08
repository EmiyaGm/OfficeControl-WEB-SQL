package com.cslg.OfficeControl.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Service.GatherService;
import com.cslg.OfficeControl.Service.GatherServiceImpl;
import com.cslg.OfficeControl.Service.UserService;
import com.cslg.OfficeControl.Service.UserServiceImpl;
import com.cslg.OfficeControl.Util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class GatherAction implements ModelDriven<Gather> {

	private Gather gather;
	private List<Gather> gathers;
	private GatherService gatherService = new GatherServiceImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private int beginPage=1;	//默认从第一页开始
	private int everyPage = 3;	//每页显示10个
	
	@Override
	public Gather getModel() {
		if(gather == null){
			gather = new Gather();
		}
		return gather;
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

	public List<Gather> getGathers() {
		return gathers;
	}

	public void setGathers(List<Gather> gathers) {
		this.gathers = gathers;
	}
	
	public String showAll(){
		Page page = gatherService.getPage(beginPage, everyPage);
		ActionContext.getContext().getValueStack().set("page", page);
		return "showAllSuccess";
	}
	
	public String showUser(){
		User user = (User) request.getSession().getAttribute("user");
		gathers = gatherService.findAllByUerId(user.getId());
		return "showUserSuccess";
	}
	
	public String delete(){
		gatherService.deleteGather(gather.getId());
		return "deleteGatherSuccess";
	}
	
	public String showAdd(){
		UserService userService = new UserServiceImpl();
		List<User> users = userService.showAll();
		ActionContext.getContext().getValueStack().set("users", users);
		return "showAddGatherSuccess";
	}
	
	public String add() {
		gatherService.add(gather);
		return "addSuccess";
	}
	
	public String edit(){
		gatherService.edit(gather);
		return "editGatherSuccess";
	}

}
